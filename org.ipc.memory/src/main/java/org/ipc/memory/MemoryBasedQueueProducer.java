package org.ipc.memory;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.MappedByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/17/14
 * Time: 1:57 PM
 * 
 */
public class MemoryBasedQueueProducer extends AbstractMemoryBasedQueueEndpoint {

    private final int nbConsumers;

    public MemoryBasedQueueProducer(String channelName, int nbConsumers) throws IOException {
        super(channelName);
        this.nbConsumers = nbConsumers;
    }

    public void notifySend(OutputStream s) {
        SharedMemoryOutputStream stream = (SharedMemoryOutputStream)s;
        try {
            lock.lock();
            int tail = mem.getInt(tail_pos);
            tail = (tail + 1) & MASK_NUMBER_OF_BLOCKS;
            int head = mem.getInt(head_pos);
            while (tail == head) {
                lock.waitInterprocess2();
                tail = mem.getInt(tail_pos);
                tail = (tail + 1) & MASK_NUMBER_OF_BLOCKS;
                head = mem.getInt(head_pos);
            }
            int t = advanceTail();
            new Node(t, nbConsumers, stream.firstBlock.start, stream.firstBlock.lastPos);
            lock.broadcast();
        }
        finally {
            lock.unlock();
        }
    }

    public OutputStream getStreamToSendMessage() {
        return new SharedMemoryOutputStream(mem);
    }

    private Block getFreeBlock() {
        try {
            lock.lock();
            while (isEmptyStackOfEmptyBlock()) {
                lock.waitInterprocess2();
            }
            int index = getEmptyBlockFromStack();
            int p = BLOCKS_POSITION + (index << LOG_2_BLOCK_SIZE);
            Block block = new Block(p, BLOCK_SIZE);
            return block;
        }
        finally {
            lock.unlock();
        }
    }


    private class SharedMemoryOutputStream extends OutputStream {

        private MappedByteBuffer mem;

        private int currentPos;
        private int lastPos;

        Block currentBlock;
        Block firstBlock;

        private SharedMemoryOutputStream(MappedByteBuffer mem) {
            this.mem = mem;
            firstBlock = currentBlock = getFreeBlock();
            currentBlock.markAsFinal();
            currentPos = currentBlock.currentPos;
            lastPos = currentBlock.lastPos;
        }

        @Override
        public void write(int b) throws IOException {
            if (currentPos == lastPos) {
                // I need a new block
                Block block = getFreeBlock();
                currentBlock.setNext(block);
                currentBlock.lastPos = lastPos;
                currentBlock.saveLastAddr();
                currentBlock = block;
                currentBlock.markAsFinal();
                currentPos = currentBlock.currentPos;
                lastPos = currentBlock.lastPos;
            }
            mem.put(currentPos++, (byte) b);
        }

        @Override
        public void write(byte[] b) throws IOException {
            write(b, 0 , b.length);
        }

        @Override
        public void write(byte[] b, int off, int l) throws IOException {
            // TODO : some additional checks
            int n = l - off; // count to copy
            while (n > 0) {
                if (n >= (lastPos - currentPos))
                {
                    // copy what we can in the current block
                    int tmp = lastPos - currentPos; // remaining
                    mem.position(currentPos);
                    mem.put(b, off, tmp);
                    n = n - tmp; // new count to copy
                    off = tmp;
                    currentPos += tmp;

                    // I need a new block
                    Block block = getFreeBlock();
                    currentBlock.setNext(block);
                    currentBlock.lastPos = lastPos;
                    currentBlock.saveLastAddr();
                    currentBlock = block;
                    currentBlock.markAsFinal();
                    currentPos = currentBlock.currentPos;
                    lastPos = currentBlock.lastPos;
                }
                else {
                    mem.position(currentPos);
                    mem.put(b, off, n);
                    currentPos += n;
                    n = 0;
                }
            }
        }
    }
}

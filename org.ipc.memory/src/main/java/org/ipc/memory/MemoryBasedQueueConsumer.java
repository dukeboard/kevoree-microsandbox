package org.ipc.memory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/17/14
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class MemoryBasedQueueConsumer extends AbstractMemoryBasedQueueEndpoint {

    private int local_head = 0;

    public MemoryBasedQueueConsumer(String channelName) throws IOException {
        super(channelName);
        try {
            lock.lock();
            local_head = mem.getInt(head_pos);
        }finally {
            lock.unlock();
        }
    }

    public int waitForMessage() {
        int n = local_head;
        try {
            lock.lock();
            int tail = mem.getInt(tail_pos);
            while (local_head == tail) {
                lock.waitInterprocess();
                tail = mem.getInt(tail_pos);
            }
            local_head = (local_head + 1) % getQueueCapacity();
        } finally {
            lock.unlock();
        }
        return n;
    }

    public void notifyReception(int id) {
        try {
            lock.lock();
            Node node = new Node(id);
            node.incReaders();
            if (node.wasReadForAll()) {
//                decreaseQueueSize();
                advanceHead();
                node.freeUsedBlocks();
                lock.broadcast2();
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public InputStream getMessageInputStream(int id) {
        return new SharedMemoryInputStream(mem, id);
    }

    private class SharedMemoryInputStream extends InputStream {
        private int currentPos;
        private int lastPos;

        Block currentBlock;

        MappedByteBuffer mem;

        private SharedMemoryInputStream(MappedByteBuffer mem, int id) {
            currentBlock = getFirstBlock(id);
            currentPos = currentBlock.currentPos;
            lastPos = currentBlock.lastPos;
            this.mem = mem;
        }

        @Override
        public int read() throws IOException {
            if (currentPos == lastPos) {
                if (currentBlock.isFinal())
                    return -1;
                currentBlock = currentBlock.nextBlock();
                currentPos = currentBlock.currentPos;
                lastPos = currentBlock.lastPos;
            }
            int x = mem.get(currentPos++);
            if (x < 0) {
                x += 256;
            }
            return x;
        }

        @Override
        public boolean markSupported() {
            return false;
        }
    }

    private Block getFirstBlock(int msgId) {
        Node node = new Node(msgId);
        int start = node.getAddr();
        int end = node.getLastAddr();
        return new Block(start, end - start);
    }
}

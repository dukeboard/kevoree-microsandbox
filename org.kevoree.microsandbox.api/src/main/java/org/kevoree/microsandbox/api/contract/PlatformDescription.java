package org.kevoree.microsandbox.api.contract;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/8/13
 * Time: 2:02 PM
 *
 */
public class PlatformDescription {
    public final long availability_memory;
    public final long availability_sent;
    public final long availability_received;
    public final long availability_instr;
    public final long availability_write_disc;
    public final long availability_read_disc;

    public PlatformDescription(long availability_memory,
                               long availability_sent,
                               long availability_received,
                               long availability_instr,
                               long availability_write_disc,
                               long availability_read_disc) {
        this.availability_memory = availability_memory;
        this.availability_sent = availability_sent;
        this.availability_received = availability_received;
        this.availability_instr = availability_instr;
        this.availability_write_disc = availability_write_disc;
        this.availability_read_disc = availability_read_disc;
    }
}

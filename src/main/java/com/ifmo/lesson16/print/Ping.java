package com.ifmo.lesson16.print;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Ping implements Externalizable {
    private long time;

    public Ping() {
        this.time = System.currentTimeMillis();
    }

    public long getTime() {
        return time;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(time);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        time = in.readLong();
    }
}
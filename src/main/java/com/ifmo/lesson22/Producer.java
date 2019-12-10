package com.ifmo.lesson22;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
    private final BlockingQueue queue;
    private final File file;
    private List<String> lines = new ArrayList<>();

    public Producer(BlockingQueue queue, File file) {
        this.queue = queue;
        this.file = file;
    }

    @Override
    public void run() {
        
    }
}
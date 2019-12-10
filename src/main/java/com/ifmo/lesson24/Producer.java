package com.ifmo.lesson24;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
    private final BlockingQueue<String> queue;
    private int maxSize;

    Producer(BlockingQueue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    generateString();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notify();
            }
        }
    }

    private void generateString() throws InterruptedException {

            String s = "String " + new Random().nextInt(100);
            queue.put(s);
            System.out.println(this.getClass().getSimpleName() + " put " + s);

    }
}
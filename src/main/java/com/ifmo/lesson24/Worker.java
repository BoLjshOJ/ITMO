package com.ifmo.lesson24;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread {
    private final BlockingQueue<String> queue;

    Worker(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue) {
                while (queue.isEmpty()){
                    System.out.println("Queue is empty");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                String s = queue.poll();
                System.out.println(this.getClass().getSimpleName() + " take " + s);
                queue.notify();
            }
        }
    }
}

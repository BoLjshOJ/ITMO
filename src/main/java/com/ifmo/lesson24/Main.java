package com.ifmo.lesson24;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Worker worker = new Worker(queue);
        Producer producer = new Producer(queue, 3);

        worker.start();
        producer.start();
    }
}
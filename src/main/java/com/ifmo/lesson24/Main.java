package com.ifmo.lesson24;

public class Main {
    static BQueue<Integer> queue = new BQueue<>(10);

    public static void main(String[] args) {
        Thread worker = new Thread(() -> queue.take());
        Thread worker2 = new Thread(() -> queue.take());

        Thread producer = new Thread(() -> queue.put(1));

        worker.start();
        worker2.start();
        producer.start();
    }
}
package com.ifmo.lesson24;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BQueue queue = new BQueue(5);
        new Thread(new Producer(queue)).start();
        Thread.currentThread().sleep(1000);
        new Thread(new Consumer(queue)).start();
    }

    static class Producer implements Runnable {
        private final BQueue queue;

        public Producer(BQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("[Producer] run");
            while (true) {
                try {
                    queue.put(produce());
                    Thread.currentThread().sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private Integer produce() {
            Integer i = new Random().nextInt(100);
            System.out.println("[Producer] produce: " + i);
            return i;
        }
    }

    static class Consumer implements Runnable {
        private final BQueue queue;

        public Consumer(BQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("[Consumer] run");
            while (true) {
                try {
                    consume();
                    Thread.currentThread().sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consume() throws InterruptedException {
            Integer i = (int) queue.take();
            System.out.println("[Consumer] consumed: " + i);
        }
    }
}
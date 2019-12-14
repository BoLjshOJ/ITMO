package com.ifmo.lesson24;

import java.util.ArrayList;
import java.util.List;

public class BQueue<T> {
    private final List<T> queue;
    private int size;

    public BQueue(int size) {
        this.queue = new ArrayList<T>(size);
        this.size = size;
    }

    public void put(T t){
        while (true){
            synchronized (queue){
                while (queue.size() == size){
                    try {
                        System.out.println("Queue is full");
                        queue.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
                queue.add(t);
                System.out.println(Thread.currentThread().getName() + " add " + t);
                queue.notify();
            }
        }
    }

    public T take() {
        T result;
        synchronized (queue) {
                while (queue.size() == 0) {
                    System.out.println("Queue is empty");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
                result = queue.remove(0);
                System.out.println(Thread.currentThread().getName() + " take " + result);
                queue.notify();
                return result;
        }
    }
}
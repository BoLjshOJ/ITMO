package com.ifmo.lesson24;

import java.util.ArrayList;
import java.util.List;

public class BQueue<T> {
    private List<T> queue = new ArrayList<>();
    private int size;

    public BQueue(int size) {
        this.size = size;
    }

    public synchronized void put(T t) throws InterruptedException{
        while (this.queue.size() == this.size){
            System.out.println("Queue is full");
            wait();
        }
        if (this.queue.size() == 0){
            notifyAll();
        }
        this.queue.add(t);
    }

    public synchronized T take() throws InterruptedException{
        T result;
            while (this.queue.size() == 0) {
                System.out.println("Queue is empty");
                wait();
            }
            if (this.queue.size() == this.size) {
                notifyAll();
            }
        result = queue.remove(0);
        return result;
    }
}

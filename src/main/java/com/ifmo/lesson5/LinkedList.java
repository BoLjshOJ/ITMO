package com.ifmo.lesson5;

public class LinkedList {

    private Item head;

    public void add(Shape val) {
        if (head == null) {
            head = new Item(val);

            return;
        }

        //noinspection ConstantConditions
        find(-1).next = new Item(val);
    }

    private Item find(int i) {
        if (head == null)
            return null;

        if (i == 0)
            return head;

        int cnt = 1;

        for (Item prev = head;;) {
            Item next = prev.next;

            if (next == null)
                return i < 0 ? prev : null;

            if (cnt++ == i)
                return next;

            prev = next;
        }
    }

    public Item get(int i) {
        Item item = find(i);

        return item;
    }

    public Object remove(int i) {
        if (head == null)
            return null;

        if (i == 0) {
            Item h = head;

            head = head.next;

            return h.value;
        }

        Item prev = find(i - 1);
        Item cur;

        if (prev != null && (cur = prev.next) != null) {
            prev.next = cur.next;

            return cur.value;
        }

        return null;
    }
}
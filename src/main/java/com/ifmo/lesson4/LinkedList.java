package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
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

    public Object get(int i) {
        Item item = find(i);

        return item == null ? null : item.value;
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
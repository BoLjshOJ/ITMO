package com.ifmo.lesson6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList<T> implements List<T>, Stack<T>, Queue<T> {
    /** Ссылка на первый элемент списка. */
    private Item<T> head;

    /** {@inheritDoc} */
    @Override
    public void add(T val) {
        if (head == null) {
            head = new Item<>(val);

            return;
        }

        //noinspection ConstantConditions
        find(-1).next = new Item<>(val);
    }

    private Item<T> find(int i) {
        if (head == null)
            return null;

        if (i == 0)
            return head;

        int cnt = 1;

        for (Item prev = head;;) {
            Item<T> next = prev.next;

            if (next == null)
                return i < 0 ? prev : null;

            if (cnt++ == i)
                return next;

            prev = next;
        }
    }

    /** {@inheritDoc} */
    @Override
    public T take() {
        final Item<T> item = head;
        return (item == null) ? null : unlinkFirst(item);
    }

    private T unlinkFirst(Item<T> item){
        final T element = item.value;
        final Item<T> next = item.next;
        item.value= null;
        item.next = null;
        head = next;
        return element;
    }

    /** {@inheritDoc} */
    @Override
    public T get(int i) {
        Item<T> item = find(i);

        return item == null ? null : item.value;
    }

    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        if (head == null)
            return null;

        if (i == 0) {
            Item<T> h = head;

            head = head.next;

            return h.value;
        }

        Item<T> prev = find(i - 1);
        Item<T> cur;

        if (prev != null && (cur = prev.next) != null) {
            prev.next = cur.next;

            return cur.value;
        }

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>();
    }

    private class LinkedListIterator<T> implements Iterator<T>{
        private int nextIndex;

        @Override
        public boolean hasNext() {
            return !(find(nextIndex) == null);
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item<T> item = (Item<T>) find(nextIndex);
            nextIndex++;
            return item.value;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void push(T value) {
        final Item<T> f = head;
        final Item<T> newItem = new Item<>(value);
        head = newItem;
        newItem.next = f;
    }

    /** {@inheritDoc} */
    @Override
    public T pop() {
        final Item<T> item = head;
        return (item == null) ? null : unlinkFirst(item);
    }
}
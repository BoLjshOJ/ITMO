package com.ifmo.lesson7;

import com.ifmo.lesson6.List;
import com.ifmo.lesson6.Queue;
import com.ifmo.lesson6.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList implements List, Stack, Queue {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /** {@inheritDoc} */
    @Override
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

    /** {@inheritDoc} */
    @Override
    public Object take() {
        final Item item = head;
        return (item == null) ? null : unlinkFirst(item);
    }

    private Object unlinkFirst(Item item){
        final Object element = item.value;
        final Item next = item.next;
        item.value= null;
        item.next = null;
        head = next;
        return element;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int i) {
        Item item = find(i);

        return item == null ? 0 : item.value;
    }

    /** {@inheritDoc} */
    @Override
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

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator{
        private int nextIndex;

        @Override
        public boolean hasNext() {
            return !(find(nextIndex) == null);
        }

        @Override
        public Object next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = find(nextIndex);
            nextIndex++;
            return item.value;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void push(Object value) {
        final Item f = head;
        final Item newItem = new Item(value);
        head = newItem;
        newItem.next = f;
    }

    /** {@inheritDoc} */
    @Override
    public Object pop() {
        final Item item = head;
        return (item == null) ? null : unlinkFirst(item);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LinkedList cloneLinkedList = new LinkedList();
        if (head == null) return cloneLinkedList;
        cloneLinkedList.head = new Item(head.value);
        Item item = head;
        Item nextItem = cloneLinkedList.head;
        while (item.next != null){
            nextItem.next = new Item(item.next.value);
            item = item.next;
            nextItem = nextItem.next;
        }
        return cloneLinkedList;
    }
}
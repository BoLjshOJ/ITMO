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
        } else {
            Item item = head;
            while (true) {
                if (item.next == null) {
                    item.next = new Item(val);
                    return;
                }
                item = item.next;
            }
        }
    }

    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Object get(int i) {
        if (i <= 0) return null;

        Item current = head;
        for (int j = 1; j < i; j++) {
            if (current.next == null){
                return null;
            }
            current = current.next;
        }
        return current.value;
    }

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
    public Object remove(int i) {
        if (i < 1) return null;

        Item current = head;
        if (i == 1) {
            head = current.next;
            return current;
        }
        for (int j = 1; j < i - 1; j++) {
            if (current.next == null) return null;
            current = current.next;
        }
        Item returned = current;
        if (current.next == null) return null;
        current.next = current.next.next;
        return returned;
    }
}
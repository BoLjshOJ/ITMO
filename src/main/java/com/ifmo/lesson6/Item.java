package com.ifmo.lesson6;

/**
 * Элемент связного списка, хранящий ссылку
 * на следующий элемент и на значение.
 * <p>
 *     Класс package-private, т.к. используется
 *     только для LinkedList'a.
 * </p>
 */
class Item {
    /** Значение элемента. */
    Object value;

    /** Ссылка на следующий элемент. */
    Item next;

    /**
     * {@code value}.
     *
     * @param value Значение, которое будет сохранено
     *              в этом элементе.
     */
    Item(Object value) {
        this.value = value;
    }
}

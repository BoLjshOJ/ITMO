package com.ifmo.lesson4;

/**
 * Ёлемент св€зного списка, хран€щий ссылку
 * на следующий элемент и на значение.
 * <p>
 *      ласс package-private, т.к. используетс€
 *     только дл€ LinkedList'a.
 * </p>
 */
class Item {
    /** «начение элемента. */
    Object value;

    /** —сылка на следующий элемент. */
    Item next;

    /**
     * »нициализирует элемент со значением
     * {@code value}.
     *
     * @param value «начение, которое будет сохранено
     *              в этом элементе.
     */
    Item(Object value) {
        this.value = value;
    }
}

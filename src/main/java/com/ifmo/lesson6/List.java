package com.ifmo.lesson6;

public interface List extends Iterable {
    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    void add(Object val);

    /**
     *
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    Object get(int i);

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *@return Удаленное значение или {@code null}, если не найдено.
     */
    Object remove(int i);
}

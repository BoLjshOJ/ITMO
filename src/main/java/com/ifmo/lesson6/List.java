package com.ifmo.lesson6;

public interface List<T> extends Iterable {
    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    void add(T val);

    /**
     *
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    T get(int i);

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *@return Удаленное значение или {@code null}, если не найдено.
     */
    T remove(int i);
}

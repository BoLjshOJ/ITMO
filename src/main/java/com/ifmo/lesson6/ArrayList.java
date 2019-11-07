package com.ifmo.lesson6;

import java.util.*;

/**
 * Этот класс должен реализовывать следующие методы: add(), get(), remove() и iterator() из интерфейса List.
 * Если при выполнении add() в массиве нет свободных элементов, то создать новый - вдвое больше,
 * скопировать в него все значения из старого и + 1, который сейчас добавляется.
 * Удаление должно сдвинуть все элементы влево, если это требуется.
 * Например, если список с такими элементами:
 * |0|1|2|3|4|5|
 * Удаляем элемент по индексу 2:
 * |0|1|_|3|4|5|
 * Перемещаем все элементы влево:
 * |0|1|3|4|5|_|
 * Теперь при итерации по ним после 1 будет идти сразу 3, как в связном списке.
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 10;

    private Object[] values;
    private int size;

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива по умолчанию.
     */
    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива,
     * равного {@code initialSize}.
     *
     * @param initialSize Начальный размер внутреннего массива.
     */
    public ArrayList(int initialSize) {
        values = new Object[initialSize];
    }

    /** {@inheritDoc} */
    @Override
    public void add(T val) {
        if (size == values.length){
            grow();
        }
        values[size++] = val;
    }

    private void grow() {
        values = Arrays.copyOf(values, values.length * 2);
    }

    /** {@inheritDoc} */
    @Override
    public T get(int i) {
        if (i < 0 || i >= size) return null;
        return (T) values[i];
    }

    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        if (i < 0 || i >= size) return null;
        T val = (T) values[i];
        for (int j = i; j < size - 1; j++) {
            values[j] = values[j + 1];
        }
        values[--size] = null;
        return val;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        return new ArrayListIterator<>();
    }

    private class ArrayListIterator<T> implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next(){
            return (T) get(index++);
        }
    }
}

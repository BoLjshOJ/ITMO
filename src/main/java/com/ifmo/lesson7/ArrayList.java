package com.ifmo.lesson7;

import com.ifmo.lesson6.List;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
public class ArrayList implements List {
    private static final int DEFAULT_SIZE = 10;
    private int size;

    private Object[] values;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива по умолчанию.
     */
    public ArrayList() {
        values = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива,
     * равного {@code initialSize}.
     *
     * @param initialSize Начальный размер внутреннего массива.
     */
    public ArrayList(int initialSize) {
        values = new Object[initialSize];
        size = values.length;
    }

    /** {@inheritDoc} */
    @Override
    public void add(Object val) {
        if (size == values.length){
            grow();
        }
        values[size] = val;
        size++;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int i) {
        return values[i];
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int i) {
        if (i > size) return 0;
        final Object[] es = values;
        Object oldValue = es[i];
        fastRemove(es, i);

        return oldValue;
    }

    private void fastRemove(Object[] es, int i){
        final int newSize;
        if ((newSize = size - 1) > i){
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }
        es[size = newSize] = null;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = values.length;
        if (oldCapacity > 0 || values != DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            int newCapacity = size + 1;
            return values = Arrays.copyOf(values, newCapacity);
        } else {
            return values = new Object[Math.max(DEFAULT_SIZE, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ArrayList cloneList = new ArrayList();
        cloneList.values = values.clone();
        cloneList.size = size;
        return cloneList;
    }

    private class ArrayListIterator implements Iterator {
        int cursor;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = values;
            if (i >= elementData.length){
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return elementData[lastRet = i];
        }
    }
}

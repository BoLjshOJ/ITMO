package com.ifmo.lesson4;

/**
 * ������� �������� ������, �������� ������
 * �� ��������� ������� � �� ��������.
 * <p>
 *     ����� package-private, �.�. ������������
 *     ������ ��� LinkedList'a.
 * </p>
 */
class Item {
    /** �������� ��������. */
    Object value;

    /** ������ �� ��������� �������. */
    Item next;

    /**
     * �������������� ������� �� ���������
     * {@code value}.
     *
     * @param value ��������, ������� ����� ���������
     *              � ���� ��������.
     */
    Item(Object value) {
        this.value = value;
    }
}

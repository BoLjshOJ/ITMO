package com.ifmo.lesson3;

import java.util.ArrayList;

public class EvenArray {
    /*
    Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран
    сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик (отделяя один
    элемент от другого началом новой строки). Перед созданием массива подумайте, какого он
    будет размера.2 4 6 … 18 20246…20
     */
    public static void main(String[] args) {
        int[] evenArray = evenArray();
        StringBuilder sb = new StringBuilder();

        for (Integer x : evenArray) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());

        for (Integer x : evenArray){
            System.out.println(x);
        }
    }

    public static int[] evenArray() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 20; i = i + 2) {
            list.add(i);
        }
        int[] mass = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mass[i] = list.get(i);
        }
        return mass;
    }
}
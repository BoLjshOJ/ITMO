package com.ifmo.lesson3;

import java.util.ArrayList;

public class UnevenArray {
    /*
    Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
    этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3
    1)
     */
    public static void main(String[] args) {
        int[] unevenArray = unevenArray();

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < unevenArray.length; i++) {
            sb1.append(unevenArray[i]).append(" ");
        }
        System.out.println(sb1.toString().trim());

        StringBuilder sb2 = new StringBuilder();
        for (int i = unevenArray.length - 1; i >= 0 ; i--) {
            sb2.append(unevenArray[i]).append(" ");
        }
        System.out.println(sb2.toString().trim());
    }

    public static int[] unevenArray() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 100; i = i + 2) {
            list.add(i);
        }

        int[] mass = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mass[i] = list.get(i);
        }

        return mass;
    }
}
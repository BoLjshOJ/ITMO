package com.ifmo.lesson3;

import java.util.ArrayList;

public class Fibonacci20 {
    /*
    Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,
    что первый и второй члены последовательности равны единицам, а каждый следующий —
    сумме двух предыдущих.
     */
    public static void main(String[] args) {
        int[] fibonacciNumbers = fibonacciNumbers();

        for (Integer x : fibonacciNumbers){
            System.out.println(x);
        }
    }

    public static int[] fibonacciNumbers() {
        ArrayList<Integer> listOfInteger = new ArrayList<>();
        listOfInteger.add(1);
        listOfInteger.add(1);
        for (int i = 2; i < 20; i++) {
            listOfInteger.add(listOfInteger.get(i - 1) + listOfInteger.get(i - 2));
        }

        int[] mass = new int[listOfInteger.size()];

        for (int i = 0; i < listOfInteger.size(); i++) {
            mass[i] = listOfInteger.get(i);
        }

        return mass;
    }

}

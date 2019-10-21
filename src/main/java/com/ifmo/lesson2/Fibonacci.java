package com.ifmo.lesson2;

import java.util.ArrayList;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих.
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> listOfInteger = new ArrayList<>();
        listOfInteger.add(1);
        listOfInteger.add(1);
        for (int i = 2; i <= 11; i++) {
            listOfInteger.add(listOfInteger.get(i - 1) + listOfInteger.get(i - 2));
        }

        for (Integer s : listOfInteger){
            sb.append(s).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
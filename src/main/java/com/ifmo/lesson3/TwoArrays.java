package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */
    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        int[] randomNumbers2 = randomNumbers();

        StringBuilder sb1 = new StringBuilder();
        for (Integer x : randomNumbers1){
            sb1.append(x).append(" ");
        }
        StringBuilder sb2 = new StringBuilder();
        for (Integer x : randomNumbers2){
            sb2.append(x).append(" ");
        }

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());

        int average1 = average(randomNumbers1);
        int average2 = average(randomNumbers2);

        System.out.println(checkAverage(average1, average2));
    }

    public static int[] randomNumbers() {
        int[] mass = new int[5];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = getRandomNumber();
        }

        return mass;
    }

    public static int average(int[] randomNumbers) {
        return (int) Math.round(Arrays.stream(randomNumbers).average().getAsDouble());
    }

    public static int getRandomNumber(){
        Random rnd = new Random();
        return rnd.nextInt(5);
    }

    public static String checkAverage(int average1, int average2){
        String result = "";
        if (average1 > average2){
            result = "Среднее арифметическое первого массива больше";
        } else if (average1 < average2){
            result = "Среднее арифметическое второго массива больше";
        } else {
            result = "Средние арифметические обоих массивов равны";
        }

        return result;
    }
}
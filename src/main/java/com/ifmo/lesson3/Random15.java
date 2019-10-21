package com.ifmo.lesson3;

import java.util.Random;

public class Random15 {
    /*
     Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
     Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
     отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        StringBuilder sb = new StringBuilder();
        for (Integer x : randomNumbers){
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());

        int evens = evens(randomNumbers);

        System.out.println(evens);
    }

    public static int[] randomNumbers() {
        int[] mass = new int[15];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = getRandomNumber();
        }

        return mass;
    }

    private static int evens(int[] arr) {
        int countsEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 || arr[i] % 2 == 0){
                countsEven++;
            }
        }

        return countsEven;
    }

    public static int getRandomNumber(){
        Random rnd = new Random();
        int result = rnd.nextInt(9);
        return result;
    }
}
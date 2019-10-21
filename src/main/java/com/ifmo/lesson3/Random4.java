package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Random4 {
    /*
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
    строку. Определить и вывести на экран сообщение о том, является ли массив строго
    возрастающей последовательностью.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        StringBuilder sb = new StringBuilder();
        for (Integer x : randomNumbers){
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());
        System.out.println(isIncreasingSequence(randomNumbers));
    }

    public static int[] randomNumbers() {
        int[] mass = new int[4];

        for (int i = 0; i < mass.length; i++){
            mass[i] = getRandomNumber();
        }

        return mass;
    }

    public static boolean isIncreasingSequence(int[] randomNumbers) {
        int[] massSorted = randomNumbers.clone();
        Arrays.sort(massSorted);

        int counter = 0;
        for (int i = 0; i < massSorted.length; i++) {
            if (massSorted[i] == randomNumbers[i]){
                counter++;
            }
        }

        return counter == 4;
    }

    public static int getRandomNumber(){
        Random rnd = new Random();
        int min = 10;
        int max = 99;
        int diff = max - min;
        int result = rnd.nextInt(diff + 1);
        result += min;
        return result;
    }
}
package com.ifmo.lesson3;

import java.util.Random;

public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        int max = max(randomNumbers);

        int maxLastIndex = lastIndexOf(randomNumbers, max);

        System.out.println(maxLastIndex);
    }

    public static int[] randomNumbers() {
        int[] mass = new int[12];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = getRandomNumber();
        }

        return mass;
    }

    public static int max(int[] randomNumbers) {
        int max = 0;
        for (Integer x : randomNumbers){
            if (x > max) {
                max = x;
            }
        }

        return max;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        int currentindex = 0;
        int lastIndex = 0;
        for (int i = 0; i <= randomNumbers.length - 1 ; i++) {
            if (randomNumbers[i] == max){
                currentindex = i;
                if (lastIndex < currentindex) lastIndex = currentindex;
            }
        }
        return currentindex;
    }

    public static int getRandomNumber(){
        Random rnd = new Random();
        int min = -15;
        int max = 15;
        int diff = max - min;
        int result = rnd.nextInt(diff + 1);
        result += min;
        return result;
    }
}
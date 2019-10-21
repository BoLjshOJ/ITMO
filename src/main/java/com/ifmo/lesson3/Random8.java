package com.ifmo.lesson3;

import java.util.Random;

public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        StringBuilder sb = new StringBuilder();
        for (Integer x : randomNumbers){
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());

        int[] replacedWithZeros = replaceWithZeros(randomNumbers);

        StringBuilder replacedSb = new StringBuilder();

        for (Integer x : replacedWithZeros){
            replacedSb.append(x).append(" ");
        }
        System.out.println(replacedSb.toString().trim());
    }

    public static int[] randomNumbers() {
        int[] mass = new int[8];
        for (int i = 0; i < mass.length; i++){
            mass[i] = getRandomNumber();
        }

        return mass;
    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        int[] replacedMass = randomNumbers;
        for (int i = 1; i < randomNumbers.length; i= i + 2){
            replacedMass[i] = 0;
        }

        return replacedMass;
    }

    public static int getRandomNumber(){
        Random rnd = new Random();
        int min = 1;
        int max = 10;
        int diff = max - min;
        int result = rnd.nextInt(diff + 1);
        result += min;
        return result;
    }
}

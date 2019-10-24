package com.ifmo.lesson2;

import java.util.Random;

public class BiggestInRandom {
    /*
     Создать программу, выводящую на экран случайно сгенерированное трёхзначное
     натуральное число и его наибольшую цифру.Примеры работы программы:
     В числе 208 наибольшая цифра 8.
     В числе 774 наибольшая цифра 7.
     В числе 613 наибольшая цифра 6.
     */
    public static void main(String[] args) {
        int rnd = threeDigitRandom();

        String largestDigit = largestDigit(rnd);

        System.out.println(largestDigit);
    }

    public static int threeDigitRandom() {
        Random rnd = new Random();
        int min = 100;
        int max = 999;
        int diff = max - min;
        int result = rnd.nextInt(diff + 1);
        result += min;
        return result;
    }

    public static String largestDigit(int rnd) {
        int max = 0;

        int hundred = rnd / 100;
        int ten = (rnd - hundred * 100) / 10;
        int unit = rnd % 10;
        if (hundred >= ten && hundred >= unit){
            max = hundred;
        } else if (ten >= hundred && ten >= unit) {
            max = ten;
        } else {
            max = unit;
        }

        return "В числе " + rnd + " наибольшая цифра " + max + ".";
    }
}

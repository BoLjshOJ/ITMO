package com.ifmo.lesson2;

import java.util.Random;

public class IsInInterval {
    /*
     Создать программу, которая будет проверять попало ли случайно выбранное из отрезка
    [5;155] целое число в интервал (25;100) и сообщать результат на экран.Примеры работы
    программы:
    Число 113 не содержится в интервале (25,100) Число 72 содержится в интервале (25,100) 
    Число 25 не содержится в интервале (25,100) Число 155 не содержится в интервале (25,100) 
     */
    public static void main(String[] args) {
        int rnd = randomInt();

        String inInterval = isInInterval(rnd);

        System.out.println("Число " + inInterval + " в интервале (25,100)");
    }

    public static int randomInt() {
        Random rnd = new Random();
        int min = 5;
        int max = 155;
        int diff = max - min;
        int result = rnd.nextInt(diff + 1);
        result += min;
        return result;
    }

    public static String isInInterval(int rnd) {
        return (rnd > 25 && rnd < 100) ? rnd + " содержится" : rnd + " не содержится";
    }

}
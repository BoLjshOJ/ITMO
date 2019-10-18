package com.ifmo.lesson2;

import java.util.Scanner;

public class DigitsSum {
    /*
    Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех
    его цифр (заранее не известно сколько цифр будет в числе).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int digitSum = digitSum(n);

        System.out.println(digitSum);
    }

    public static int digitSum(int n) {
        int sum = 0;

        String num = String.valueOf(n);

        for (int i = 0; i < num.length(); i++){
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        return sum;
    }
}

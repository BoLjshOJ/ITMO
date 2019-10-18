package com.ifmo.lesson2;

import java.util.ArrayList;
import java.util.Scanner;

public class Dividers {
    /*
    Выведите на экран все положительные делители натурального числа, введённого
    пользователем с клавиатуры.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> listOfDividers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) listOfDividers.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer x : listOfDividers){
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}

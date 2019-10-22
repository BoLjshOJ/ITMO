package com.ifmo.lesson2;

import java.util.Arrays;

public class SquareEquation {
    /*
     В три переменные a, b и c записаны три вещественных числа. Создать программу, которая
     будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0,
     либо сообщать, что корней нет.
     */
    public static void main(String[] args) {
        double a = 1;
        double b = 2;
        double c = 1;

        double[] roots = squareEquationRoots(a, b, c);

        System.out.println(Arrays.toString(roots));
    }

    /*
    Возвращает массив из двух корней или null, если таковых нет.
     */
    public static double[] squareEquationRoots(double a, double b, double c) {
        double[] roots = null;

        double discriminant = (Math.pow(b, 2)) - (4 * a * c);
        if (discriminant > 0) {
            double absb = 0;
            double x1 = 0;
            double x2 = 0;
            if (b < 0){
                absb = Math.abs(b);
            } else {
                absb = 0 - b;
            }
            x1 = (absb + Math.sqrt(discriminant)) / (2 * a);
            x2 = (absb - Math.sqrt(discriminant)) / (2 * a);
            roots = new double[2];
            roots[0] = x1;
            roots[1] = x2;
        } else if (discriminant == 0){
            double x = -(b / (2*a));
            roots = new double[2];
            roots[0] = x;
            roots[1] = x;
        }

        return roots;
    }
}
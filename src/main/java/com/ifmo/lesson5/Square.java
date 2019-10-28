package com.ifmo.lesson5;

public class Square extends Rectangle {
    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return Math.pow(a, 2);
    }
}
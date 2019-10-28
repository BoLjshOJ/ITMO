package com.ifmo.lesson5;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;
    private double p;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.p = (a + b + c) / 2;
    }

    @Override
    public double area() {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
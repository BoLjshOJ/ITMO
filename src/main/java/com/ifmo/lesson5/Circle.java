package com.ifmo.lesson5;

public class Circle extends Oval{
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(r, 2);
    }
}
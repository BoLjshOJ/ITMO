package com.ifmo.lesson17.models;

import com.ifmo.lesson17.Car;

public class BMW implements Car {
    @Override
    public int power() {
        return 300;
    }

    @Override
    public int maxSpeed() {
        return 300;
    }
}

package com.ifmo.lesson17.models;

import com.ifmo.lesson17.Car;

public class KIA implements Car {
    @Override
    public int power() {
        return 200;
    }

    @Override
    public int maxSpeed() {
        return 200;
    }
}
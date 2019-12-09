package com.ifmo.lesson17.models;

import com.ifmo.lesson17.Car;

public class LADA implements Car {
    @Override
    public int power() {
        return 120;
    }

    @Override
    public int maxSpeed() {
        return 120;
    }
}

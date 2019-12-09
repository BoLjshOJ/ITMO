package com.ifmo.lesson17.factories;

import com.ifmo.lesson17.Car;
import com.ifmo.lesson17.Factory;
import com.ifmo.lesson17.models.LADA;

public class RussianFactory extends Factory {
    @Override
    public Car createCar() {
        return new LADA();
    }
}
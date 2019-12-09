package com.ifmo.lesson17;

import com.ifmo.lesson17.factories.GermanyFactory;
import com.ifmo.lesson17.factories.KoreanFactory;
import com.ifmo.lesson17.factories.RussianFactory;
import com.ifmo.lesson17.factories.UkFactory;

public abstract class Factory {

    public static Factory getFactory(String country) {
        switch (country) {
            case "JP":
                return new KoreanFactory();
            case "RUS":
                return new RussianFactory();
            case "UK":
                return new UkFactory();
            case "DE":
                return new GermanyFactory();
        }
        throw new IllegalArgumentException("Factory not found");
    }

    public abstract Car createCar();
}
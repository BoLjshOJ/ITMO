package com.ifmo.lesson17;

public class Application {
    public static void main(String[] args) {
        Factory factory = Factory.getFactory("RUS");
        Car car = factory.createCar();

        Pizza pizza = new Pizza.PizzaBuilder("fat", "mozarella").chiken(2).pepper(3).tomatoes(1).build();
    }
}
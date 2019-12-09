package com.ifmo.lesson17;

public class Pizza {
    final String cheese;
    final String base;
    final int tomatoes;
    final int pepper;
    final int chiken;

    public static class PizzaBuilder {
        final String cheese;
        final String base;
        int tomatoes;
        int pepper;
        int chiken;


        public PizzaBuilder(String base, String cheese) {
            this.base = base;
            this.cheese = cheese;
        }

        public PizzaBuilder tomatoes(int tomatoes){
            this.tomatoes = tomatoes;
            return this;
        }

        public PizzaBuilder pepper(int pepper){
            this.pepper = pepper;
            return this;
        }

        public PizzaBuilder chiken(int chiken){
            this.chiken = chiken;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }

    private Pizza(PizzaBuilder builder) {
        this.base = builder.base;
        this.cheese = builder.cheese;
        this.tomatoes = builder.tomatoes;
        this.chiken = builder.chiken;
        this.pepper = builder.pepper;
    }
}
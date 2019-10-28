package com.ifmo.lesson2;

import java.util.Random;

public class WallClock {

    public static void main(String[] args) {
        int randomSecond = randomSecond();
        String remainingHours = remainingHours(randomSecond);

        System.out.println(remainingHours);
    }

    public static int randomSecond() {
        Random rnd = new Random();
        return rnd.nextInt(28800);
    }

    public static String remainingHours(int rndSecond) {
        double remainingHours = rndSecond / 3600;
        String result = "";

        if (remainingHours >= 0 && remainingHours < 1){
            result = "Осталось менее часа";
        } else if (remainingHours >= 1 && remainingHours < 2){
            result = "Остался 1 час";
        } else if (remainingHours >= 2 && remainingHours < 3){
            result = "Осталось 2 часа";
        } else if (remainingHours >= 3 && remainingHours < 4){
            result = "Осталось 3 часа";
        } else if (remainingHours >= 4 && remainingHours < 5){
            result = "Осталось 4 часа";
        } else if (remainingHours >= 5 && remainingHours < 6){
            result = "Осталось 5 часов";
        } else if (remainingHours >= 6 && remainingHours < 7){
            result = "Осталось 6 часов";
        } else if (remainingHours >= 7 && remainingHours < 8){
            result = "Осталось 7 часов";
        } else if (remainingHours == 8){
            result = "Осталось 8 часов";
        }
        return result;
    }
}
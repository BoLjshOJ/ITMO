package com.ifmo.lesson2;

import java.util.Random;

public class WallClock {
    /*
    На некотором предприятии инженер Петров создал устройство, на табло которого
    показывается количество секунд, оставшихся до конца рабочего дня. Когда рабочий день
    начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов), когда
    времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа), а когда наступает 17
    часов — на табло отображается «0» (т.е. рабочий день закончился).Программист Иванов
    заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня
    в секундах. Иванов вызвался помочь сотрудницам и написать программу, которая вместо
    секунд будет выводить на табло понятные фразы с информацией о том, сколько полных часов
    осталось до конца рабочего дня. Например: «осталось 7 часов», «осталось 4 часа», «остался
    1 час», «осталось менее часа».Итак, в переменную n должно записываться случайное (на
    время тестирования программы) целое число из [0;28800], далее оно должно выводиться на
    экран (для Петрова) и на следующей строке (для сотрудниц) должна выводиться фраза о
    количестве полных часов, содержащихся в n секундах.

    Примеры работы программы:
    23466
    Осталось 6 часов

    10644
    Осталось 2 часа

    5891
    Остался 1 час

    1249
    Осталось менее часа
     */
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
            result = "Осталось 4 часов";
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
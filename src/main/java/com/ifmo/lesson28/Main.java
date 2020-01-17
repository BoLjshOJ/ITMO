package com.ifmo.lesson28;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        fridayThirteen(2019);
        countSecodnsOfLife(LocalDate.of(1988, Month.SEPTEMBER, 17));
    }

    public static void fridayThirteen(int year){
        ArrayList<LocalDate> result = new ArrayList<>();

        LocalDate startDate = LocalDate.of(year, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(year, Month.DECEMBER, 31);
        LocalDate nextOfSameFriday = startDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));

        while ((nextOfSameFriday != null) && (!nextOfSameFriday.isAfter(endDate))){
            result.add(nextOfSameFriday);
            nextOfSameFriday = nextOfSameFriday.plusWeeks(1);
        }

        for (LocalDate d : result){
            if (d.getDayOfMonth() == 13){
                System.out.println(d.toString());
            }
        }
    }
    //TODO каждую секунду выводит сколько осталось до НГ
    public static void countDaysHoursMinutesSecondsToNY(){
        LocalDate endDate = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate currentDate = LocalDate.now();
        while (currentDate.isAfter(endDate)) {
           currentDate = currentDate.plus(1, ChronoUnit.SECONDS);
           System.out.printf("До Нового года осталось %d дней %d часов %d минут %d секунд");
        }
    }

    //TODO выводит сколько секунд вы прожили
    public static Long countSecodnsOfLife(LocalDate dateOfBirth){
        return 0L;
    }
}
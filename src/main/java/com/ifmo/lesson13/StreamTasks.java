package com.ifmo.lesson13;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.*;

public class StreamTasks {

    private static class Person {
        private final String name;
        private final int age;
        private final String country;

        public Person(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
    }

    public static void main(String[] args) {
        List<Person> people = generatePeople(100).collect(toList());

        List<String> countries = countriesSortedByTheirPopulationDescending(people.stream());
        String countryThatHasMostKids = countryThatHasMostKids(people.stream());
        Map<String, Long> populationByCountry = populationByCountry(people.stream());

        System.out.println(countries);
        System.out.println(countryThatHasMostKids);
        System.out.println(populationByCountry);

        List<String> words = List.of("the", "hello", "approximation", "greetings", "java", "war", "hell", "welcome", "war", "war");

        Map<Integer, Set<String>> wordsByLength = groupWordsByLength(words);
        int averageWordLength = averageWordLength(words);
        Set<String> longestWords = longestWords(words);

        System.out.println(wordsByLength);
        System.out.println(averageWordLength);
        System.out.println(longestWords);
    }

    // Метод возвращает страны в порядке убывания их населения.
    public static List<String> countriesSortedByTheirPopulationDescending(Stream<Person> people) {
        return populationByCountry(people).entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Метод находит страну (или одну из стран), в которых больше всего человек в возрасте
    // до 18 лет.
    public static String countryThatHasMostKids(Stream<Person> people) {
        return people
                .filter( p -> p.age < 18)
                .collect(groupingBy(p -> p.country, counting()))
                .entrySet()
                .stream()
                .max(comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse("Unknown");
    }

    // Метод возвращает карту стран их населения.
    public static Map<String, Long> populationByCountry(Stream<Person> people) {
        return people
                .collect(groupingBy(p -> p.country, counting()));
    }

    // Метод генерирует случайных людей в ограниченном наборе стран.
    // number - число желаемых людей.
    public static Stream<Person> generatePeople(int number) {
        ThreadLocalRandom current = ThreadLocalRandom.current();

        return Stream.generate(() -> new Person(
                            String.valueOf(current.nextInt(number)),
                            current.nextInt(0,100),
                            String.valueOf(current.nextInt(1,6)))
        ).limit(number);
    }

    // Метод возвращает карту сгруппированных слов по их длине. Например, для
    // трёхбуквенных слов будет:
    // 3 -> "the", "map", "got", "war"...
    public static Map<Integer, Set<String>> groupWordsByLength(List<String> words) {
        return words.stream()
                .collect(groupingBy(String::length, Collectors.toSet()));
    }

    // Метод находит среднюю длину слов в списке.
    public static int averageWordLength(List<String> words) {
        return (int) words.stream()
                .mapToInt(s -> s.length())
                .average()
                .getAsDouble();
    }

    // Метод находит самое длинное слово или слова, если таких несколько.
    public static Set<String> longestWords(List<String> words) {
        return words.stream()
                .filter(s -> s.length() > averageWordLength(words))
                .collect(Collectors.toSet());
    }
}
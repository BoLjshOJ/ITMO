package com.ifmo.lesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TopWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("src/main/resources/wap.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        // Создаем пустую коллекцию для слов.
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }

        System.out.println(top10Words(words));
        System.out.println(top10Phrases(words));
        System.out.println(charactersFrequency(words));
    }

    public static Map<String, Integer> top10Words(List<String> words) {
        Map<String, Integer> countWords = new HashMap<>(words.size());
        for (String s : words){
            countWords.merge(s, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        return new SortMapByValue()
                .sortByComparator(countWords, SortMapByValue.DESC)
                .entrySet()
                .stream()
                .limit(10)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Map<String, Integer> top10Phrases(List<String> words) {
        Map<String, Integer> countPhrases = new HashMap<>();
        for (int i = 0; i < words.size() - 2; i++) {
            countPhrases.merge(words.get(i) + " " + words.get(i + 1), 1, (oldVal, newVal) -> oldVal + newVal);
        }

        return new SortMapByValue()
                .sortByComparator(countPhrases, SortMapByValue.DESC)
                .entrySet()
                .stream()
                .limit(10)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Map<Character, Integer> charactersFrequency(List<String> words) {
        Map<Character, Integer> countCharacter = new HashMap<>();
        for (String s : words){
            for (Character c : s.toCharArray()){
                countCharacter.merge(c, 1, (oldVal, newVal) -> oldVal + newVal);
            }
        }

        return countCharacter;
    }

    public static class SortMapByValue{
        private static final boolean ASC = true;
        private static final boolean DESC = false;

        public Map<String, Integer> sortByComparator(Map<String, Integer> unsortedMap, final boolean order){
            List<Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());
            Collections.sort(list, (o1, o2) -> {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
            );

            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Entry<String, Integer> entry : list){
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            return sortedMap;
        }
    }
}

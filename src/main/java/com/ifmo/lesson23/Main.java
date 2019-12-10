package com.ifmo.lesson23;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int cpus = Runtime.getRuntime().availableProcessors();
        // Создём пул потоков.
        ExecutorService pool = Executors.newFixedThreadPool(cpus);

        List<Future<Map<String, Integer>>> futures = new ArrayList<>(cpus);
        // Отправляем задачи на обработку.
        for (int i = 0; i < cpus; i++) {
            List<String> lines = List.of(); // todo 1/cpus строк

            Future<Map<String, Integer>> future =
                    pool.submit(() -> countWords(lines));

            futures.add(future);
        }

        List<Map<String, Integer>> counts = new ArrayList<>(cpus);
        // Собираем результаты выполнения.
        for (Future<Map<String, Integer>> future : futures) {
            Map<String, Integer> map = future.get();

            counts.add(map);
        }
        // Объединяем все счётчики и находим 10 наиболее часто
        // встречающихся слов.
        List<String> top10Words = top10(counts);

        System.out.println(top10Words);

        pool.shutdown();
    }

    private static Map<String, Integer> countWords(List<String> lines) {
        // todo implement

        return Map.of();
    }

    private static List<String> top10(Collection<Map<String, Integer>> counters) {
        // todo implement

        return List.of();
    }
}

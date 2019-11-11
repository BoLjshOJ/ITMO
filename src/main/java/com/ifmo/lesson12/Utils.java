package com.ifmo.lesson12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list.add("1");
        list.add("2");

        list2.add("3");
        list2.add("4");

        list3.add("5");
        list3.add("6");

        Iterable<Integer> view = view(t -> (Integer.parseInt(t) & 1) == 0, Integer::valueOf, list, list2, list3);

        List<Integer> list4 = List.of(0,1,2,3,4,5,6,7,8,9);
        List<String> list5 = List.of("String1", "String2", "String", "Str", "St2", "String3");

        List<Integer> filterInt = filter(list4, a -> (a % 2) == 0);
        List<String> filterStr = filter(list5, a -> a.length() > 3);
        List<String> transformStr = transform(list4, a -> a.toString());
        List<Integer> transformInt = transform(transformStr, a -> Integer.valueOf(a));
    }

    public static <T> List<T> filter (List<T> list, Predicate<T> filter){
        return list.stream().filter(filter::test).collect(Collectors.toList());
    }

    public static <T,R> List<R> transform(List<T> list, Transformer<T,R> transformer){
        return list.stream().map(transformer::transform).collect(Collectors.toList());
    }

    public static <T,R> Iterable<R> view(Predicate<T> predicate, Transformer<T, R> transformer, Iterable<T>...iterables){
        if (iterables.length == 0){
            return List.of();
        }

        return new Iterable<R>() {
            @Override
            public Iterator<R> iterator() {
                return new Iterator<R>() {
                    private int position;
                    private Iterator<T> current;
                    private T item;
                    private boolean flag;

                    @Override
                    public boolean hasNext() {
                        if (current == null){
                            current = iterables[position].iterator();
                        }
                        if (!current.hasNext()){
                            position++;
                            if (position < iterables.length){
                                current = iterables[position].iterator();
                            } else {
                                return false;
                            }
                        }
                        item = current.next();
                        while (item != null && !predicate.test(item)){
                            item = current.next();
                        }
                        flag = true;
                        return item != null;
                    }

                    @Override
                    public R next() {
                        if (!flag){
                            hasNext();
                            flag = false;
                        }
                        return transformer.transform(item);
                    }
                };
            }
        };
    }
}
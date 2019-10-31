package com.ifmo.lesson7;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Utils {
    public static Object find(Predicate pred, List list){
        Object forReturned = null;
        try {
            forReturned = list.stream().filter(pred::test).findFirst().get();
        } catch (NoSuchElementException e){
        }
        return forReturned;
    }

    public static List filter(Predicate pred, List list){
        return (List) list.stream().filter(pred::test).collect(Collectors.toList());
    }

    public static List transform(Transformer trans, List list){
        return (List) list.stream().map(trans::trans).collect(Collectors.toList());
    }

    interface Predicate{
        boolean test(Object obj);
    }

    interface Transformer{
        List trans(Object obj);
    }
}
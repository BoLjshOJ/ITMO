package com.ifmo.lesson7;

import com.ifmo.lesson7.LazyAccumulator.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("aa");
        list.add("c");
        list.add("sd");
        list.add(123);

        System.out.println(Utils.find(obj -> obj.equals("4654"), list));
        System.out.println(Utils.filter(obj -> obj.toString().length() == 1651, list).toString());
        System.out.println(Utils.transform(obj -> {
            ArrayList listTrans = new ArrayList();
            listTrans.add(obj.toString() + obj.toString());
            return listTrans;
        }, list));

        LazyAccumulator lazyAcc = new LazyAccumulator(new ArrayList());
        lazyAcc.add(1, new Plus());
        lazyAcc.add(3, new Minus());
        lazyAcc.add(5, new Plus());
        lazyAcc.add(2, new Division());
        lazyAcc.add(5, new Multiply());
        System.out.println(lazyAcc.calculate());
    }
}

package com.ifmo.lesson7;

import java.util.List;

public class LazyAccumulator {
    List l;
    public LazyAccumulator(List list) {
        this.l = list;
    }

    public List add(int a, Operation oper){
        l.add(a);
        l.add(oper);
        return l;
    }

    public double calculate(){
        double result = 0;
        int param = 0;
        for (Object s : l) {
            if (s instanceof Integer){
                param = (int) s;
            }
            if (s instanceof Plus) {
                result += param;
            }
            if (s instanceof Minus){
                result -= param;
            }
            if (s instanceof Division){
                result /= param;
            }
            if (s instanceof Multiply){
                result *= param;
            }
        }
        return result;
    }

    interface Operation {

    }
    static class Plus implements Operation{

    }
    static class Minus implements Operation{

    }
    static class Division implements Operation {

    }
    static class Multiply implements Operation {

    }
}
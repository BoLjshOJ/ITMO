package com.ifmo.lesson5;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Circle(5));
        list.add(new Oval(3, 2));
        list.add(new Rectangle(5, 7));
        list.add(new Square(5));
        list.add(new Triangle(2,3,4));

        System.out.println(totalArea(list));
    }

    public static double totalArea(LinkedList shapes) {
        double result = 0;

        for (int i = 0; i < 5; i++){
            result += shapes.get(i).value.area();
        }

        return result;
    }
}
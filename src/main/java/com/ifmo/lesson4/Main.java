package com.ifmo.lesson4;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(3);
        boolean p = library.put(new Book("Stephen King", "Shining"), 2);
        boolean p2 = library.put(new Book("Stephen King", "Dark Tower"), 3);

        boolean p3 = library.put(new Book("Tolstoy", "War and peace"), 6);

        int t = library.take(new Book("Stephen King", "Dark Tower"), 654);

        boolean p4 = library.put(new Book("Tolstoy", "War and peace"), 6);

        System.out.println(p);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(t);
        System.out.println(p4);
    }
}

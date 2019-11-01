package com.ifmo.lesson7;

public class Library {
    Shelf[] shelves;

    private static class Shelf {
        Book value;
        int quantity;
        Shelf next;

        Shelf(Book value, int quantity) {
            this.value = value;
            this.quantity = quantity;
        }
    }

    public Library(int maxBookKinds) {
        shelves = new Shelf[maxBookKinds];
    }

    public boolean put(Book book, int quantity) {
        int shelfIndex = getShelfIndex(book);
        if (shelves[shelfIndex] == null) {
            shelves[shelfIndex] = new Shelf(book, quantity);
            return true;
        }
        Shelf shelf = shelves[shelfIndex];
        while (shelf != null) {
            if (book.equals(shelf.value)) {
                shelf.quantity += quantity;
                return true;
            } else {
                if (shelf.next != null) {
                    shelf = shelf.next;
                } else {
                    shelf.next = new Shelf(book, quantity);
                    return true;
                }
            }
        }
        return false;
    }

    public int take(Book book, int quantity) {
        Shelf shelf = findShelf(book);
        if (shelf != null) {
            if (shelf.quantity > quantity) {
                shelf.quantity -= quantity;
                return quantity;
            } else {
                remove(book);
                return shelf.quantity;
            }
        }
        return 0;
    }

    private Shelf findShelf(Book book) {
        int shelfIndex = getShelfIndex(book);
        if (shelves[shelfIndex] == null) return null;
        Shelf shelf = shelves[shelfIndex];
        while (shelf != null){
            if(book.equals(shelf.value)) break;
            shelf = shelf.next;
        }
        return shelf;
    }

    private void remove(Book book){
        int shelfIndex = getShelfIndex(book);
        if(shelves[shelfIndex] == null) return;
        if(book.equals(shelves[shelfIndex].value)) {
            shelves[shelfIndex] = shelves[shelfIndex].next;
            return;
        }
        Shelf shelf = shelves[shelfIndex];
        while (shelf.next != null) {
            if(book.equals(shelf.next.value)) {
                shelf.next = shelf.next.next;
                return;
            }
            shelf = shelf.next;
        }
        return;
    }

    private int getShelfIndex(Book book){
        return Math.abs(book.hashCode()) % shelves.length;
    }
}
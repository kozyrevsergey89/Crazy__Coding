package com.kozyrev.datastructures;

import java.util.ArrayList;

/**
 * Created by sergii on 9/8/16.
 */
public class MyArrayQueue<E> {
    private int end;
    private int start;
    final private ArrayList<E> data = new ArrayList<E>();

    public void enqueue(E e) {
        data.add(end++, e);
    }

    public int size() {
        return end - start;
    }

    public E dequeue() {
        if (size() == 0) {
            return null;
        } else {
            E item = data.get(start++);
            if (size() == 0) { //if empty move pointers to 0
                start = 0;
                end = 0;
            }
            return item;
        }
    }
}

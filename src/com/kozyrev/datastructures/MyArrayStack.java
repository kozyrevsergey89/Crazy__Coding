package com.kozyrev.datastructures;

import java.util.ArrayList;

/**
 * Created by sergii on 9/8/16.
 */
public class MyArrayStack<E> {
    private int topIndex = 0;
    private ArrayList<E> data = new ArrayList<E>();

    public void push(E e) {
        data.add(topIndex++, e);
    }

    public int size() {
        return topIndex;
    }

    public E pop() {
        if (data.size()==0) {
            return null;
        } else {
            return data.get(--topIndex);
        }

    }

}

package com.pakfortune.common;

import java.util.*;

/*
  This class provides a circular version of an ArrayList,
  which can be rotated to the right or left with specified steps.

  @param <E> the type of elements in this list
 */
public class CircularArrayList<E> extends ArrayList<E> {
    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public CircularArrayList() {
        super();
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param size the initial capacity of the list
     */
    public CircularArrayList(int size) {
        super(size);
    }

    /**
     * Constructs a list containing the elements of the specified collection,
     * in the order they are returned by the collection's iterator.
     *
     * @param list the collection whose elements are to be placed into this list
     */
    public CircularArrayList(final List<E> list) {
        super(list);
    }

    /**
     * Shifts the elements in the list to the right by a specified number of positions.
     *
     * @param shiftSize the number of positions to shift the elements
     */
    public void shiftRight(int shiftSize) {
        Collections.rotate(this, shiftSize);
    }

    /**
     * Shifts the elements in the list to the left by a specified number of positions.
     *
     * @param shiftSize the number of positions to shift the elements
     */
    public void shiftLeft(int shiftSize) {
        Collections.rotate(this, -shiftSize);
    }
}


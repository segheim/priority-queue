package org.example;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueueNew<E> extends AbstractQueue<E> {

    private static final int DEFAULT_CAPACITY = 8;

    Object[] queue;
    int size;
    Comparator<? super E> comparator;

    public PriorityQueueNew(int initCapacity, Comparator<? super E> comparator) {
        if (initCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initCapacity];
        this.comparator = comparator;
    }

    public PriorityQueueNew(int capacity) {
        this(capacity, null);
    }

    public PriorityQueueNew() {
        this(DEFAULT_CAPACITY, null);
    }

    public PriorityQueueNew(Comparator<? super E> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean add(E element) {
        return offer(element);
    }

    private void growCapacity() {
        int newCapacity = size + DEFAULT_CAPACITY;
        queue = Arrays.copyOf(queue, newCapacity);
    }

    @Override
    public boolean offer(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (size == 0) {
            queue[size] = element;
            size = size + 1;
            return true;
        }
        int length = size;
        if (size >= queue.length) {
            growCapacity();
        }
        siftUp(size, element);
        size = length + 1;
        return true;
    }

    private void siftUp(int i, E element) {
        if (comparator != null) {
            siftUpComparator(i, element, queue, comparator);
        } else {
            siftUpComparable(i, element, queue);
        }
    }

    private <T> void siftUpComparator(int i, T element, Object[] mass, Comparator<? super T> cmp) {
        while (i > 0) {
            int k;
            if (i % 2 == 0) {
                k = i / 2 - 1;
            } else {
                k = i / 2;
            }
            if (cmp.compare(element, (T) mass[k]) < 0) {
                mass[i] = mass[k];
                mass[k] = element;
                i = k;
            } else {
                mass[i] = element;
                break;
            }
        }
    }

    private <T> void siftUpComparable(int i, T element, Object[] mass) {
        Comparable<? super T> key = (Comparable<? super T>) element;
        while (i > 0) {
            int k;
            if (i % 2 == 0) {
                k = i / 2 - 1;
            } else {
                k = i / 2;
            }
            if (key.compareTo((T) mass[k]) < 0) {
                mass[i] = mass[k];
                mass[k] = element;
                i = k;
            } else {
                mass[i] = element;
                break;
            }
        }
    }



    @Override
    public E poll() {
        int i = 0;
        E firstElement = (E) queue[i];
        size = size - 1;
        queue[i] = queue[size];
        queue[size] = null;
        siftDown(i);
        return firstElement;
    }

    private void siftDown(int i) {
        if (comparator != null) {
            siftDownComparator(i, queue, comparator);
        } else {
            siftDownComparable(i, queue);
        }
    }

    private<T> void siftDownComparable(int i, Object[] mass) {
        Comparable<? super T> key = (Comparable<? super T>) mass[i * 2 + 1];
        while ((i * 2 + 1) < size) {
            int k;
            if (mass[i * 2 + 2] != null) {
                if (key.compareTo((T) mass[i * 2 + 2]) > 0 ) {
                    k = i * 2 + 2;
                    swapElements(i, k, mass);
                } else {
                    k = i * 2 + 1;
                    swapElements(i, k, mass);
                }
            } else {
                k = i * 2 + 1;
                Comparable<? super T> key1 = (Comparable<? super T>) mass[i];
                if (key1.compareTo((T) mass[k]) > 0) {
                    swapElements(i, k, mass);
                }
            }
            i = k;
        }
    }


    private <T> void siftDownComparator(int i, Object[] mass, Comparator<? super T> cmp) {
        while ((i * 2 + 1) < size) {
            int k;
            if (mass[i * 2 + 2] != null) {
                if (cmp.compare((T) mass[i * 2 + 1], (T) mass[i * 2 + 2]) > 0) {
                    k = i * 2 + 2;
                    swapElements(i, k, mass);
                } else {
                    k = i * 2 + 1;
                    swapElements(i, k, mass);
                }
            } else {
                k = i * 2 + 1;
                if (cmp.compare((T) mass[i], (T) mass[k]) > 0) {
                    swapElements(i, k, mass);
                }
            }
            i = k;
        }
    }

    private <T> void swapElements(int i, int k, Object[] mass) {
        T temp = (T) mass[i];
        mass[i] = mass[k];
        mass[k] = temp;
    }

    @Override
    public E peek() {
        return (E) queue[0];
    }
}

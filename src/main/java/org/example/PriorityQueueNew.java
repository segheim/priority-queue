package org.example;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;

public class PriorityQueueNew extends AbstractQueue {

    private static final int DEFAULT_CAPACITY = 8;

    Integer[] queue;
    int size;

    PriorityQueueNew(int capacity) {
        this.queue = new Integer[capacity];
    }

    PriorityQueueNew() {
        this.queue = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean add(Integer element) {
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
        siftUp(size, element, queue);
        size = length + 1;
        return true;
    }

    private void siftUp(int i, Integer element, Integer[] queue) {
        while (i > 0) {
            int k;
            if (i % 2 == 0) {
                k = i / 2 - 1;
            } else {
                k = i / 2;
            }
            if (element < queue[k]) {
                queue[i] = queue[k];
                queue[k] = element;
                i = k;
            } else {
                queue[i] = element;
                break;
            }
        }
    }

    private void growCapacity() {
        int newCapacity = size + DEFAULT_CAPACITY;
        queue = Arrays.copyOf(queue, newCapacity);
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Integer poll() {
        int i = 0;
        int firstElement = queue[i];
        size = size - 1;
        queue[i] = queue[size];
        queue[size] = null;

        while ((i * 2 + 1) < size) {
            int k;
            if (queue[i * 2 + 2] != null) {
                if (queue[i * 2 + 1] > queue[i * 2 + 2]) {
                    k = i * 2 + 2;
                    int temp = queue[i];
                    queue[i] = queue[k];
                    queue[k] = temp;
                } else {
                    k = i * 2 + 1;
                    int temp = queue[i];
                    queue[i] = queue[k];
                    queue[k] = temp;
                }
            } else {
                k = i * 2 + 1;
                if (queue[k] < queue[i]) {
                    int temp = queue[i];
                    queue[i] = queue[k];
                    queue[k] = temp;
                }
            }
            i = k;
        }
        return firstElement;
    }

    @Override
    public Object peek() {
        return queue[0];
    }
}

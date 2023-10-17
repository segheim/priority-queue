package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        PriorityQueue priorityQueue = new PriorityQueue();
//        priorityQueue.add();
//        priorityQueue.peek()
        PriorityQueueNew priorityQueueNew = new PriorityQueueNew();
        priorityQueueNew.add(10);
        priorityQueueNew.add(17);
        priorityQueueNew.add(55);
        priorityQueueNew.add(21);
        priorityQueueNew.add(33);
        priorityQueueNew.add(72);
        priorityQueueNew.add(50);
        priorityQueueNew.add(4);
        priorityQueueNew.add(20);
        priorityQueueNew.add(11);
        priorityQueueNew.add(3);
        priorityQueueNew.add(9);
        priorityQueueNew.add(22);
        priorityQueueNew.add(1);
        priorityQueueNew.add(12);
        priorityQueueNew.add(41);
        priorityQueueNew.add(44);
        priorityQueueNew.add(29);
        Integer[] queue = priorityQueueNew.queue;
        System.out.println(Arrays.toString(queue));
        System.out.println(priorityQueueNew.size);
        System.out.println("Peek = " + priorityQueueNew.peek());

        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
        System.out.println("Pool = " + priorityQueueNew.poll());

        System.out.println(Arrays.toString(priorityQueueNew.queue));
    }
}
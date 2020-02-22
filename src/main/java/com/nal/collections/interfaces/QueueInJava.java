package com.nal.collections.interfaces;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 19/02/20.
 * Queue is a collection used to hold multiple elements prior to processing. Besides basic Collection operations,
 * a Queue provides additional insertion, extraction, and inspection operations.
 * Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner.
 * Among the exceptions are priority queues, which order elements according to a supplied comparator or the
 * elements’ natural ordering. Whatever the ordering used, the head of the queue is the element that would be
 * removed by a call to remove or poll. In a FIFO queue, all new elements are inserted at the tail of the queue.
 */
public class QueueInJava {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
    }
}

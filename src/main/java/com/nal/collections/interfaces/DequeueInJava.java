package com.nal.collections.interfaces;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by nishant on 19/02/20.
 * A linear collection that supports element insertion and removal at both ends. The name deque is short for
 * “double-ended queue” and is usually pronounced “deck”. Most Deque implementations place no fixed limits
 * on the number of elements they may contain, but this interface supports capacity-restricted deques as well
 * as those with no fixed size limit.
 * This interface defines methods to access the elements at both ends of the deque. Methods are provided to
 * insert, remove, and examine the element.
 */
public class DequeueInJava {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(2);
        deque.addFirst(1);
        deque.addLast(3);
        deque.remove();
        deque.removeFirst();
        deque.removeLast();
    }
}

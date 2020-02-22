package com.nal.collections.interfaces;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 19/02/20.
 * Set is a collection that cannot contain duplicate elements.
 * The Java platform contains three general-purpose Set implementations: HashSet, TreeSet, and LinkedHashSet.
 * Set interface doesn’t allow random-access to an element in the Collection.
 * You can use iterator or foreach loop to traverse the elements of a Set.
 */
public class SetInJava {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.contains(1);
        set.remove(1);
    }
}

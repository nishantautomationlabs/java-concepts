package com.nal.collections;

import java.util.*;

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
        System.out.println("Add 1: " + set.add(1));
        System.out.println("Add 1: " + set.add(1));
        System.out.println("Add 1: " + set.add(2));
        System.out.println("Contains 1: " + set.contains(1));
        System.out.println("Size:" + set.size());
        System.out.println("Remove 1:" + set.remove(1));
        System.out.println("Remove 1:" + set.remove(1));
        System.out.println("Is Empty:" + set.isEmpty());
        int value = set.iterator().next();
        System.out.println("Value: " +value);
        set.clear();

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(2);
        Integer[] arr = new Integer[integerSet.size()];
        integerSet.toArray(arr); //Convert set to integer array
        System.out.println(Arrays.toString(arr));
        List<Integer> integerList = new ArrayList<>(integerSet); //Covert set to ArrayList
        System.out.println(integerList);
        Iterator<Integer> iterator = integerSet.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("sadsa", "Sadsa", "dsds"));
        HashSet<String> setFromArray = new HashSet<>(arrayList);
        setFromArray.stream().forEach(System.out:: println);
    }
}

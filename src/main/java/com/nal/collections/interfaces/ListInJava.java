package com.nal.collections.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 19/02/20.
 * List is an ordered collection and can contain duplicate elements. You can access any element from its index.
 * List is more like array with dynamic length. List is one of the most used Collection type.
 * ArrayList and LinkedList are implementation classes of List interface.
 * List interface provides useful methods to add an element at a specific index,
 * remove/replace element based on the index and to get a sub-list using the index.
 * Collections class provide some useful algorithm for List – sort, shuffle, reverse, binarySearch etc.
 */
public class ListInJava {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        //add at the end of the list
        strList.add("0");
        //add at a specified index
        strList.add(0, "1");
        //replace value at index
        strList.set(0, "2");
        strList.add("2");
        //remove value
        System.out.println("Remove: " + strList.remove("1"));
        //if duplicate items are present remove the first occurrence
        System.out.println("Remove: " + strList.remove("2"));
        //remove based on index
        strList.remove(0);
        //get based on index
        System.out.println("Get element at index 0: " + strList.get(0));

        System.out.println(strList.size());
//        Collections.disjoint();
//        Collections.frequency();
//        Collections.sort();
//        Collections.reverse();
//        Collections.binarySearch();
//        Collections.shuffle();
//        strList.removeAll();
//        strList.replaceAll();
//        strList.retainAll();
//        strList.isEmpty();
//        strList.clear();
//        strList.addAll();
//        strList.addAll();
//        strList.indexOf();
//        strList.lastIndexOf();
//        strList.contains();
//        strList.containsAll();
//        strList.iterator();
//        strList.listIterator();
//        strList.listIterator(1);
//        strList.spliterator();
//        strList.subList();
//        strList.sort();
//        strList.equals();
//        strList.toArray();


    }

}

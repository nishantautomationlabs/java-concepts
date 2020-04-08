package com.nal.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        strList.add("0");  //add at the end of the list
        strList.add(0, "1");  //add at a specified index
        strList.set(0, "2");    //replace value at index
        strList.add("2");      //add duplicate value 2
        strList.add("3");      //add value
        strList.add("4");      //add value
        strList.add("5");      //add value
        System.out.println("Remove 1: " + strList.remove("1"));   //remove value
        System.out.println("Remove 2: " + strList.remove("2"));   //if duplicate items are present remove the first occurrence
        strList.remove(0);  //remove based on index
        strList.remove(strList.size() - 1);  //remove last element
        System.out.println("Get element at index 0: " + strList.get(0));    //get based on index
        System.out.println(strList.size());     //get size

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 9, 3));
        System.out.println(list.get(0));
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(0, 0);  //add at particular index
        System.out.println(list);
        list.set(2,2);  //update value at particular index
        System.out.println(list);
        result.add(list);
        List<Integer> subList = list.subList(1, 2);  //sublist from list from index 1 inclusive to 2 exclusive
        System.out.println("List:" + list);
        System.out.println("SubList:" + subList);
        System.out.println("Index of 3 in list:" + list.indexOf(3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7}));
        System.out.println("List2:" + list);
        result.add(list2);
        System.out.println("Result:" + result);

        //List to Array
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 9, 3));
        Integer[] array = integerList.toArray(new Integer[0]);
        //OR
        Integer[] array2 = new Integer[integerList.size()];
        integerList.toArray(array2);

        //Copy Array
        Integer[] array3 = Arrays.copyOf(array, array.length);
        array3[0] = 5;

        System.out.println(Arrays.asList(array));
        System.out.println(Arrays.asList(array2));
        System.out.println(Arrays.asList(array3));

        List<Integer> indexes = new ArrayList<>();
        indexes.add(2);
        indexes.add(4);
        indexes.add(7);
        indexes.add(9);
        indexes.add(11);
        System.out.println("LIST for binary search:" + indexes);
        int index1 = Collections.binarySearch(indexes, 4);
        System.out.println("Binary Search 4:" + index1);
        index1 = Collections.binarySearch(indexes, 5);
        System.out.println("Binary Search 5:" + index1);
        indexes.add(Math.abs(index1 + 1), 5);
        System.out.println("LIST for binary search:" + indexes);
        index1 = Collections.binarySearch(indexes, 1);
        System.out.println("Binary Search 1:" + index1);
        indexes.add(Math.abs(index1 + 1), 1);
        System.out.println("LIST for binary search:" + indexes);
        index1 = Collections.binarySearch(indexes, 12);
        System.out.println("Binary Search 12:" + index1);
        indexes.add(Math.abs(index1 + 1), 12);
        System.out.println("LIST for binary search:" + indexes);

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

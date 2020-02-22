package com.nal.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 20/02/20.
 */
public class GenericsWildcards {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(5);
        integerList.add(10);
        double sum = sum(integerList);
        System.out.println("Sum of integers : " + sum);

        addIntegers(integerList);
        List<Number> numbers =  new ArrayList<>();
        addIntegers(numbers);
        List<Object> objectList = new ArrayList<>();
        addIntegers(objectList);

//        Subtyping using Generics Wildcard
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
    }

    private static <T extends Number> double sum(List<T> integerList) {
        double sum = 0;
        for (Number n : integerList) {
            sum += n.doubleValue();
        }
        return sum;
    }

    //    Upper Bounded Wildcard
//    Note that with upper bounded list, we are not allowed to add any object to the list except null.
//    If we will try to add an element to the list inside the sum method, the program won’t compile.
    private static double sum2(List<? extends Number> integerList) {
        double sum = 0;
        for (Number n : integerList) {
            sum += n.doubleValue();
        }
        return sum;
    }

    private void printData(List<?> list) {
        for (Object obj : list)
            System.out.println(obj);
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(50);
    }

}

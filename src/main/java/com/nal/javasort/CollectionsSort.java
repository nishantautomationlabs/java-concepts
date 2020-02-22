package com.nal.javasort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by nishant on 19/02/20.
 */
public class CollectionsSort {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(4,5,3,6,2,1));
        Collections.sort(integerList);
        System.out.println(integerList);

        List<String> stringList = new ArrayList<>(Arrays.asList("asav", "dsds", "fdfd", "fdffddg"));
        Collections.sort(stringList);
        System.out.println(stringList);
    }
}

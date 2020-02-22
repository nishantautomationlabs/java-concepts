package com.nal.javasort;

import java.util.Arrays;

/**
 * Created by nishant on 19/02/20.
 */
public class ArraysSort {

    public static void main(String[] args) {
        //sorting primitives arrays
        int[] arr = {4,5,3,6,2,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //Sorting String Array
        String[] strArray = {"asav", "dsds", "fdfd", "fdffddg"};
        Arrays.sort(strArray);
        System.out.println(Arrays.toString(strArray));
    }
}

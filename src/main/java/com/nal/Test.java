package com.nal;

import java.util.*;

/**
 * Created by nishant on 04/02/20.
 */
public class Test {
    public static void main(String[] args) {
//        boolean b = true || false && false;

        System.out.println("first".substring(0,4));

        int a = Integer.valueOf('a');
        int sa = Integer.parseInt("124");
        String s3 = Integer.toString(sa);

        String input = "/home/opt/";
        String[] splitStr = input.split("/");
        System.out.println(splitStr.length);

        System.out.println(sa);

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<int[]> ints = Arrays.asList(matrix);
        Collections.reverse(Arrays.asList(matrix));


        int[] arr = {1, 4, 5, 2, 3};
//        arr = new int[]{2, 3, 4, 6};
        Arrays.sort(arr);
        int[] newarr = new int[10];
        System.arraycopy(arr, 1, newarr, 3, 4);
//        String[] str = {"asasd","dfd", "ewe", "sdsdsds2"};
//
//        Arrays.sort(str, Comparator.comparingInt(String::length).reversed());
//        for(String str1 : str)
//            System.out.println(str1);

        String s1 = Integer.toString(123);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        List<Integer> integerArray = new ArrayList<>(stack);
        stack.isEmpty();

//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        String key = new String(chars);

        String[] sas =
                "2001:0db8:85a3.0:0.8A2E:0370:7334:".split("0.");


        String s = "  hello world!  ";
        s.length();
        char[] chars = {'a','b','b'};

        char a1 = Character.toLowerCase('A');

//        Math.pow

        String[] words = s.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        s = String.join(" ", words);
        System.out.println(s);

    }
}

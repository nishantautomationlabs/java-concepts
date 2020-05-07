package com.nal.utils;

/**
 * Created by nishant on 04/05/20.
 */
public class StringBuilderUtil {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("nishant singh");
        sb.insert(0, "A");
        sb.append('a');
        char ab = sb.charAt(3);
        sb.setCharAt(3, 'a');
        sb.deleteCharAt(3);
        sb.append("nishant");
        sb.append(12);
//        Math.pow()  //returns double
//        sb.length();
        sb.reverse();
//        sb.setLength(0);
        System.out.println(sb.toString());
        System.out.println("Done");
    }
}

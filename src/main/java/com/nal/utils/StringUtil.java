package com.nal.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by nishant on 04/05/20.
 */
public class StringUtil {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>(Arrays.asList("this", "is", "a", "statement"));
        System.out.println(String.join(" ", words));

        Stack<String> stringStack = new Stack<>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        System.out.println(String.join("/", stringStack));

        char[] chars = {'a', 'b', 'c'};
        String s = new String(chars);
        System.out.println(s);
    }
}

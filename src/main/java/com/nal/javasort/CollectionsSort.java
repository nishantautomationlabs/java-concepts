package com.nal.javasort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nishant on 19/02/20.
 */
public class CollectionsSort {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(4,5,3,6,2,1));
        Collections.sort(integerList);
        System.out.println(integerList);

        List<String> stringList = new ArrayList<>(Arrays.asList("fdfd", "dsds", "asav", "fdffddg"));
        Collections.sort(stringList);
        System.out.println(stringList);


        List<String> str2 = new ArrayList<>();
        str2.add("dsad");
        str2.add("dsd");
        str2.add("dabb");
        str2.add("ds");
        str2.add("da");
        str2.add("db");
        str2.add("dssdfdf");
        Collections.sort(str2);
        System.out.println(str2);

        Collections.sort(str2, (s1, s2) -> {
            if(s1.length() != s2.length())
                return s2.length() - s1.length();
            return s1.compareTo(s2);
        });
        System.out.println("Sort by Length desc and then lexicographically order:\n" + str2);
//        str2 = str2.stream().sorted(Comparator.comparingInt(s -> s.length())).collect(Collectors.toList());
    }
}

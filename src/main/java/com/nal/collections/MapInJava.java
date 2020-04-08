package com.nal.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by nishant on 19/02/20.
 * Java Map is an object that maps keys to values. A map cannot contain duplicate keys:
 * Each key can map to at most one value.
 * The Java platform contains three general-purpose Map implementations: HashMap, TreeMap, and LinkedHashMap.
 * The basic operations of Map are put, get, containsKey, containsValue, size, and isEmpty.
 */
public class MapInJava {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1","nishant");
        map.put("2","singh");
        map.get("2");
        map.getOrDefault("2", "something");
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Set<String> keySet = map.keySet();
        System.out.println("KeySet:" + keySet);
        Collection<String> values = map.values();
        System.out.println("Values:" + values);
        System.out.println("Contains Key: " + map.containsKey("1"));
        System.out.println("Contains Value: " + map.containsValue("nishant"));
        map.remove("2");

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}

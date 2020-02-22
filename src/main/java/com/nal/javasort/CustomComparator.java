package com.nal.javasort;

import java.util.Comparator;

/**
 * Created by nishant on 19/02/20.
 */
public class CustomComparator implements Comparator<CustomSortUsingComparator> {

    @Override
    public int compare(CustomSortUsingComparator o1, CustomSortUsingComparator o2) {
        return o1.getId() - o2.getId();
    }
}

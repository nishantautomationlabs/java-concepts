package com.nal;

import java.util.*;

/**
 * Created by nishant on 05/02/20.
 */
public class Solution {

    public static void main(String[] args) {
        Integer.toString(123);
        int a = 123;
        StringBuilder s = new StringBuilder();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map.Entry<Integer, Integer> integerIntegerEntry = map.firstEntry();

        int[] arr = {4, 5, 3, 6, 1, 2, 7};
        Solution sol = new Solution();
        int res = sol.kthLargest(arr, 1);
        System.out.println("kth Largest Element is: " + res);
    }

    private int kthLargest(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k > arr.length || k < 1) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int pIndex = -1;
        while (pIndex != k - 1) {
            pIndex = partition(arr, start, end);
            if (k - 1 > pIndex) {
                start = pIndex + 1;
            } else if (k - 1 < pIndex) {
                end = pIndex - 1;
            }
        }
        return arr[pIndex];
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int index = start;
        for (int i = start; i < end; i++) {
            if (arr[i] > pivot) {
                swap(arr, i, index++);
            }
        }
        swap(arr, index, end);
        return index;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int kthLargest2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k > arr.length) {
            return -1;
        }
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr) {
            if (minHeap.isEmpty() || minHeap.size() < k || val > minHeap.peek()) {
                minHeap.add(val);
            }
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}







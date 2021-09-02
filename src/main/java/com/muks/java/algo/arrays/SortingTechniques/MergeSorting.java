package com.muks.java.algo.arrays.SortingTechniques;

public class MergeSorting {
    public static void main(String[] args) {
        int[] arr = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};

        mergeSort(arr, 0, arr.length-1);

        System.out.println("printing the sorted elements");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void mergeSort(int[] arr, int start, int end) {
        int mid;
        if (start < end) {
            mid = (start + end) / 2;     // avoid integer overloading

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] array, int beg, int mid, int end) {
        int i = beg, j = mid + 1;
        int k, index = beg;

        int[] temp = new int[array.length];

        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                temp[index] = array[i];
                i++;
            } else {
                temp[index] = array[j];
                j++;
            }
            index++;
        }
        if (i > mid) {
            while (j <= end) {
                temp[index] = array[j];
                index++;
                j++;
            }
        } else {
            while (i <= mid) {
                temp[index] = array[i];
                index++;
                i++;
            }
        }
        k = beg;
        while (k < index) {
            array[k] = temp[k];
            k++;
        }
    }
}
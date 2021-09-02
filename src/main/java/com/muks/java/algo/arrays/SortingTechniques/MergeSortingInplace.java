package com.muks.java.algo.arrays.SortingTechniques;


/**
 * Time complexity:
 *  At each level, the merging of elements is = 'n'
 *  diving the entire array is like a height balanced tree, height = log-n
 *
 *  so, no. of levels, or height of recursive tree = LOG(n) AND merging at each level = 'n'
 *
 *  Time-complexity = O(n x Log-n)
 *
 *  Space: depends if in-place then O(n) OR O(n + n)
 */
public class MergeSortingInplace {

    public static void main(String[] args) {
        int[] input1 = {3, 2, 5, 1, 4, 0};
        int[] input2 = {4, 2};
        mergeSort(input1);
        printArray(input1);

        mergeSort(input2);
        printArray(input2);
    }


    private static void mergeSort(int[] input) {
        // base case on when to break the recursion loop
        if (input.length <= 1) {
            return;
        }

        if (input.length == 1) {
            if (input[0] > input[1]) {
                int tmp = input[0];
                input[0] = input[1];
                input[1] = tmp;
            }
            return;
        }

        // Split the array in half
        int mid = input.length/2;
        int[] first = new int[mid];
        int[] second = new int[input.length - mid];

        // generate first half of the array
        for (int i = 0 ; i < mid; i++) {
            first[i] = input[i];
        }

        // generate second half of the array
        for (int j = mid; j < input.length; j++) {
            second[j - mid] = input[j];
        }

        // Sort each half
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, input);

    }

    private static void merge(int[] first, int[] second, int[] actualArray) {
        int indxFirst = 0;
        int indxSecond = 0;

        int j = 0;

        while (indxFirst < first.length && indxSecond < second.length) {
            if (first[indxFirst] < second[indxSecond]) {
                actualArray[j] = first[indxFirst];
                indxFirst++;
            } else {
                actualArray[j] = second[indxSecond];
                indxSecond++;
            }
            j++;
        }

        // copy what's left
        System.arraycopy(first, indxFirst, actualArray, j, first.length - indxFirst);
        System.arraycopy(second, indxSecond, actualArray, j, second.length - indxSecond);
    }



    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(" " + i);
        }
        System.out.println(sb.toString());
    }
}   // end class


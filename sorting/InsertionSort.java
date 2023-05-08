package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] ans = solve(array);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array) {
        // Best: O(n) time | O(1) space
        // Average: O(n^2) time | O(1) space
        // Worst: O(n^2) time | O(1) space
        if (array.length == 0) {
            return new int[] {};
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j-1]) {
                swap(j, j - 1, array);
                j -= 1;
            }
        }
        return array;
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}

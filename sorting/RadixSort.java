package Sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {7865, 6574, 5643, 99, 110, 9, 92, 778};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int exp = 1;
        while (max > 0) {
            max /= 10;
            countSort(arr, exp);
            exp *= 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] p = new int[10]; // range of digits --> from 0 to 9

        // 1. create the freq-array
        for (int i = 0; i < n; i++) {
            p[(arr[i] / exp) % 10]++;
        }

        // 2. convert this array into pSum array
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] + p[i];
        }

        // 3. traverse on the original array and try to update ans[]
        int[] ans = new int[n];

        for (int i = n - 1; i > -1; i--) {
            int pos = p[(arr[i] / exp) % 10];
            ans[pos - 1] = arr[i];
            p[(arr[i] / exp) % 10]--;
        }

        // copy your answer to original array
        System.arraycopy(ans, 0, arr, 0, ans.length);
    }




}

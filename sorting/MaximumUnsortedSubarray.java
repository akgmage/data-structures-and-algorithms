package Sorting;

import java.util.Arrays;

public class MaximumUnsortedSubarray {
    public static void main(String[] args) {
        int[] array = { 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15};
        int[] ans = solve(array);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array) {
        // O(N) time | O(1) space

        // Variables to keep track of min and max elements.
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        // traverse and find the min and max out-of-order elements
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            if (isOutOfBounds(i, val, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, val);
                maxOutOfOrder = Math.max(maxOutOfOrder, val);
            }
        }
        if (minOutOfOrder == Integer.MAX_VALUE) {
            return new int[] {-1};
        }

        // traverse and find the correct position
        int subarrayLeftIdx = 0;

        while (minOutOfOrder >= array[subarrayLeftIdx]) {
            subarrayLeftIdx++;
        }

        int subarrayRightIdx = array.length - 1;

        while (maxOutOfOrder <= array[subarrayRightIdx]) {
            subarrayRightIdx--;
        }

        return new int[] {subarrayLeftIdx, subarrayRightIdx};
    }
    public static boolean isOutOfBounds (int i, int val, int[] array) {

        // edge cases
        if (i == 0) {
            return val > array[i+1];
        }

        if (i == array.length - 1) {
            return val < array[i-1];
        }

        return val > array[i+1] || val < array[i-1];
    }
}

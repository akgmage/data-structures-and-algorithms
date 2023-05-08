/**
 * Problem Description
 * Given an array of integers A of size N and an integer B.
 *
 * In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
 *
 * Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
 * If there are several such numbers, your task is to find the minimum one.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 * 0 <= B <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return an array C of size 2, where C[0] is number of occurence and C[1] is the number with maximum occurence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 1, 2, 2, 1]
 *  B = 3
 * Input 2:
 *
 *  A = [5, 5, 5]
 *  B = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  [4, 2]
 * Output 2:
 *
 *  [3, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Apply operations on A[2] and A[4]
 *  A = [3, 2, 2, 2, 2]
 *  Maximum occurence =  4
 *  Minimum value of element with maximum occurence = 2
 * Explanation 2:
 *
 *  A = [5, 5, 5]
 *  Maximum occurence =  3
 *  Minimum value of element with maximum occurence = 5
 */
package Searching;

import java.util.Arrays;

public class AddOrNot {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 5, 6};
        int b = 4;
        int[] ans = solve(array, b);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array, int b) {
        /**
         *  1. Brute Force
         *  O(N^2) time | O(1) space
         */

         //        for (int i = 0; i < array.length; i++) {
         //            int num = array[i];
         //            int count = 0;
         //            for (int j = i; j > -1; j--) {
         //                if (array[i] - array[j] <= b) {
         //                    count++;
         //                    b -= array[i] - array[j];
         //                } else {
         //                    break;
         //                }
         //            }
         //            if (count > ans[0] && array[i] > ans[1]) {
         //                ans[0] = count;
         //                ans[1] = array[i];
         //            }
         //        }

        Arrays.sort(array);

        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        long[] prefix = new long[array.length + 1];
        int n = array.length;

        // make prefix array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] += array[i] + prefix[i];
        }

        for (int i = 0; i < n; i++) {
            int left = 1, right = i + 1;
            int max = 0;

            // Binary search to find the value of count for i
            while (left <= right) {
                int count = left + (right - left) / 2;
                if ( (long) array[i] * count - (prefix[i + 1] - prefix[i - count + 1]) <= b ) {
                    max = count;
                    left = count + 1;
                } else {
                    right = count - 1;
                }
            }
            // update ans
            if (ans[0] < max) {
                ans[0] = max;
                ans[1] = array[i];
            }
        }
        return ans;
    }
}

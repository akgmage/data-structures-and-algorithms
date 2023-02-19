/**
 * Problem Description
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * -10^9 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return whether the given array contains a subarray with a sum equal to 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [-1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  No subarray has sum 0.
 * Explanation 2:
 *
 *  The array has sum 0.
 */

package Hashing;

import java.util.HashSet;

public class SubarrayWithSumZero {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        boolean res = solve(array);
        System.out.println(res);
    }
    public static boolean solve(int[] array) {
        // O(N) time | O(N) space

        int len = array.length;

        // Bruteforce
//        for (int i = 0; i < len; i++) {
//            int sum = 0;
//            for (int j = i; j < len; j++) {
//                sum += array[j];
//                if (sum == 0) return true;
//            }
//        }

        long prefixSum = 0;
        HashSet<Long> hashSet = new HashSet<>();

        hashSet.add(0L); // You can put 0 or you can check in for loop if there exist element of 0

        for (int num: array) {
            prefixSum += num;

//            if (prefixSum == 0) return true;

            if (hashSet.contains(prefixSum)) return true;

            hashSet.add(prefixSum);
         }
        return false;
    }
}

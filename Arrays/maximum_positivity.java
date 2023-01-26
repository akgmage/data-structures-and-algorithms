/**
 * Given an array of integers A, of size N.
 *
 * Return the maximum size subarray of A having only non-negative elements. If there are more than one such subarray, return the one having the smallest starting index in A.
 *
 * NOTE: It is guaranteed that an answer always exists.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return maximum size subarray of A having only non-negative elements. If there are more than one such subarrays, return the one having earliest starting index in A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 6, -1, 7, 8]
 * Input 2:
 *
 *  A = [1, 2, 3, 4, 5, 6]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [5, 6]
 * Output 2:
 *
 *  [1, 2, 3, 4, 5, 6]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are two subarrays of size 2 having only non-negative elements.
 *  1. [5, 6]  starting point  = 0
 *  2. [7, 8]  starting point  = 3
 *  As starting point of 1 is smaller, return [5, 6]
 * Explanation 2:
 *
 *  There is only one subarray of size 6 having only non-negative elements:
 *  [1, 2, 3, 4, 5, 6]
 */
package InterviewProblems;

import java.util.Arrays;

public class MaximumPositivity {

    public static void main(String[] args) {
//        int[] array = {3341620, -7399236, 5207903, -1729033, 7603748, -3283659, 4646901, 9983066, -1239862, -2196498};
        int[] array = {9, 3, -2, 11, 1, 2};
//        int[] array = {1, 2, 3, 4, 5};
        int[] ans = solve(array);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solve(int[] array) {
        // O(N) time | O(1) space
        int size = 0, leftIdx = 0, rightIdx = 0, len = array.length;
        for (int currentLeftIdx = -1, currentRightIdx = 0; currentRightIdx < len; currentRightIdx++) {
            int currentRightNum = array[currentRightIdx];
            if (currentRightNum > -1) {
                if (size < currentRightIdx - currentLeftIdx) {
                    size = currentRightIdx - currentLeftIdx;
                    leftIdx = currentLeftIdx;
                    rightIdx = currentRightIdx;
                }
            } else currentLeftIdx = currentRightIdx;
        }
        return Arrays.copyOfRange(array, leftIdx + 1, rightIdx + 1);
    }


    public static int[] solveUsingBruteForce(int[] A) {
        // O(N^2) time | O(1) space
        int maxLen = 0;
        int startIdx = 0;
        int currentLen = 0;
//        int endIdx = 0;
        for (int i = 0; i < A.length; i++) {
            currentLen = 0;
            int currentNum = A[i];
            int j = i;
            if (currentNum > -1) {
                while (j < A.length && A[j] > -1) {
                    j++;
                    currentLen++;
                }
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    startIdx = i;
//                    endIdx = j;
                }
            }
            i = j;
        }
        return Arrays.copyOfRange(A, startIdx, startIdx + maxLen);
    }
}

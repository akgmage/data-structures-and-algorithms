/**
 * Problem Description
 * Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the single element that appears only once.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 7]
 * Input 2:
 *
 * A = [2, 3, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  7 appears once
 * Explanation 2:
 *
 *  2 appears once
 */
package Searching;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] array = {1, 1, 7};
        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] array) {
        // O(LogN) time | O(1) space
        int n = array.length;
        if (n == 1) {
            return array[0];
        }
        if (array[0] != array[1]) {
            return array[0];
        }
        if (array[n - 1] != array[n - 2]) {
            return array[n - 1];
        }

        int left = 1, right = n - 2;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (array[mid] != array[mid-1] && array[mid] != array[mid+1]) {
                return array[mid];
            }

            // find first occurrence so that it will be easy

            /**
             * if the first occurrence is even then unique will be on right side
             *  else unique will be on left side
             */

            int firstOccurance = -1;
            if (array[mid] == array[mid-1]) {
                firstOccurance = mid - 1;
            } else {
                firstOccurance = mid;
            }

            if (firstOccurance % 2 == 0) {
                left = firstOccurance + 2; // or left = mid + 1;
            } else {
                right = firstOccurance - 1; // or right = mid - 1;
            }
        }
        return -1;
    }
}

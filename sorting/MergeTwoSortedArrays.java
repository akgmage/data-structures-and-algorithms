/**
 * Problem Description
 * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
 *
 *
 *
 * Problem Constraints
 * -1010 <= A[i], B[i] <= 1010
 *
 *
 *
 * Input Format
 * First Argument is a 1-D array representing A.
 *
 * Second Argument is also a 1-D array representing B.
 *
 *
 *
 * Output Format
 * Return a 1-D vector which you got after merging A and B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [4, 7, 9 ]
 * B = [2, 11, 19 ]
 * Input 2:
 *
 * A = [1]
 * B = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 4, 7, 9, 11, 19]
 * Output 2:
 *
 * [1, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Merging A and B produces the output as described above.
 * Explanation 2:
 *
 *  Merging A and B produces the output as described above.
 */
package Sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] array1 = {4, 7, 9};
        int[] array2 = {2, 11, 19};
        int[] ans = solve(array1, array2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array1, int[] array2) {
        // O(N+M) time | O(N+M) space

        int n = array1.length;
        int m = array2.length;
        int[] ans = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                ans[k++] = array1[i++];
            } else {
                ans[k++] = array2[j++];
            }
        }

        while ( i < array1.length) {
            ans[k++] = array1[i++];
        }

        while (j < array2.length) {
            ans[k++] = array2[j++];
        }
        return ans;
    }
}

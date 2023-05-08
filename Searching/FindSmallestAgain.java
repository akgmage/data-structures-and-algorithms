/**
 * Given an integer array A of size N.
 *
 * If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.
 *
 * NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
 *
 *
 *
 * Problem Constraints
 * 3 <= N <= 500
 * 1 <= A[i] <= 108
 * 1 <= B <= (N*(N-1)*(N-2))/6
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 * The second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the Bth element of the list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 4, 3, 2]
 *  B = 3
 * Input 2:
 *
 *  A = [1, 5, 7, 3, 2]
 *  B = 9
 *
 *
 * Example Output
 * Output 1:
 *
 *  9
 * Output 2:
 *
 *  14
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All the triplets of the array A are:
 *
 *  (2, 4, 3) = 9
 *  (2, 4, 2) = 8
 *  (2, 3, 2) = 7
 *  (4, 3, 2) = 9
 *
 *  So the 3rd smallest element is 9.
 */
package Searching;

import java.util.*;

public class FindSmallestAgain {
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 2};
        int b = 3;
        int ans = solve(array, b);
        System.out.println(ans);
    }
    public static int solve(int[] array, int b) {


        /**
         *  ---- BRUTE FORCE ----
         * List<Integer> list = new ArrayList<>();
         *
         *         int n = array.length;
         *
         *         for (int i = 0; i < n - 2; i++) {
         *             for (int j = i + 1; j < n - 1; j++) {
         *                 for (int k = j + 1; k < n; k++) {
         *                     list.add(array[i] + array[j] + array[k]);
         *                 }
         *                 Collections.sort(list);
         *             }
         *         }
         *         // Collections.sort(list);
         *         return list.get(b-1);
         */

        /**
         *  -- BINARY SEARCH --
         *  O(N^2*Log(N)) time | O(1) space
         *
         */
        Arrays.sort(array);
        int n = array.length;
        int left = 0, right = array[n - 1] + array[n - 2] + array[n - 3];
        int ans = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            // count of triplets with sum less than middle
            int count = getTripletsCount(array, middle);
            if (count >= b) {
                // do not add, go left
                right = middle - 1;
            } else {
                ans = middle; // add to ans and go right
                left = middle + 1;
            }
        }
        return ans;
    }
    public static int getTripletsCount(int[] array, int target) {
        int count = 0;

        for (int i = 0; i < array.length - 2; i++) {
            int start = i + 1, end = array.length - 1;

            while (start < end) {
                if (array[i] + array[start] + array[end] < target) {
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }


}

/**
 * Given an array A of N integers.
 *
 * Find the length of the longest subarray in the array which sums to zero.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 *
 *
 * Input Format
 * Single argument which is an integer array A.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, -2, 1, 2]
 * Input 2:
 *
 *  A = [3, 2, -1]
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [1, -2, 1] is the largest subarray which sums up to 0.
 * Explanation 2:
 *
 *  No subarray sums up to 0.
 */
package Hashing;

import java.util.HashMap;

public class LongestSubarrayZeroSum {
    public static void main(String[] args) {
        int[] array = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};

        int res = solve(array);
        System.out.println(res);
    }
    public static int solve(int[] array) {
        // O(N) time | O(N) space
        int res = 0;
        long prefixSum = 0;
        HashMap<Long, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            prefixSum += array[i];

            if (prefixSum == 0) res = i + 1;
            else if (!hashMap.containsKey(prefixSum))
                       hashMap.put(prefixSum, i);
            else
                res = Math.max(res, i - hashMap.get(prefixSum));

        }
        return res;
    }
}

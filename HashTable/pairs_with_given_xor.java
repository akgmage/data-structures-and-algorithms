/**
 * Problem Description
 * Given an integer array A containing N distinct integers.
 *
 * Find the number of unique pairs of integers in the array whose XOR is equal to B.
 *
 * NOTE:
 *
 * Pair (a, b) and (b, a) is considered to be the same and should be counted once.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i], B <= 107
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 * The second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 4, 10, 15, 7, 6]
 *  B = 5
 * Input 2:
 *
 *  A = [3, 6, 8, 10, 15, 50]
 *  B = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  (10 ^ 15) = 5
 * Explanation 2:
 *
 *  (3 ^ 6) = 5 and (10 ^ 15) = 5
 */
package Hashing;

import java.util.HashSet;

public class PairsWithGivenXor {
    public static void main(String[] args) {
        int[] array = {5,4, 10, 15, 7, 6};
        int target = 5;
        int res = solve(array, target);
        System.out.println(res);
    }
    public static int solve(int[] array, int target) {
        //O(N) time | O(N) space
        int res = 0;
        HashSet<Integer> nums = new HashSet<>();
        for (int num : array) {
            int potentialMatch = target ^ num;
            if (nums.contains(potentialMatch)) res++;
            nums.add(num);
        }
        return res;
    }
}

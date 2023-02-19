/**
 * You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j. Since the answer can be very large, return the remainder after dividing the count with 109+7.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 * Input Format
 * First argument A is an array of integers and second argument B is an integer.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [3, 5, 1, 2]
 * B = 4
 * Input 2:
 *
 * A = [1, 2, 1, 2]
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Example 1:
 *
 * The only pair is (2, 3) which gives difference as 4
 * Example 2:
 *
 * The pair which gives difference as 3 are (2, 1), (4, 1), (2, 3) and (4, 3).
 */
package Hashing;

import java.util.HashMap;

public class CountPairDifference {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 2};
        int targetSum = 3;

        int res = solve(array, targetSum);
        System.out.println(res);
    }
    public static int solve(int[] array, int targetSum) {
        // O(N) time | O(N) space
        int res = 0;
        int MOD = (int) (1e9 + 7);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        /**
         * targetSum = a - b
         * a = targetSum + b
         * b = a - targetSum
         */

        for (int currentNum : array) {
            res = (res + hashMap.getOrDefault(targetSum - currentNum, 0) + hashMap.getOrDefault(targetSum - currentNum, 0)) % MOD;
            hashMap.put(currentNum, hashMap.getOrDefault(currentNum, 0 ) + 1);
        }
        return (int) res;
    }
}

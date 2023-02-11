/**
 * Problem Description
 * Given an array A. You have some integers given in the array B.
 *
 * For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 * 1 <= |B| <= 105
 *
 * 1 <= A[i] <= 105
 *
 * 1 <= B[i] <= 105
 *
 *
 *
 * Input Format
 * First argument A is an array of integers.
 *
 * Second argument B is an array of integers denoting the queries.
 *
 *
 *
 * Output Format
 * Return an array of integers containing frequency of the each element in B.
 *
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 1, 1]
 * B = [1, 2]
 * Input 2:
 * A = [2, 5, 9, 2, 8]
 * B = [3, 2]
 *
 *
 * Example Output
 * Output 1:
 * [3, 1]
 * Output 2:
 * [0, 2]
 *
 *
 * Example Explanation
 * For Input 1:
 * The frequency of 1 in the array A is 3.
 * The frequency of 2 in the array A is 1.
 * For Input 2:
 * The frequency of 3 in the array A is 0.
 * The frequency of 2 in the array A is 2.
 */
package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] array = {2, 5, 9, 2, 8};
        int[] queries = {3, 2};

        int[] res = solve(array, queries);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solve(int[] nums, int[] queries) {
        // O(N) time | O(Q) space where N is length of array , Q is length of queries

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            if (!hashMap.containsKey(num)) hashMap.put(num, 0);

            hashMap.put(num, hashMap.get(num) + 1);
        }
        System.out.println(hashMap);

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++)
            if (hashMap.containsKey(queries[i]))
                res[i] = hashMap.get(queries[i]);

        return res;
    }
}

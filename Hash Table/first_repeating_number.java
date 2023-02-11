/**
 * Problem Description
 * Given an integer array A of size N, find the first repeating element in it.
 *
 * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
 *
 * If there is no repeating element, return -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the first repeating element.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [10, 5, 3, 4, 3, 5, 6]
 * Input 2:
 *
 *  A = [6, 10, 5, 4, 9, 120]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  5 is the first element that repeats
 * Explanation 2:
 *
 *  There is no repeating element, output -1
 */
package Hashing;

import java.util.HashMap;

public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] array = {10, 5, 3, 4, 3, 5, 6};

        int res = solve(array);
        System.out.println(res);
    }
    public static int solve(int[] array) {
        // O(N) time | O(N) space where N is length of array

        // Build HashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : array) {

            if (!hashMap.containsKey(num)) hashMap.put(num, 0);
            hashMap.put(num, hashMap.get(num) + 1);
        }

        for (int num : array) {
            if (hashMap.get(num) > 1) return num;
        }

        return -1;
    }
}

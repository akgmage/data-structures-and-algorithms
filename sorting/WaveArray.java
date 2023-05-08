/**
 * Problem Description
 * Given an array of integers A, sort the array into a wave-like array and return it.
 * In other words, arrange the elements into a sequence such that
 *
 * a1 >= a2 <= a3 >= a4 <= a5.....
 * NOTE: If multiple answers are possible, return the lexicographically smallest one.
 *
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 106
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an array arranged in the sequence as described.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 1, 4, 3]
 * Output 2:
 *
 * [2, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * First answer is lexicographically smallest. So, return [2, 1, 4, 3].
 * Explanation 1:
 *
 * Only possible answer is [2, 1].
 */
package Sorting;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 2, 4 };
        int[] ans = solve(array);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array) {
        // sort the array
        Arrays.sort(array);
        int n = array.length;

        for (int i = 1; i < n; i+=2) {
            swap(i-1, i, array);
        }
        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

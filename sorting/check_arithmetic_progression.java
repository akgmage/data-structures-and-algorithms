/**
 * Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
 *
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 *
 *
 *
 * Problem Constraints
 * 2 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 5, 1]
 * Input 2:
 *
 *  A = [2, 4, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 * Explanation 2:
 *
 *  There is no way to reorder the elements to obtain an arithmetic progression.
 */
package Sorting;

import java.util.Arrays;

public class CheckArithmeticProgression {
    public static void main(String[] args) {
        int[] array = {3, 5, 1};
        int res = solve(array);
        System.out.println(res);
    }
    public static int solve(int[] A) {
        // O(NLog(N)) time | O(1) space - where N is the length of the array

        Arrays.sort(A);

        int prevDiff = Math.abs(A[0] - A[1]);
        for (int i = 2; i < A.length; i++) {
            int prevNum = A[i-1];
            int currentNum = A[i];

            int currentDiff = Math.abs(prevNum - currentNum);
            if (prevDiff != currentDiff) return 0;
        }
        return 1;
    }
}

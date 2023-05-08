/**
 * Problem Description
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1<= A[i] <=1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the output.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2]
 * Input 2:
 *
 * A = [3, 5, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  21
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All possible non-empty subsets are:
 * [1]     largest-smallest = 1 - 1 = 0
 * [2]     largest-smallest = 2 - 2 = 0
 * [1, 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 * Explanation 2:
 *
 * All possible non-empty subsets are:
 * [3]         largest-smallest = 3 - 3 = 0
 * [5]         largest-smallest = 5 - 5 = 0
 * [10]        largest-smallest = 10 - 10 = 0
 * [3, 5]      largest-smallest = 5 - 3 = 2
 * [3, 10]     largest-smallest = 10 - 3 = 7
 * [5, 10]     largest-smallest = 10 - 5 = 5
 * [3, 5, 10]  largest-smallest = 10 - 3 = 7
 * Sum of the differences = 0 + 0 + 0 + 2 + 7 + 5 + 7 = 21
 * So, the resultant number is 21
 */
package Sorting;

import java.util.Arrays;

public class SumTheDifference {
    public static void main(String[] args) {
        int[] array = {3, 5, 10};
        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] array) {

        //1. Sort the input array
        Arrays.sort(array);

        int ans = 0;

        for (int i = 0; i < array.length; i++) {
            ans += (array[i] * ((1 << i) - (1 << array.length - i - 1)));
        }
        return ans;
    }
}

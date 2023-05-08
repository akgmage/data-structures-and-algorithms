/**
 * Problem Description
 *
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
 *
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * -109 <= A[i], B <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the minimum number of swaps.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  B = 8
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 20
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 *  After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 *  Now, all elements less than or equal to 8 are together.
 * Explanation 2:
 *
 *  A = [5, 17, 100, 11]
 *  After swapping 100 and 11, A => [5, 17, 11, 100].
 *  Now, all elements less than or equal to 20 are together.
 */
package Linear.Arrays.TwoDimensional;

public class MinimumSwaps {
    public static void main(String[] args) {
        int[] array = {1, 12, 10, 3, 14, 10, 5};
        int b = 8;

        int ans = solve(array, b);
        System.out.println(ans);
    }
    public static int solve (int[] array, int b) {
        // O(N) time | O(1) space

        // Sliding Window
        int k = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= b) k++;
        }
        ans = k;

        // calculate for first window
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (array[i] > k) count++;
        }
        ans = Integer.min(ans, count);

        // calculate the remaining windows
        int start = 1, end = k;;

        while (end < array.length) {
            if (array[start - 1] > b) count--;
            if (array[end] > b) count++;

            ans = Integer.min(ans, count);
            start++;
            end++;
        }
        return ans;
    }
}

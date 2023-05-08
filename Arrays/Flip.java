/**
 * Problem Description
 * You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
 *
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 *
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of string <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is a string A.
 *
 *
 *
 * Output Format
 * Return an array of integers denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "010"
 * Input 2:
 *
 * A = "111"
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 1]
 * Output 2:
 *
 * []
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A = "010"
 *
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | "110"
 * [1 2]          | "100"
 * [1 3]          | "101"
 * [2 2]          | "000"
 * [2 3]          | "001"
 *
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 * Explanation 2:
 *
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 *
 */

package Linear.Arrays.OneDimensional;

import java.util.Arrays;

public class Flip {
    public static void main(String[] args) {
        String str = "11000";
        int[] ans = solve(str);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(String str) {
        // O(N) time | O(N) space

        int[] arr = new int[str.length()];
        boolean flag = true;

         // 0 --> +1
        //  1 --> -1
        for (int i = 0; i < arr.length; i++) {
            int curr = Integer.parseInt(String.valueOf(str.charAt(i)));

            if (curr == 0) {
               arr[i] = 1;
               flag = false;
            } else {
                arr[i] = -1;
            }
        }

        if (flag) {
            return new int[] {};
        }
        // Apply kadane

        int currSum = 0;
        int maxSum = 0;
        int leftIdx = 0;
        int rightIdx;
        int[] ans = new int[2];

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                rightIdx = i;
                ans[0] = leftIdx + 1; // it won't change
                ans[1] = rightIdx + 1;
            }
            if (currSum < 0) {
                currSum = 0;
                leftIdx = rightIdx = i + 1;
            }
        }
        return ans;
    }
}

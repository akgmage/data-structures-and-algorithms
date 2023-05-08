package Subarrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements)
 * so that the sum of contiguous elements is maximum.
 * But the sum must not exceed B.
 *
 *
 * Problem Constraints
 * 1 <= A <= 103
 * 1 <= B <= 109
 * 1 <= C[i] <= 106
 *
 *
 * Input Format
 * The first argument is the integer A.
 * The second argument is the integer B.
 * The third argument is the integer array C.
 *
 *
 * Output Format
 * Return a single integer which denotes the maximum sum.
 *
 *
 * Example Input
 * Input 1:
 * A = 5
 * B = 12
 * C = [2, 1, 3, 4, 5]
 * Input 2:
 *
 * A = 3
 * B = 1
 * C = [2, 2, 2]
 *
 *
 * Example Output
 * Output 1:
 * 12
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 * We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
 * Explanation 2:
 *
 * All elements are greater than B, which means we cannot select any subarray.
 * Hence, the answer is 0.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int A = 5;
        int B = 12;
        ArrayList<Integer> C = new ArrayList<>(
                Arrays.asList(2, 1, 3, 4, 5)
        );
        System.out.println(solve(A, B, C));
    }

    public static int solve (int a, int b, ArrayList<Integer> array) {
        int ans = 0;
        for (int i = 0; i < a; i++) {;
            int sum = 0;
            for (int j = i; j < a; j++) {
                int currentNum = array.get(j);
                sum += currentNum;
                if (sum <= b && sum > ans) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}

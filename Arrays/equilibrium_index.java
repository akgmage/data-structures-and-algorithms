/**
 * You are given an array A of integers of size N.
 *
 * Your task is to find the equilibrium index of the given array
 *
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 *
 * NOTE:
 *
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium indexes then return the minimum index.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 *
 *
 * Input Format
 * First arugment is an array A .
 *
 *
 * Output Format
 * Return the equilibrium index of the given array. If no such index is found then return -1.
 *
 *
 * Example Input
 * Input 1:
 * A=[-7, 1, 5, 2, -4, 3, 0]
 * Input 2:
 *
 * A=[1,2,3]
 *
 *
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 *
 * -1
 *
 *
 * Example Explanation
 * Explanation 1:
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * Explanation 1:
 *
 * There is no such index.
 */

package InterviewProblems;

import java.util.stream.IntStream;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] arr) {
        // O(N) | O(1) space
        int len = arr.length;
        int rightSum = IntStream.of(arr).sum();
        int leftSum = 0;
        for (int i = 0; i < len; i++) {
            int currentNum = arr[i];
            rightSum -= currentNum;
            if (leftSum == rightSum) return i;
            leftSum += currentNum;

        }
        // Without prefix sum
        // Using Prefix sum | O(N) time | O(N) space

//        int len = arr.length;
//        int[] prefixSum = new int[len];
//        prefixSum[0] = arr[0];
//        for (int i = 1; i < len; i++)
//                prefixSum[i] = prefixSum[i-1] + arr[i];

        // find equilibrium index
//        if (prefixSum[len - 1] - prefixSum[0] == 0) return 0;
//        for (int i = 1; i < len; i++) {
//            if (prefixSum[i - 1] == prefixSum[ len - 1] - prefixSum[i]) return i;
//        }
        return -1;
    }
}

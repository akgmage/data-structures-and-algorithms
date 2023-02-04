/**
 * Problem Description
 * Given an array B of length A with elements 1 or 0. Find the number of subarrays such that the bitwise OR of all the elements present in the subarray is 1.
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 * Input Format
 * The first argument is a single integer A.
 * The second argument is an integer array B.
 *
 *
 * Output Format
 * Return the number of subarrays with bitwise array 1.
 *
 *
 * Example Input
 * Input 1:
 *  A = 3
 * B = [1, 0, 1]
 * Input 2:
 *  A = 2
 * B = [1, 0]
 *
 *
 * Example Output
 * Output 1:
 * 5
 * Output2:
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 * The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
 * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 * Explanation 2:
 * The subarrays are :- [1], [0], [1, 0]
 * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 */

package BitManipulation;

public class subArrayWithBitwiseOR1 {
    public static void main(String[] args) {
        int[] array = {1, 0, 1};
        int n = 3;
        int ans = solve(array, n);
        System.out.println(ans);
    }
    public static int solve(int[] array, int len) {
        // O(N) time | O(1) space
        int possibleSubarraysWithThisIdx = 0;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            int currentNum = array[i];
            if (currentNum == 1)
                possibleSubarraysWithThisIdx = i + 1;

            ans += possibleSubarraysWithThisIdx;
        }

        return ans;
    }
}

/**
 * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
 *
 *
 *
 * Problem Constraints
 * 1 <= n <= 105
 * -105 <= A[i] <= 105
 *
 *
 * Input Format
 * First argument contains an array A of integers of size N
 *
 *
 * Output Format
 * Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
 *
 *
 *
 * Example Input
 * Input 1:
 * A=[2, 1, 6, 4]
 * Input 2:
 *
 * A=[1, 1, 1]
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 *
 * 3
 *
 *
 * Example Explanation
 * Explanation 1:
 * Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
 * Therefore, the required output is 1.
 * Explanation 2:
 *
 * Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Therefore, the required output is 3.
 */

package InterviewProblems;

public class SpecialIndex {
    public static void main(String[] args) {
        int a[] = {1, 1, 1};
        int ans = solve(a);
        System.out.println(ans);
    }
    public static int solve(int[] arr) {
        // O(N) time | O(1) space

        // Without using extra space
        int len = arr.length;
        if (len == 1) return 1;
        if (len == 2) return 0;

        int totalEvenSum = 0;
        int totalOddSum = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) totalEvenSum += arr[i];
            else totalOddSum += arr[i];
        }

        int prevEvenSum = 0;
        int prevOddSum = 0;
        int currentEvenSum = 0;
        int currentOldSum = 0;
        int temp1;
        int temp2;
        int ans = 0;

        for (int i = 0; i < len; i++) {

            if (i % 2 == 0) currentEvenSum = prevEvenSum + arr[i];
            else currentOldSum = prevOddSum + arr[i];

            temp1 = prevEvenSum + (totalOddSum - currentOldSum);
            temp2 = prevOddSum + (totalEvenSum - currentEvenSum);
            if (temp1 == temp2) ans++;

            prevEvenSum = currentEvenSum;
            prevOddSum = currentOldSum;

        }
        return ans;
    }
    // Using Prefix Sum
//        // even prefix sum | O(N) time
//        int[] evenPrefixSum = new int[len];
//        evenPrefixSum[0] = arr[0];
//
//        for (int i = 1; i < len; i++) {
//            int currentNum = arr[i];
//            evenPrefixSum[i] = i % 2 != 0 ? evenPrefixSum[i-1] : evenPrefixSum[i-1] + currentNum;
//        }
//
//        // odd prefix sum | O(N) time
//        int[] oddPrefixSum = new int[len];
//        oddPrefixSum[0] = 0;
//
//        for (int i = 1; i < len; i++) {
//            int currentNum = arr[i];
//            oddPrefixSum[i] = i % 2 == 0 ? oddPrefixSum[i-1] : oddPrefixSum[i-1] + currentNum;
//        }
//
//        // find special index/s
//        if (oddPrefixSum[len-1] == evenPrefixSum[len-1] - evenPrefixSum[0]) ans++; // 0th Index
//        for (int i = 1; i < len; i++) {
//            int currentEvenSum = evenPrefixSum[i-1] + (oddPrefixSum[len-1] - oddPrefixSum[i]);
//            int currentOddSum = oddPrefixSum[i-1] + (evenPrefixSum[len-1] - evenPrefixSum[i]);
//
//            if (currentEvenSum == currentOddSum) ans++;
//        }

//        return ans;
//    }
}

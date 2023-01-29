/**
 * Given an array of size N, find the subarray of size K with the least average.
 *
 *
 *
 * Problem Constraints
 * 1<=k<=N<=1e5
 * -1e5<=A[i]<=1e5
 *
 *
 * Input Format
 * First argument contains an array A of integers of size N.
 * Second argument contains integer k.
 *
 *
 * Output Format
 * Return the index of the first element of the subarray of size k that has least average.
 * Array indexing starts from 0.
 *
 *
 * Example Input
 * Input 1:
 * A=[3, 7, 90, 20, 10, 50, 40]
 * B=3
 * Input 2:
 *
 * A=[3, 7, 5, 20, -10, 0, 12]
 * B=2
 *
 *
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 * Subarray between indexes 3 and 5
 * The subarray {20, 10, 50} has the least average
 * among all subarrays of size 3.
 * Explanation 2:
 *
 *  Subarray between [4, 5] has minimum average
 */

package SlidingWindow;

public class SubArrayWithLeastAverage {
    public static void main(String[] args) {
//        int[] arr = {3, 7, 90, 20, 10, 50, 40};
        int[] arr = {3, 7, 5, 20, -10, 0, 12};
        int size = 2;
        int ans = solve(arr, size);
        System.out.println(ans);
    }
    public static int solve(int[] arr, int size) {
        // O(N) time | O(1) space
        int sum = 0;
        int ans = 0;
        int len = arr.length;

        // sliding window
        for (int i = 0; i < size; i++)
            sum += arr[i];

        int startIdx = 1;
        int endIdx = size;

        // slide remaining windows
        while (endIdx < len) {
            int currentSum = sum + arr[endIdx] - arr[startIdx - 1];
            if ((currentSum / 3 ) < (sum / 3)) {
                ans = startIdx;
            }
            startIdx++;
            endIdx++;
            sum = currentSum;
        }
        return ans;
    }
}

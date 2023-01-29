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
//        int[] arr = {3, 7, 90, 20, -10, 0, 12};
        int[] arr = {431, 313, 53, 251, 105, 423, 326, 297,
                218, 89, 394, 365, 348, 474, 157, 262, 33, 187,
                67, 79, 495, 199, 175, 228, 27, 305, 496, 331,
                40, 98, 405, 221, 327, 488, 252, 73, 218, 152,
                313, 274, 195, 353, 225, 292, 426, 257, 418,
                364, 344, 349, 181};
        int size = 12;
        int ans = solve(arr, size);
        System.out.println(ans);
    }
    public static int solve(int[] arr, int size) {
        // O(N) time | O(1) space
        int currentSum = 0;
        int idx = 0;
        int len = arr.length;

        // sliding window
        for (int i = 0; i < size; i++)
            currentSum += arr[i];

        int startIdx = 1;
        int endIdx = size;
        int minSum = currentSum;
        // slide remaining windows
        while (endIdx < len) {
            currentSum = currentSum + arr[endIdx] - arr[startIdx - 1];
            if (currentSum < minSum) {
                minSum = currentSum;
                idx = startIdx;
            }
            startIdx++;
            endIdx++;
        }
        return idx;
    }
}

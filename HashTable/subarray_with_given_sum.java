/**
 * Problem Description
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single element "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 * Explanation 2:
 *
 *  No subarray sums up to required number.
 */
package Hashing;

import com.google.common.base.Stopwatch;
import java.util.Arrays;
public class subarrayWithGivenSum {
    public static void main(String[] args) {
        Stopwatch timer = Stopwatch.createStarted();
        int[] array = {-2, 16, -12, 5, 7, -1, 2, 12, 11 };
        int target = 17;
        System.out.println(Arrays.toString(solve(array, target)));
        System.out.println("Runtime " + timer.stop());
    }
    public static int[] solve(int[] array, int targetSum) {
        // O(N) time | O(N) space - N is the length of given array
        int leftIdx = 0, rightIdx = 0, currentSum = array[0], len = array.length;
        while (rightIdx < len && leftIdx <= rightIdx) {
                if (currentSum == targetSum) {
                    return Arrays.copyOfRange(array, leftIdx, rightIdx + 1);
                }
                else if (currentSum < targetSum) {
                    if (++rightIdx < len) currentSum += array[rightIdx];
                }
                else {
                    currentSum -= array[leftIdx++];
                    if (leftIdx > rightIdx && leftIdx < len) {
                        currentSum += array[++rightIdx];
                    }
                }
        }
        // O(N^2) time | O(N) space
//        for (int i = 0; i < array.length; i++) {
//            int sum = 0;
//            for (int j = i; j < array.length; j++) {
//                int num = array[j];
//                sum += num;
//                if (sum == targetSum) {
//                    int[] arr = new int[j - i + 1];
//                    int idx = -1;
//                    for (int k = i; k <= j; k++) {
//                        arr[++idx] = array[k];
//                    }
//                    return arr;
//                }
//            }
//        }
        return new int[] {-1};
    }
}

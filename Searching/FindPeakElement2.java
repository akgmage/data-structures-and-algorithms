/**
 * Problem Description
 * Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
 *
 * For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the peak element.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  100
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  5 is the peak.
 * Explanation 2:
 *
 *  100 is the peak.
 */
package Searching;

public class FindPeakElement2 {
    public static void main(String[] args) {
        int[] array = { 1, 1000000000, 1000000000  };
        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] array) {
        // O(LogN) time | O(1) space
        int n = array.length;
        if (n == 1) {
            return array[0];
        }

        if (array[0] >= array[1]) {
            return array[0];
        }

        if (array[n - 1] >= array[n - 2]) {
            return array[n - 1];
        }

        int left = 1, right = array.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] >= array[mid-1] && array[mid] >= array[mid+1]) {
                return array[mid];
            }

            else if (array[mid-1] < array[mid]) {
                left = mid + 1;
            } else {
                System.out.println("RIGHT" + right);
                right = mid - 1;
            }

        }
        return -1;
    }
}

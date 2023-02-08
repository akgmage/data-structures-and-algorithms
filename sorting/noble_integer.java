/**
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 2*105
 * -108 <= A[i] <= 108
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return 1 if any such integer p is present else, return -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 2, 1, 3]
 * Input 2:
 *
 *  A = [1, 1, 3, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For integer 2, there are 2 greater elements in the array..
 * Explanation 2:
 *
 *  There exist no integer satisfying the required conditions.
 */

package Sorting;

import java.util.Arrays;

public class NobleInteger {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 3};
        int res = solve(arr);
        System.out.println(res);
    }
    public static int solve(int[] array) {
        // O(NLog(N) time | O(1) space
        int len = array.length - 1;
        Arrays.sort(array);
        int count = 0;

        if (array[len] == 0) return 1;
        for (int i = len - 1; i > -1; i--) {
            int currentNum = array[i],
                    previousNum = array[i + 1];
            if (currentNum != previousNum) count = len - i;
            if (count == currentNum) return 1;
        }
        return -1;

        // O(N^2) time | O(1) space
//        for (int previousNum : array) {
//                   int count = 0;
//            for (int currentNum : array) {
//                if (currentNum > previousNum)
//                    count++;
//            }
//            if (count == previousNum) return 1;
//        }
//        return -1;
    }
}

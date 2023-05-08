/**
 * Problem Description
 * Given a sorted array of integers A of size N and an integer B.
 *
 * array A is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 *
 * You are given a target value B to search. If found in the array, return its index otherwise, return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 *
 * 1 <= A[i] <= 109
 *
 * all elements in A are distinct.
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return index of B in array A, otherwise return -1
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Input 2:
 *
 * A : [ 9, 10, 3, 5, 6, 8 ]
 * B : 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Target 4 is found at index 0 in A.
 * Explanation 2:
 *
 * Target 5 is found at index 3 in A.
 */
package Searching;

public class ShiftedBinarySearch {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 3;
        int ans = solve(array, target, 0, array.length - 1);
        System.out.println(ans);
    }
    public static int solve(int[] array, int target, int left, int right) {
        // O(LogN) time | O(1) space

        while (left <= right) {

            int middle = left + (right - left) / 2;
            int potentialMatch = array[middle];
            int leftNum = array[left];
            int rightNum = array[right];

            if (potentialMatch == target) {
                return middle;
            } else if (leftNum <= potentialMatch) { // [61, 71, 72, 73, 0, 1, 21, 33, 45, 45] , target = 33
                if (target < potentialMatch && target >= leftNum) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else { // [45, 61, 71, 72, 73, 0, 1, 21, 33, 45] , target = 33
                if (target > potentialMatch && target <= rightNum) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        } return -1;
    }
}

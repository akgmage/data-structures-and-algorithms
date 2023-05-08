/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Return the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 */
package Searching;

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] array = {4, 7, 9};
        int k = 1;

        int ans = solve(array, k);
        System.out.println(ans);
    }

    public static int solve(int[] array, int k) {

        // O(N) time | O(1) space
        // x = k + "count of elements in arr that are less than x"
//        int curr = k;
////        int i = 0;
////        while (i < array.length && array[i] <= curr) {
////            i++;
////            k++;
////        }
////        return k;

        /**
         *  Binary Search,
         * We need a way to check on how many positive integers are missing before the given array element to use binary search.
         * To do that, let's compare the input array [2, 3, 4, 7, 11] with an array with no missing integers:
         * [1, 2, 3, 4, 5]. The number of missing integers is a simple difference between the corresponding
         * elements of these two arrays:
         *
         * Before 2, there is 2 - 1 = 1 missing integer.
         *
         * Before 3, there is 3 - 2 = 1 missing integer.
         *
         * Before 4, there is 4 - 3 = 1 missing integer.
         *
         * Before 7, there are 7 - 4 = 3 missing integers.
         *
         * Before 11, there are 11 - 5 = 6 missing integers.
         *
         * The number of positive integers which are missing before the arr[idx] is equal to arr[idx] - idx - 1.
         *
         * img Figure 2. The number of missing positive integers before the index idx.
         *
         * Now we have everything to proceed with the classical binary search algorithm:
         *
         * Choose the pivot index in the middle of the array.
         *
         * If the number of positive integers which are missing before arr[pivot] is less than k - continue to search on the right side of the array.
         *
         * Otherwise, continue to search on the left side.
         *
         * Algorithm
         *
         * Initialize search boundaries: left = 0, right = arr.length - 1.
         *
         * While left <= right:
         *
         * Choose the pivot index in the middle: pivot = left + (right - left) / 2. Note that in Java we couldn't use straightforward pivot = (left + right) / 2 to avoid the possible overflow. In Python, the integers are not limited, and we're fine to do that.
         *
         * If the number of positive integers which are missing before is less than k arr[pivot] - pivot - 1 < k - continue to search on the right side of the array: left = pivot + 1.
         *
         * Otherwise, continue to search on the left: right = pivot - 1.
         *
         * At the end of the loop, left = right + 1, and the kth missing number is in-between arr[right] and arr[left]. The number of integers missing before arr[right] is arr[right] - right - 1. Hence, the number to return is arr[right] + k - (arr[right] - right - 1) = k + left
         */
        int left = 0, right = array.length - 1;

        while (right >= left) {
            int pivot = left + (right - left) / 2;
            // If number of positive integers
            // which are missing before arr[pivot]
            // is less than k -->
            // continue to search on the right.
            if (array[pivot] - pivot - 1 < k) {
                left = pivot + 1;
                // Otherwise, go left.
            } else {
                right = pivot - 1;
            }
        }
        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        // arr[right] + k - arr[right] + right + 1 = k + left
        // k + right + 1 = k + left
        // left = right + 1
        return left + k;
    }
}

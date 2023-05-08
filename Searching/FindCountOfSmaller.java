/**
 * Given N distinct elements in an array and array is unsorted
 *. find element at kth-index position in its sorted form.
 */

package Searching;

public class FindCountOfSmaller {
    public static void main(String[] args) {
        int[] array = {11, 11, 24, 18, 3, 5, 27, 34, 9, 40};
        int ans = solve(array, 4);
        System.out.println(ans);
    }
    public static int solve(int[] array, int k) {
        // O(NLog(max-min)) time | O(1) space

        // 1. find min and max
        int left = 0, right = 0, ans = Integer.MAX_VALUE;

        for (int num : array) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        // 2.Apply binary search
        while (left <= right) {
            int mid = (left + right)/ 2;

            int count = smallerElementsCount(array, mid); // get smaller count

            if (count <= k) {
                ans = mid; // update the ans
                left = mid + 1; // look for last occurrence
            } else {
                right = mid - 1;
            }

        }
        return ans;
    }
    public static int smallerElementsCount(int[] array, int mid) {

        int count = 0;

        for (int num : array) {
            if (num < mid) {
                count++;
            }
        }

        return count;
    }
}

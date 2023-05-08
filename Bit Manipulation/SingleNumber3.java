/**
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 * Example 2:
 *
 * Input: nums = [-1,0]
 * Output: [-1,0]
 * Example 3:
 *
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 */
package BitManipulation;

import java.util.Arrays;

public class SingleNumber3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 5};

        int[] ans = solve(arr);

        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] arr) {

        // O(N) time | O(1) space

        //1. Take XOR of all elements
        int val = 0;
        for (int num : arr) {
            val ^= num;
        }

        //2. Get the First position of set-bit in val
        int pos = -1;
        for (int i = 0; i < 32; i++) {
            if (isSetBit(val, i)) {
                pos = i;
                break;
            }
        }

        // 3. Split the array on basis of pos ith bit

        int set = 0, unSet = 0;

        for (int num : arr) {
            if (isSetBit(num, pos)) {
                set ^= num;
            } else {
                unSet ^= num;
            }
        }
        return new int[]{set, unSet};
    }
    public static boolean isSetBit(int a, int i) {
        return (a & (1 << i) )!= 0;
    }
}

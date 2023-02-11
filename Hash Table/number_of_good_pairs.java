/**
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */

package Hashing;

import java.util.HashMap;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1};

        int res = solve(array);
        System.out.println(res);
    }

    public static int solve(int[] array) {
        // O(N) time | O(N) space
        int res = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int num : array) {

            int numCount = hashmap.getOrDefault(num, 0);
            res += numCount;
            hashmap.put(num, numCount);
        }

        // O(N^2) time | O(N) space
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[i] == array[j]) res++;
//            }
//        }

        return res;
    }
}

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};

        int target = 7;
        int ans = solve(nums, target);
        System.out.println(ans);
    }
    public static int solve(int[] nums, int target) {
        // O(N) time | O(1) space

        // Sliding Window

        int leftIdx = 0,
                rightIdx = 0,
                currentSum = 0,
                minIdx = Integer.MAX_VALUE,
                len = nums.length;

        // Variable size sliding window: 2 - pointer
        while (rightIdx < len) {
            int currentNum = nums[rightIdx];
            currentSum += currentNum;

            if (currentSum >= target) { // Check id currentSum >= target
                //Skip all left elements until currentSum < target (To find the smallest window)
                while (currentSum >= target) {
                    currentSum -= nums[leftIdx++];
                }
                int currentWindowSize = rightIdx - leftIdx + 1 + 1; // including leftIdx - 1 idx and update smallest window size.
                minIdx = Math.min(minIdx, currentWindowSize);
            }
            rightIdx++;
        }
        return minIdx == Integer.MAX_VALUE ? 0 : minIdx;

        // O(N^2) time | O(1) space
//        int ans = Integer.MAX_VALUE, len = nums.length;
//        for (int i = 0; i < len; i++) {;
//            int sum = 0;
//            for (int j = i; j < len; j++) {
//                int currentNum = nums[j];
//                sum += currentNum;
//                if (sum >= target) {
//                    ans =  Math.min(ans, j - i + 1);
//                }
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;



    }
}

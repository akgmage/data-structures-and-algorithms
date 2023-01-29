/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 */
package InterviewProblems;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        List<Integer> ans = solve(nums);
        System.out.println(ans);
    }
    public static List<Integer> solve(int[] nums) {
        // O(N) time | O(1) space
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0, len = nums.length;

        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
            else if (count1 == 0) {
                num1 = num;
                count1++;
            } else if (count2 == 0) {
                num2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
        }
        if (count1 > len / 3) ans.add(num1);
        if (count2 > len / 3) ans.add(num2);

        return ans;
    }
}

'''
author:maneesha
Input:
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Time Complexity:O(n^3)
Space Complexity:O(1)

Explanation:
>>The fourSum function takes in a list of integers (nums) and a target value (target).
>>The code sorts the nums list in ascending order.
>>It initializes an empty list res to store the resulting quadruplets.
>>Code uses two nested loops to iterate over combinations of four numbers from the nums list.
>>It avoids duplicates by skipping iterations when the current element is the same as the previous element
  in both the outer and inner loops.
>>Inside  nested loops,  code uses two pointers (lo and hi) to find pairs of elements that sum up to the remaining target value.
>>It compares the sum of the four elements with the target value and takes appropriate actions:

. If  sum equals the target, it adds the quadruplet to the result list res and skips any duplicate elements by moving the pointers accordingly.

. If  sum is less than the target, it increments the lo pointer to try larger values.

. If sum is greater than the target, it decrements the hi pointer to try smaller values.
>>After the nested loops, the function returns the resulting list of quadruplets res.

'''
 from typing import List
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = []

        for i in range(n-3):
            # avoid the duplicates while moving i
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i+1, n-2):
                # avoid the duplicates while moving j
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                lo = j + 1
                hi = n - 1
                while lo < hi:
                    temp = nums[i] + nums[j] + nums[lo] + nums[hi]
                    if temp == target:
                        res += [nums[i], nums[j], nums[lo], nums[hi]],

                        # skip duplicates
                        while lo < hi and nums[lo] == nums[lo + 1]:
                            lo += 1
                        lo += 1
                        while lo < hi and nums[hi] == nums[hi - 1]:
                            hi -= 1
                        hi -= 1
                    elif temp < target:
                        lo += 1
                    else:
                        hi -= 1
        return res
# Test case
nums = [1, 0, -1, 0, -2, 2]
target = 0
solution = Solution()
result = solution.fourSum(nums, target)
print(result)

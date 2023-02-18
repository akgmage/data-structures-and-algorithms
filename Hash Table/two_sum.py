'''
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.
  Sample Input: [2, 1, 3, -1, 11, 5, 4, 0] Target: 10
  Output: [-1 11]
'''
# Brute Force Approach
# Time complexity: O(N^2);
# Space Complexity: O(1);
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []
    
# Two Pointer approach
# Time complexity: O(N);
# Space Complexity: O(N);
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Create map to keep track of what we ahve seen so far
        numToIndex = {}
        for i in range(len(nums)):
            # lets say first element in our array is 3, and target sum is 10
            # then we will look for 7 in our map, if its present then we simply return 7 and 3 
            # if the required value is found then store result
            if target - nums[i] in numToIndex:
                return [numToIndex[target - nums[i]], i]
            # keep track of what value in array we have seen so far
            numToIndex[nums[i]] = i
        return []
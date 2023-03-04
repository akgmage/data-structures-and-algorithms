'''
    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.

    

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

    Example 3:
    Input: nums = [1], target = 0
    Output: -1

'''
class Solution:
    def binarySearch(nums,low,high,target):
        if(low>high):
            return -1
        mid = (low+high)//2
        if(nums[mid]<target):
            return Solution.binarySearch(nums,mid+1,high,target)
        elif(nums[mid]>target):
            return Solution.binarySearch(nums,low,mid-1,target)
        else:
            return mid
    
    def search(self, nums: List[int], target: int) -> int:
        #Finding the index where the array was rotated and binary searching the first and second parts for the target value.
        rotated_index = -1
        for i in range(len(nums)-1):
            if(nums[i]>nums[i+1]):
                rotated_index = i
                break
            
        return Solution.binarySearch(nums,0,rotated_index,target) & Solution.binarySearch(nums,rotated_index+1,len(nums)-1,target)
        
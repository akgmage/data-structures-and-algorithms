# first positive missing in python
'''
To find the smallest missing positive integer in an unsorted integer array nums with the given time and space constraints, 
you can utilize the concept of in-place swapping and indexing.

Explanation:-

    -> Iterate through the array nums and ignore any non-positive numbers (i.e., negative numbers and zero). 
    Also, ignore numbers greater than the length of the array since they cannot be the smallest missing positive integer.

    -> For each positive number num encountered, find its correct index targetIndex as num - 1.

    -> Check if the number at index targetIndex is already in its correct place or not. If it is not, 
    swap the numbers at indices i and targetIndex to move num to its correct place. Continue this swapping 
    process until the number at index i is either non-positive or already in its correct place.

    -> After completing the iteration, perform a second pass through the array. The first index i that does not 
    contain the value i + 1 represents the smallest missing positive integer. Return i + 1.
'''

# Time complexity O(n) and Space complexity O(1).

'''Examples-

Example 1:
Input: nums = [1, 2, 0]
Output: 3
Explanation: The smallest missing positive integer in the array is 3.

Example 2:
Input: nums = [3, 4, -1, 1]
Output: 2
Explanation: The smallest missing positive integer in the array is 2.

Example 3:
Input: nums = [7, 8, 9, 11, 12]
Output: 1
Explanation: The smallest missing positive integer in the array is 1.

'''

def firstMissingPositive(nums):
    n = len(nums)

    # Step 1: Move positive numbers to their correct positions
    for i in range(n):
        while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
            nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]

    # Step 2: Find the first missing positive
    for i in range(n):
        if nums[i] != i + 1:
            return i + 1

    # If all positive integers are present, return n + 1
    return n + 1


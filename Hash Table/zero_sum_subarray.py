'''
	You're given a list of integers nums. Write a function that returns a boolean representing
	whether there exists a zero-sum subarray of nums

	Sample Input :  = [-5, -5, 2, 3, -2]
	Output : True
	The subarray [-5, 2, 3] has a sum of 0

    Approach:
    Time and Space complexity : O(n) time | O(n) space - where n is the length of nums
    This implementation uses an unordered map to keep track of the prefix sum of the input array nums. 
    We initialize the map with a key-value pair of 0 and -1, since a prefix sum of 0 indicates that the 
    subarray from index 0 to -1 (i.e., an empty subarray) has a sum of 0. We then iterate through the 
    input array nums, adding each element to the running sum sum and checking if the current sum is 
    already in the map. If it is, then we've found a subarray whose sum is 0, so we add the starting and 
    ending indices of the subarray to the result vector and break out of the loop.
    If we reach the end of the loop without finding a zero sum subarray, then we return an empty vector.
    Note that this implementation assumes that there is only one zero sum subarray in the input array. 
    If there could be multiple zero sum subarrays, then we would need to modify the implementation to 
    return all of them.
'''
def zero_sum_subarray(nums):
    # Initialize a set to keep track of previously encountered prefix sums.
    prefix_sums = set()
    prefix_sum = 0
    
    # Loop through each number in the array.
    for num in nums:
        # Add the current number to the running prefix sum.
        prefix_sum += num
        
        # If the current prefix sum is in the set of previous prefix sums,
        # then we have found a subarray whose sum is zero.
        if prefix_sum in prefix_sums:
            return True
        
        # Add the current prefix sum to the set of previous prefix sums.
        prefix_sums.add(prefix_sum)
    
    # If no subarray whose sum is zero was found, return False.
    return False

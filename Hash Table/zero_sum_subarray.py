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

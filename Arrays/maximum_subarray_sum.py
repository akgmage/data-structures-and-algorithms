'''
    The max_subarray_sum function takes an array arr as input and returns the maximum sum of a 
    contiguous subarray in the given array.

    The function initializes two variables curr_sum and max_sum to the first element of the array. 
    It then loops through the rest of the array starting from the second element.

    Inside the loop, the function updates the curr_sum variable by adding the current element to it. 
    If the current sum is less than the current element, it means that starting a new subarray at this 
    point will result in a greater sum, so the function starts a new subarray with the current element. 
    The max_sum variable is then updated with the maximum value of max_sum and curr_sum.

    Once the loop is finished, the function returns the max_sum variable as the maximum sum of a 
    contiguous subarray in the given array.

    The time complexity of this algorithm is O(n), where n is the length of the input array, 
    since we only loop through the array once. 
    
    The space complexity is O(1), since we only use 
    a constant amount of extra space to store the current sum and maximum sum variables.
    
    Example Input: arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    Example Output: 6
    Explanation: The maximum subarray sum is [4, -1, 2, 1] which adds up to 6.
    
'''
def max_subarray_sum(arr):
    """
    Returns the maximum sum of a contiguous subarray in the given array.

    Parameters:
    arr (list): A list of integers.

    Returns:
    int: The maximum sum of a contiguous subarray.

    """

    # Initialize variables to keep track of the current sum and maximum sum
    curr_sum = max_sum = arr[0]

    # Loop through the array starting from the second element
    for i in range(1, len(arr)):

        # Update the current sum by adding the current element
        curr_sum += arr[i]

        # If the current sum is less than the current element, start a new subarray
        curr_sum = max(curr_sum, arr[i])

        # Update the maximum sum if the current sum is greater
        max_sum = max(max_sum, curr_sum)

    # Return the maximum sum
    return max_sum

arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
print(max_subarray_sum(arr))
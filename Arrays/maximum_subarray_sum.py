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

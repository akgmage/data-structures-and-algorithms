from typing import List
import math

def smallest_difference(array1: List[int], array2: List[int]) -> List[int]:
    """
    Finds the pair of integers, one from each of the two given arrays, with the smallest difference between them.

    Args:
        array1: A list of integers.
        array2: A list of integers.

    Returns:
        A list of two integers, where the first integer is from array1 and the second is from array2, and the absolute
        difference between them is the smallest among all such pairs.

    Example:
        >>> smallest_difference([1, 3, 15, 11, 2], [23, 127, 235, 19, 8])
        [11, 8]
    """
    current = math.inf
    smallest = math.inf
    result = []

    # Sort both input arrays in ascending order
    array1.sort()
    array2.sort()

    # Initialize two pointers, one for each array
    idx1, idx2 = 0, 0

    # Loop through both arrays while the pointers are still within bounds
    while idx1 < len(array1) and idx2 < len(array2):
        first, second = array1[idx1], array2[idx2]

        # Calculate the absolute difference between the two current numbers
        current = abs(first - second)

        # Update the smallest difference and the result if the current difference is smaller
        if current < smallest:
            smallest = current
            result = [first, second]

        # If the first number is smaller than the second number, increment the pointer
        # for the first array, otherwise increment the pointer for the second array.
        if first < second:
            idx1 += 1
        else:
            idx2 += 1

    # Return the result
    return result

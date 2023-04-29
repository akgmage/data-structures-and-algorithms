'''
    Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array)
	whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number from
	the first array in the first position.

	Note that the absolute difference of two integers is the distance between them on the real number line.
	For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.

  	You can assume that there will only be one pair of numbers with the smallest difference.

	Sample Input Array1 = [-1, 5, 10, 20, 28, 3]
	Sample Input Array2 = [26, 134, 135, 15, 17]

	Sample Output = [28, 26]
    
    The smallest_difference function takes two arrays of integers as input and returns a list of two integers, where the first integer 
    is from the first array and the second is from the second array, and the absolute difference between them is the smallest among 
    all such pairs. It achieves this by sorting the two arrays and then iterating through them in parallel, keeping track of the 
    current smallest difference and the pair of integers that produced it. The function returns the pair with the smallest difference.

    O(nlog(n) + mlog(m)) time | O(1) space - where n is the length of the first input array and m is the length of the second input array
'''
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

def main():
    array1 = [1, 3, 15, 11, 2]
    array2 = [23, 127, 235, 19, 8]
    result = smallest_difference(array1, array2)
    print("Array 1:", array1)
    print("Array 2:", array2)
    print("Smallest Difference Pair:", result)

if __name__ == "__main__":
    main()
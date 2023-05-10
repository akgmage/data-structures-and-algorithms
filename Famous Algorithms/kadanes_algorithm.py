"""
What is Kadane's Algorithm?
Kadane's Algorithm is a way to find the maximum subarray sum in an array with a runtime of O(n).
It is a dynamic programming algorithm that uses the fact that the maximum subarray sum ending at index i is either the value at index i or the maximum subarray sum ending at index i-1 plus the value at index i.

Note: The subarray must be contiguous, all the values in the subarray must be next to each other in the original array.

How does it work?
The algorithm works by iterating through the array and keeping track of the maximum subarray sum seen so far and the maximum subarray sum ending at the current index.
The maximum subarray sum ending at the current index is either the value at the current index or the maximum subarray sum ending at the previous index plus the value at the current index.

Lets take the example: {-2, -3, 4, -1, -2, 1, 5, -3}
    max_so_far = INT_MIN
    max_ending_here = 0

    for i=0,  a[0] =  -2
    max_ending_here = max_ending_here + (-2)
    Set max_ending_here = 0 because max_ending_here < 0
    and set max_so_far = -2

    for i=1,  a[1] =  -3
    max_ending_here = max_ending_here + (-3)
    Since max_ending_here = -3 and max_so_far = -2, max_so_far will remain -2
    Set max_ending_here = 0 because max_ending_here < 0

    for i=2,  a[2] =  4
    max_ending_here = max_ending_here + (4)
    max_ending_here = 4
    max_so_far is updated to 4 because max_ending_here greater 
    than max_so_far which was -2 till now

    for i=3,  a[3] =  -1
    max_ending_here = max_ending_here + (-1)
    max_ending_here = 3

    for i=4,  a[4] =  -2
    max_ending_here = max_ending_here + (-2)
    max_ending_here = 1

    for i=5,  a[5] =  1
    max_ending_here = max_ending_here + (1)
    max_ending_here = 2

    for i=6,  a[6] =  5
    max_ending_here = max_ending_here + (5)
    max_ending_here = 7
    max_so_far is updated to 7 because max_ending_here is 
    greater than max_so_far

    for i=7,  a[7] =  -3
    max_ending_here = max_ending_here + (-3)
    max_ending_here = 4
    
    Time Complexity: O(n)
    Space Complexity: O(1)
"""

from sys import maxint

# maxint is a constant that holds the maximum possible value for an integer in Python.


def maxSubArraySum(a, size):
    # we take the max_so_far to be the smallest possible integer value
    max_so_far = -maxint - 1

    # initialize max_ending_here to 0
    max_ending_here = 0

    for i in range(0, size):
        max_ending_here = max_ending_here + a[i]
        if max_so_far < max_ending_here:
            max_so_far = max_ending_here

        # if max_ending_here is negative, we set it to 0
        if max_ending_here < 0:
            max_ending_here = 0

    return max_so_far


# Driver function to check the above function


a = [-2, -3, 4, -1, -2, 1, 5, -3]

print("Maximum contiguous sum is", maxSubArraySum(a, len(a)))

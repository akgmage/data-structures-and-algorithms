# Approach Explanation:
# The code implements the Dutch National Flag problem, which is a sorting problem where we need to sort an array consisting of 0s, 1s, and 2s in ascending order. The approach used is called the "Three Pointers" approach.

# We initialize three pointers, low, mid, and high, which represent the boundaries of three sections in the array:

# All elements before low are 0s (left section).
# All elements between low and mid are 1s (middle section).
# All elements after high are 2s (right section).
# We iterate through the array using the mid pointer:

# If the element at mid is 0, we swap it with the element at low and increment both low and mid pointers.
# If the element at mid is 1, we increment the mid pointer.
# If the element at mid is 2, we swap it with the element at high and decrement the high pointer.
# By doing this, we move all the 0s to the left section, 1s to the middle section, and 2s to the right section, effectively sorting the array.

# Time Complexity: O(n), where n is the length of the input array.
# Space Complexity: O(1) (constant space), as we are sorting the array in-place

# Sample Input:
# arr = [2, 0, 1, 2, 1, 0]

# Sample Output:
# Input Array: [2, 0, 1, 2, 1, 0]
# Output Array: [0, 0, 1, 1, 2, 2]


def dutch_national_flag_problem(arr):
    # Initialize variables for the three pointers
    low = 0
    mid = 0
    high = len(arr) - 1

    # Loop through the array until mid and high pointers meet
    while mid <= high:
        if arr[mid] == 0:
            # Swap the element at mid with the element at low
            arr[mid], arr[low] = arr[low], arr[mid]
            # Move the low and mid pointers to the right
            low += 1
            mid += 1
        elif arr[mid] == 1:
            # Increment the mid pointer
            mid += 1
        else:
            # Swap the element at mid with the element at high
            arr[mid], arr[high] = arr[high], arr[mid]
            # Move the high pointer to the left
            high -= 1

    return arr


# Test the function
arr = [2, 0, 1, 2, 1, 0]
result = dutch_national_flag_problem(arr)
print("Input Array:", arr)
print("Output Array:", result)
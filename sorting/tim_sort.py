"""
Implementation of Tim Sort in Python 

Tim Sort is based on Insertion and Merge Sort. 

The steps of the algorithm are: 

1. Divide the input array into blocks called runs
2. The size of a run can either be 32 or 64
3. Sort the elements of every run with insertion sort
4. Merge the sorted runs using with merge sort
5. After every iteration double the size of the merged array 

"""

MINIMUM = 32

# Returns the minrun = the minimum length of a run 
def find_minrun(n):

    r = 0
    while n >= MINIMUM:
        r |= n & 1
        n >>= 1

    return n + r
 
 
# Sorts an array from left to right index (Insertion Sort)
def insertion_sort(array, left, right):
    for i in range(left + 1, right + 1):
        j = i
        while j > left and array[j] < array[j - 1]:
            array[j], array[j - 1] = array[j - 1], array[j]
            j -= 1
 
 
# Merges the sorted runs
def merge(array, l, m, r):
 
    # original array is broken in two parts: left - right 
    
    array_len1 = m - l + 1
    array_len2 = r - m

    left = []
    right = []

    for i in range(0, array_len1):
        left.append(array[l + i])

    for i in range(0, array_len2):
        right.append(array[m + 1 + i])
 
    i = 0
    j = 0
    k = l
 
    # merge the two arrays in a larger sub array
    while i < array_len1 and j < array_len2:
        if left[i] <= right[j]:
            array[k] = left[i]
            i += 1
 
        else:
            array[k] = right[j]
            j += 1
 
        k += 1
 
    # Copy remaining elements of the left part, if any
    while i < array_len1:
        array[k] = left[i]
        k += 1
        i += 1
 
    # Copy remaining element of the right part, if any
    while j <array_len2:
        array[k] = right[j]
        k += 1
        j += 1
 
 
# Timsort algorithm
def tim_sort(array):
    n = len(array)
    minrun = find_minrun(n)
 
    # Sort individual subarrays of size RUN
    for start in range(0, n, minrun):
        end = min(start + minrun - 1, n - 1)
        insertion_sort(array, start, end)
 
    # Start merging from size RUN (or 32), then 128, 256, ... etc.
    size = minrun
    while size < n:
 
        # Choose the starting point of the left sub array
        # Merge array[left ... left + size - 1]
        # and array[left+size ... left + 2 * size - 1]
        # After every merge, the size is increased by 2 * size.
        for left in range(0, n, 2 * size):
 
            # Find end point of the left sub array.
            # The mid + 1 is the starting point of the right sub array.
            mid = min(n - 1, left + size - 1)
            right = min((left + 2 * size - 1), (n - 1))
 
            # Merge array[left ... mid] and array[mid + 1 ... right]
            if mid < right:
                merge(array, left, mid, right)
 
        size = 2 * size
 
 

if __name__ == "__main__":
 
    array = [-1, 5, 0, -3, 11, 9, -2, 7, -15, 22, 4, -10]
 
    print("Array to sort:")
    print(array)
 
    # Function Call
    tim_sort(array)
 
    print("The sorted array using TimSort is")
    print(array)
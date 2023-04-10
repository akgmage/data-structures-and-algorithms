'''
    The basic idea of quicksort is to divide the input array into two partitions, with one partition 
    consisting of all elements smaller than a chosen pivot element, and the other partition consisting 
    of all elements larger than the pivot. This process is then recursively applied to the smaller
    partitions until the entire array is sorted.

    In this implementation, we first handle the base case where the array has 0 or 1 element, 
    which is already sorted. Then, we choose the pivot element as the middle element of the array, 
    and partition the array into two subarrays based on whether each element is less than or greater 
    than the pivot. We then recursively sort the left and right subarrays using the same quicksort 
    function, and concatenate the results together along with the pivot element to get the final sorted array.
'''
''' Time and Space complexity
    The time complexity of quicksort is O(n log n) on average and O(n^2) in the worst case. 
    The space complexity of quicksort is O(log n) on average and O(n) in the worst case. 
    The worst case occurs when the partition process divides the input array into two subarrays of unequal size.
'''
def quicksort(arr):
    """
    Sorts an array using quicksort algorithm.

    Args:
    arr: A list of comparable elements to be sorted.

    Returns:
    The sorted list.
    """
    # Base case: an empty or single-element list is already sorted.
    if len(arr) < 2:
        return arr

    # Choose a pivot element and partition the list around it.
    pivot_index = len(arr) // 2
    pivot = arr[pivot_index]
    left, right = [], []
    for i in range(len(arr)):
        if i != pivot_index:
            if arr[i] < pivot:
                left.append(arr[i])
            else:
                right.append(arr[i])

    # Recursively sort the left and right partitions.
    return quicksort(left) + [pivot] + quicksort(right)

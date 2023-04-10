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

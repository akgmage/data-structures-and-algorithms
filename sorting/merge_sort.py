"""
Merge Sort Algorithm in Python

Merge Sort is an efficient, general-purpose, and comparison-based sorting algorithm.
It is a divide-and-conquer algorithm that works by dividing the list into smaller sublists,
sorting them recursively, and then merging them into a single sorted list.

Source: https://en.wikipedia.org/wiki/Merge_sort
"""

from typing import List

def merge_sort(arr: List[int], start: int, end: int) -> None:
    """Recursively sorts arr[start..end] using merge sort."""
    if start < end:
        mid = (start + end) // 2
        merge_sort(arr, start, mid)
        merge_sort(arr, mid + 1, end)
        merge(arr, start, mid, end)

def merge(arr: List[int], start: int, mid: int, end: int) -> None:
    """Merges two sorted subarrays arr[start..mid] and arr[mid+1..end] into a single sorted subarray."""
    n_left = mid - start + 1
    n_right = end - mid

    # Create temporary arrays
    left = arr[start:mid+1]
    right = arr[mid+1:end+1]

    # Merge temp arrays back into arr
    i = j = 0
    k = start
    while i < n_left and j < n_right:
        if left[i] < right[j]:
            arr[k] = left[i]
            i += 1
        else:
            arr[k] = right[j]
            j += 1
        k += 1

    # Copy remaining elements, if any
    while i < n_left:
        arr[k] = left[i]
        i += 1
        k += 1
    while j < n_right:
        arr[k] = right[j]
        j += 1
        k += 1

def main() -> None:
    """Run example test cases for merge sort."""
    test_cases = [
        [3, 2, -1, 9, 0, 7, -3, -4, 10, 9],
        [],
        [1],
        [5, 5, 5],
        [10, -10, 0, 5, -5]
    ]

    for idx, lst in enumerate(test_cases, start=1):
        if lst:  # Avoid calling merge_sort on empty list with invalid indices
            merge_sort(lst, 0, len(lst) - 1)
        print(f"Test case {idx}: {lst}")

if __name__ == "__main__":
    main()

"""
Implementation of insertion sort in go.
Insertion sort is a simple sorting algorith that iterates through
the list starting at the second element. We compare each element
to the preceding elements, slide over the preceding larger (or smaller)
elements, and insert the original element into the empty position.

Time Complexity worst-case and average complexity O(n^{2})

Insertion sort is inefficient for large arrays. However it is fast for
small arrays and typically more efficient than bubble sort and selection
sort due to not making as many comparisons on average.

Source: https://en.wikipedia.org/wiki/Insertion_sort

Sample input: [0, 2, 1,-1, 10, 3, 4]
Output: [-1 0 1 2 3 4 10]
"""

def insertion_sort(arr):
    """
        Sorts an array in ascending order using the insertion sort algorithm.
        
        @param arr: list of integers to be sorted
        @return: sorted list of integers
    """
    # iterate through every element of the array
    for i in range(1, len(arr)):
        # store the current element and its index
        current = arr[i]
        j = i - 1
        
        # move all elements greater than the current element to the right
        while j >= 0 and arr[j] > current:
            arr[j + 1] = arr[j]
            j -= 1
        
        # insert the current element in its correct position
        arr[j + 1] = current
    
    # return the sorted array
    return arr

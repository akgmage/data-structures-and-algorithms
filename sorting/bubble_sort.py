# Implementation of Bubble sort.
# Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
# that repeatedly steps through the input list element by element,
# comparing the current element with the one after it, swapping their values if needed.
#  These passes through the list are repeated until no swaps had to be performed during a pass,
# meaning that the list has become fully sorted. (Source wiki) https://en.wikipedia.org/wiki/Bubble_sort

# Time Complexity worst-case and average complexity O(n^{2})
# Bubble sort is O(n) on a list that is already sorted i.e. Best case

# Sample Input : [2, 1, 9, 3, 5, 4, 0]
# Output : [0 1 2 3 4 5 9]

def bubbleSort(arr):
    n = len(arr)
    # Traverse through all array elements
    for i in range(n - 1):
        # Last i elements are already sorted
        for j in range(0, n - i - 1):
            # Swap adjacent elements if they are in the wrong order
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

arr = [64, 25, 12, 22, 11]
bubbleSort(arr)
print("Sorted array:", arr)

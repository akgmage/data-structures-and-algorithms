"""
    Intuition:
        If you have to guess a magic number from 1-100, the best first attempt would be to guess '50'
        or in other words, the middle. If I tell you that the magic number is higher,
        you now don't need to consider all numbers 1-50,
        and if it is lower you wouldn't need to consider numbers 50-100!!

        In Binary Search, we follow the same idea,
        1. Compar the target with the middle element.
        2. If the target is higher, then the target can only lie in the right (greater) subarray. We re-calculate mid and repeat step 1.
        3. If the target is lower, the target  can only lie in the left (lower) half. We re-calculate mid and repeat step 1.

        Binary search can only operate on a sorted array.
        Further reading: https://en.wikipedia.org/wiki/Binary_search_algorithm
"""




import math

def binary_search(lst, target):
    if not lst:
        return -1
    lo = 0
    hi = len(lst)-1

    while lo <= hi:
        mid = math.floor(lo + (hi - lo) / 2)  # Find mid. math.floor is used to round floats down.
        if lst[mid] < target:  # Element in mid is lower than target.
            lo = mid + 1  # Our low (start) becomes the element after mid.
        elif lst[mid] > target:  # Element in mid is higher than target.
            hi = mid - 1  # Our high (end) becomes the element before mid.
        elif lst[mid] == target:
            print(f"Found {target} at index {mid}.")
            return mid
    print(f"Target {target} not found.")
    return -1


arr = [10, 20, 30, 50, 60, 80, 110, 130, 140, 170]
binary_search(arr, 80)
binary_search(arr, 10)
binary_search(arr, 110)
binary_search(arr, 20)
binary_search(arr, 140)
binary_search(arr, 2)
binary_search(arr, 1)

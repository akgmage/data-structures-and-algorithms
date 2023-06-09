'''
	An array is said to be monotonic in nature if it is either continuously increasing or continuously decreasing.
	Mathematically, An array A is continuously increasing if for all i <= j, A[i] <= A[j].

	The IsMonotonic function takes an array of integers and returns a boolean value indicating whether the array
	is monotonic or not. A monotonic array is one in which the elements are either non-increasing or non-decreasing.

	The function works by initializing two boolean variables, isNonDecreasing and isNonIncreasing, to true.
	It then iterates over the array from the first element to the second-to-last element, comparing each element to the next one.

	If the current element is less than the next element, it sets isNonDecreasing to false, indicating that the
	array is not non-decreasing. If the current element is greater than the next element, it sets isNonIncreasing to false,
	indicating that the array is not non-increasing.

	At the end of the loop, the function returns true if either isNonDecreasing or isNonIncreasing is still true,
	indicating that the array is monotonic. Otherwise, it returns false.

	O(n) time | O(1) space - where n is the length of the array
'''
def is_monotonic(array):
    is_non_decreasing = True  # Assume the array is non-decreasing until we find a decreasing element
    is_non_increasing = True  # Assume the array is non-increasing until we find an increasing element
    for i in range(1, len(array)):
        if array[i] < array[i - 1]:
            # If the current element is less than the previous element, the array is not non-decreasing
            is_non_decreasing = False
        if array[i] > array[i - 1]:
            # If the current element is greater than the previous element, the array is not non-increasing
            is_non_increasing = False
    # Return true if the array is either non-decreasing or non-increasing
    return is_non_decreasing or is_non_increasing

arr = [1, 2, 3, 4, 5]
arr2 = [5, 4, 3, 2, 1]
print(is_monotonic(arr))
print(is_monotonic(arr2))

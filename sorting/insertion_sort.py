"""
	In this implementation, we define a function called InsertionSort that takes an array of integers and sorts
	it in ascending order using the Insertion Sort algorithm.

	The algorithm works by iterating over the array from the second element to the end.

	For each element, it compares it with the previous elements in the array and inserts it in the correct position.

	The current variable holds the value of the current element being compared.

	The j variable holds the index of the previous element being compared.

	The loop compares the current value with the previous values in the array and shifts the values to the right to make space for the current value.

	Once the correct position is found, the current value is inserted into the array.

	Finally, the sorted array is returned. In the main function, we define an array of integers, sort it using the InsertionSort function, and print the sorted array.

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

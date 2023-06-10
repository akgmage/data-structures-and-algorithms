'''
    Write a function that takes in an array of integers and returns the length of the longest peak in the array.
	A peak is defined as adjacent integers in the array that are strictly increasing until they reach a tip (the highest value in the peak),
	at which point they become strictly decreasing. At least three integers are required to form a peak.

	The code defines a function named LongestPeak that takes an array of integers as an argument and returns an integer
	representing the length of the longest "peak" in the array.

	A "peak" is defined as a sequence of integers in the array that begins with an increasing sequence of integers,
	reaches a maximum value (the "peak"), and ends with a decreasing sequence of integers.

	The function first initializes a variable longestPeak to 0, which will be used to store the length of the longest
	peak found so far. It then initializes a variable i to 1, which will be used to iterate over the elements of the array.

	The function then enters a loop that continues until i is less than len(array) - 1. Inside the loop, the function checks
	whether the current element at i is a peak, by comparing it to its neighboring elements. If it is not a peak, the loop continues by incrementing i.

	If the current element at i is a peak, the function searches to the left and right of the peak to find the beginning
	and end of the peak. It does this by iterating left and right from the peak until it finds a decreasing sequence of
	integers, using the variables leftIndex and rightIndex.

	Once the function has found the beginning and end of the peak, it calculates the length of the peak using the formula
	rightIndex - leftIndex - 1. If the length of the current peak is greater than the current longest peak, it updates
	longestPeak to the length of the current peak.

	Finally, the function updates the value of i to be the end of the peak (rightIndex), so that the loop will skip over
	the entire peak and continue iterating from the end of the peak.

	The function returns the value of longestPeak once it has finished iterating over the array.

	The time complexity of the LongestPeak function is O(n), where n is the length of the input array, because it iterates through the array only once.

	The space complexity of the function is O(1), because it uses a constant amount of extra space, regardless of the size of the input array.

'''

def longest_peak(array):
    longest_peak = 0
    i = 1

    while i < len(array) - 1:
        # Check if i is a peak (i.e., it's greater than its neighbors)
        is_peak = array[i - 1] < array[i] > array[i + 1]

        if not is_peak:
            # If i is not a peak, move to the next element
            i += 1
            continue

        # Search left of i to find the beginning of the peak
        left_index = i - 2
        while left_index >= 0 and array[left_index] < array[left_index + 1]:
            left_index -= 1

        # Search right of i to find the end of the peak
        right_index = i + 2
        while right_index < len(array) and array[right_index] < array[right_index - 1]:
            right_index += 1

        # Calculate the length of the current peak
        current_peak = right_index - left_index - 1

        # Update longest_peak if current_peak is longer
        if current_peak > longest_peak:
            longest_peak = current_peak

        # Move i to the end of the current peak
        i = right_index

    return longest_peak

# Test the function
array = [1, 3, 2, 1, 4, 7, 3, 2, 1]
result = longest_peak(array)
print(result)  # Output: 6



arr=[1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]


def longestPeak(arr: list) -> int:
        ans = 0
        # iterate through the array from index 1 to len(arr) - 1
        for indx in range(1, len(arr) - 1):
            # check if the current element is a peak
            if arr[indx - 1] < arr[indx] > arr[indx + 1]:
                # if it is a peak, then find the length of the peak
                uphill_start = downhill_ends = indx
                # go to the uphill start
                while uphill_start > 0 and arr[uphill_start] > arr[uphill_start - 1]:
                    uphill_start -= 1
                    # go to the downhill end
                while downhill_ends + 1 < len(arr) and arr[downhill_ends] > arr[downhill_ends + 1]:
                    downhill_ends += 1
                    # update the ans 
                ans = max(ans, (downhill_ends - uphill_start + 1))
        return ans


print(longestPeak(arr))
# output: 6
/*

The Dutch National Flag algorithm is used to sort an array containing elements with values of 0, 1, and 2. The goal is to rearrange the elements in-place so that all the 0s are grouped at the beginning, followed by all the 1s, and finally all the 2s.

The algorithm uses three pointers: low, mid, and high. The low pointer represents the boundary of the 0s section, the mid pointer scans the array, and the high pointer represents the boundary of the 2s section.

The algorithm iterates through the array and performs the following operations:

    1. If the element at the mid pointer is 0, it is swapped with the element at the low pointer, and both pointers are incremented.
    2. If the element at the mid pointer is 1, it is already in the correct section, so the mid pointer is simply incremented.
    3. If the element at the mid pointer is 2, it is swapped with the element at the high pointer, and the high pointer is decremented.

The iteration continues until the mid pointer crosses the high pointer, indicating that all elements have been processed.

After the algorithm finishes, the array will be sorted according to the Dutch National Flag problem requirements, with all 0s at the beginning, followed by 1s, and finally 2s. The sorting is done in-place, meaning it does not require any additional space.

The time complexity of the Dutch National Flag algorithm is O(n), where n is the length of the array, as we only need to iterate through the array once. The space complexity is O(1) since no extra space is used apart from the input array.

Consider an array: [1, 2, 0, 2, 1, 0].

The algorithm uses three pointers: low, mid, and high. Initially, low = 0, mid = 0, and high = 5.

    Iterate while mid <= high:
        If the element at mid is 0, swap it with the element at low, increment both low and mid.
        If the element at mid is 1, increment mid.
        If the element at mid is 2, swap it with the element at high, decrement high.

After applying the algorithm, the sorted array will be: [0, 0, 1, 1, 2, 2].

In this example, the algorithm moves all the 0s to the beginning, followed by the 1s, and finally the 2s, achieving the desired sorting according to the Dutch National Flag problem requirements.
*/
package main

import "fmt"

func DutchNationalFlag(array []int64) []int64 {

	// Initialize Low, Mid, and High pointers
	var (
		Low  = 0
		Mid  = 0
		High = len(array) - 1
	)

	// Iterate while Mid pointer is less than or equal to High pointer
	for Mid <= High {

		// Check the value at Mid pointer
		switch array[Mid] {

		// Case 0: Value is 0, so swap it with the value at Low pointer
		// Increment both Low and Mid pointers to move forward
		case 0:
			array[Low], array[Mid] = array[Mid], array[Low]
			Low++
			Mid++

		// Case 1: Value is 1, no swapping needed
		// Increment Mid pointer to move forward
		case 1:
			Mid++

		// Case 2: Value is 2, so swap it with the value at High pointer
		// Decrement High pointer to move backward
		case 2:
			array[Mid], array[High] = array[High], array[Mid]
			High--
		}
	}

	// Return the sorted array
	return array
}


package main

// NextGreaterElement finds the next greater element for each element in the input array.
func NextGreaterElement(array []int) []int {
	// Create a result slice to store the next greater elements.
	result := make([]int, 0)
	// Initialize the result slice with -1 values indicating no greater elements initially.
	for range array {
		result = append(result, -1)
	}

	// Create a stack to keep track of indices of elements from the input array.
	stack := make([]int, 0)

	// Perform two passes over the input array, considering elements in a circular manner.
	for idx := 0; idx < 2*len(array); idx++ {
		// Calculate the circular index by using the modulo operator.
		circularIdx := idx % len(array)

		// Check if the current element is greater than the element at the top of the stack.
		for len(stack) > 0 && array[circularIdx] > array[stack[len(stack)-1]] {
			// Retrieve the top index from the stack.
			top := stack[len(stack)-1]
			// Update the corresponding element in the result slice with the current element.
			result[top] = array[circularIdx]
			// Remove the top index from the stack.
			stack = stack[:len(stack)-1]
		}

		// Push the current circular index onto the stack.
		stack = append(stack, circularIdx)
	}

	// Return the result slice containing the next greater elements.
	return result
}

/*

  	Write a function that takes in an array of integers and returns a new array containing, at each index, the next
	element in the input array that's greater than the element at that index in the input array.

	Sample Input:[2, 5, -3, -4, 6, 7, 2]
	Output: [5, 6, 6, 6, 7, -1, 5]
	Explanation:

	The given code snippet implements the Next Greater Element algorithm. Here's how it works:

	1. The function `NextGreaterElement` takes an input array of integers and returns an array of the same length
	   where each element represents the next greater element in the input array. If there is no greater element, the corresponding output element is set to -1.

	2. The `result` slice is initialized with -1 values, indicating that there are no greater elements initially.

	3. The `stack` is used to keep track of indices of elements from the input array. It will store indices in a
	   way that maintains a decreasing order of values from the input array.

	4. The algorithm performs two passes over the input array. In each pass, it considers the array elements in a
	   circular manner by using the modulo operator `%` on the index.

	5. In the inner loop, the algorithm checks if the current element is greater than the element at the top of the stack.
	   If it is, it means the current element is the next greater element for the element at the top of the stack.

	6. If a greater element is found, the top index is retrieved from the stack, and the corresponding element in the
	   `result` slice is updated with the current element from the input array.

	7. After updating the `result` slice, the top index is removed from the stack.

	8. The current circular index is then pushed onto the stack to potentially find the next greater element for it in
	   the future.

	9. Once the algorithm completes the two passes over the input array, the `result` slice contains the next greater
	   elements for each element in the input array, or -1 if there is no greater element.

	10. The `result` slice is returned as the output.

	The algorithm utilizes a stack to efficiently find the next greater element for each element in the input array.
	By iterating over the array twice in a circular manner, it ensures that all elements have been considered for finding the next greater elements.

	Note that this implementation assumes the availability of the built-in append function to modify slices in Go.

	The time complexity of the `NextGreaterElement` function is O(n), where n is the length of the input array.
	This is because the function performs two passes over the input array, and in each pass, it processes each element once. The operations performed within each iteration, such as stack operations, have constant time complexity.

    The space complexity of the function is O(n) as well. This is because the function creates two additional
	slices: `result` and `stack`, each with a maximum size of n. Therefore, the space required by the function grows linearly with the size of the input array.
*/
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

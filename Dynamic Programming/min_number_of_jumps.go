/*
	This Go code snippet implements the `MinNumberOfJumps` function, which calculates the minimum number of jumps required to reach the
	last element of the `array` by starting from the first element. Each element of the array represents the maximum number of steps that
	can be taken from that position.

	Here's a step-by-step explanation of the code:

	1. The function `MinNumberOfJumps` takes an array `array` as input and returns the minimum number of jumps required.

	2. The `ways` array is initialized to store the minimum number of jumps required to reach each position in the input array. The length of
	the `ways` array is the same as the input array, and all values are initialized to `math.MaxInt32`, which represents an unreachable state.

	3. The base case is set for the first element of the `ways` array. Since we are already at the first element, the minimum number of jumps
	required is 0. So, `ways[0]` is set to 0.

	4. Starting from the second element (i = 1) to the last element (i = len(array) - 1), the function iterates through the `array`.

	5. For each element, it iterates through all previous elements (j) up to the current position (i) to check if it is possible to jump from j to i.

	6. If `array[j] + j >= i`, it means we can jump from position `j` to position `i`.

	7. The `ways[i]` value is then updated using the minimum between the current `ways[i]` value and `ways[j] + 1`. The `ways[j] + 1` represents
	the minimum number of jumps required to reach position `j`, and then from position `j` to position `i`.

	8. After all iterations, `ways[len(ways) - 1]` will contain the minimum number of jumps required to reach the last element of the array.

	9. The `min` function is a helper function that returns the minimum of two integers.

	The `MinNumberOfJumps` function uses dynamic programming to find the minimum number of jumps efficiently by keeping track of the minimum number
	of jumps required to reach each position from the previous positions. The time complexity of this function is O(n^2), where n is the length of
	the input array. The space complexity is O(n), as the `ways` array is used to store the minimum jumps for each position in the array.
*/
package main

import "math"

// MinNumberOfJumps calculates the minimum number of jumps required to reach the last element of the `array`.
func MinNumberOfJumps(array []int) int {
	// Create an array to store the minimum number of jumps required to reach each position in the `array`.
	ways := make([]int, len(array))
	
	// Initialize the `ways` array with maximum integer values representing an unreachable state.
	for i := range ways {
		ways[i] = math.MaxInt32
	}
	
	// Base case: The first element requires 0 jumps to reach itself.
	ways[0] = 0
	
	// Iterate through the array starting from the second element.
	for i := 1; i < len(array); i++ {
		// Check all previous elements to see if a jump from j to i is possible.
		for j := 0; j < i; j++ {
			// If it is possible to jump from j to i, update the `ways[i]` value.
			if array[j] + j >= i {
				ways[i] = min(ways[i], ways[j]+1)
			}
		}
	}
	
	// The value at `ways[len(ways) - 1]` will contain the minimum number of jumps required to reach the last element.
	return ways[len(ways)-1]
}

// min returns the minimum of two integers.
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}


/*
	The given code snippet calculates the minimum number of jumps required to reach the end of an array of integers. 
	Each element in the array represents the maximum distance you can jump from that position.

	Here's a step-by-step explanation of the code:

	1. The function `MinNumberOfJumps` takes an integer array `array` as input and returns the minimum number of jumps 
	required to reach the last element.

	2. The code first checks if the length of the `array` is 1. If so, it means there's only one element, and we don't 
	need any jumps to reach the end. In this case, the function returns 0.

	3. If the array has more than one element, the code proceeds with the jump calculation.

	4. The variables `jumps`, `maxreach`, and `steps` are initialized. `jumps` keeps track of the total number of jumps 
	taken, `maxreach` represents the farthest position that can be reached in a single jump, and `steps` represents the 
	remaining steps until a new jump is required.

	5. The loop starts from the second element (index 1) and iterates until the second-to-last element (index `len(array) - 1`). 
	The reason for stopping at the second-to-last element is that we don't need to take any additional jumps from there, as 
	we are already at the end.

	6. For each iteration, the code checks if the current index plus the value at that index (`i + array[i]`) is greater 
	than the current `maxreach`. If so, it updates `maxreach` to the new value, representing the farthest position that 
	can be reached in a single jump.

	7. It then decrements `steps` by 1, representing the steps taken in the current jump.

	8. If `steps` becomes 0, it means the current jump is completed, and a new jump is required. So, it increments `jumps` 
	by 1 and updates `steps` with the number of steps required to reach the farthest position (i.e., `maxreach - i`).

	9. After the loop completes, the function returns `jumps + 1`. The `+1` is added because the loop doesn't consider the 
	last element in the array (as we don't need an additional jump from there), so we need to add one more jump to reach the last element.

	In summary, the code efficiently calculates the minimum number of jumps required to reach the last element in the array 
	by simulating the jumps and keeping track of the farthest position that can be reached in each jump. The final result 
	is the total number of jumps taken to reach the end.
*/
func MinNumberOfJumpsOptimal(array []int) int {
	// If the array has only one element, no jumps are needed.
	if len(array) == 1 {
		return 0
	}

	// Initialize variables to keep track of jumps, maximum reachable position, and remaining steps in a jump.
	jumps := 0
	maxreach, steps := array[0], array[0]

	// Iterate through the array to calculate the minimum number of jumps.
	// We stop at the second-to-last element as we don't need an additional jump from there.
	for i := 1; i < len(array)-1; i++ {
		// Update the maximum reachable position if the current position plus the value at that index is greater.
		if i+array[i] > maxreach {
			maxreach = i + array[i]
		}

		// Decrement the remaining steps in the current jump.
		steps--

		// If the current jump is completed (steps becomes 0), calculate the new jump.
		if steps == 0 {
			// Increment jumps to count the completed jump.
			jumps++

			// Update steps to the number of steps required to reach the farthest position.
			steps = maxreach - i
		}
	}

	// The minimum number of jumps to reach the last element is the total number of jumps taken plus one
	// because the loop doesn't consider the last element (as we don't need an additional jump from there).
	return jumps + 1
}

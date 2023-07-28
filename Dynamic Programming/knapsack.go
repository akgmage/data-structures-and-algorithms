/*
  You're given an array of arrays where each subarray holds two integer values and represents an item;
  the first integer is the item's value, and the second integer is the item's weight.
  You're also given an integer representing the maximum capacity of a knapsack that you have.

  Your goal is to fit items in your knapsack without having the sum of their weights exceed the knapsack's
  capacity, all the while maximizing their combined value. Note that you only have one of each item at your disposal.

  Write a function that returns the maximized combined value of the items that you should pick as well as an array of
  the indices of each item picked.

  Sample Input:= [[1, 2], [4, 3], [5, 6], [6, 7]]
  Output:= [10, [1, 3]] // items [4, 3] and [6, 7]
*/
package main

func KnapsackProblem(items [][]int, capacity int) []interface{} {
	// Create a 2D array to store the values of different knapsack configurations.
	values := make([][]int, len(items)+1)
	for i := range values {
		values[i] = make([]int, capacity+1)
	}

	// Iterate through the items and fill the values array.
	for i := 1; i < len(items)+1; i++ {
		currentValue := items[i-1][0]
		currentWeight := items[i-1][1]

		for c := 0; c < capacity+1; c++ {
			// If the current item's weight is more than the current capacity (c),
			// then we cannot include it, so we use the value from the previous row (i - 1).
			if currentWeight > c {
				values[i][c] = values[i-1][c]
			} else {
				// If we can include the current item, we have two choices:
				// 1. Not include the current item, so the value remains the same as the previous row.
				// 2. Include the current item, which adds its value to the value of the knapsack at capacity (c - currentWeight).
				// We choose the maximum of these two options.
				values[i][c] = max(values[i-1][c], values[i-1][c-currentWeight]+currentValue)
			}
		}
	}

	// The value at the bottom-right corner of the values array represents the maximum achievable value for the knapsack problem.
	value := values[len(items)][capacity]

	// Call the getKnapSackItems function to find the items that were included in the knapsack to achieve the maximum value.
	sequence := getKnapSackItems(values, items)

	// Return the maximum value and the sequence of items included in the knapsack as an interface slice.
	return []interface{}{value, sequence}
}

// getKnapSackItems is a helper function to find the sequence of items included in the knapsack.
func getKnapSackItems(values [][]int, items [][]int) []int {
	sequence := []int{}
	i, c := len(values)-1, len(values[0])-1

	// Starting from the bottom-right corner of the values array,
	// we traverse back to find the items included in the knapsack.
	for i > 0 {
		if values[i][c] == values[i-1][c] {
			// If the value is the same as in the previous row, it means the current item was not included.
			// So, we move to the previous row without adding the item to the sequence.
			i--
		} else {
			// If the value is greater than the value in the previous row, it means the current item was included.
			// So, we add the index of the current item (i-1) to the sequence and update the capacity (c) accordingly.
			sequence = append(sequence, i-1)
			c -= items[i-1][1]
			i--
		}
		// If the capacity becomes 0, it means we have included all the items needed to achieve the maximum value.
		if c == 0 {
			break
		}
	}

	// The sequence of items is built in reverse order, so we need to reverse it to get the correct order.
	reverse(sequence)
	return sequence
}

// max returns the maximum of two integers.
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// reverse reverses the order of elements in the given slice.
func reverse(numbers []int) {
	for i, j := 0, len(numbers)-1; i < j; i, j = i+1, j-1 {
		numbers[i], numbers[j] = numbers[j], numbers[i]
	}
}

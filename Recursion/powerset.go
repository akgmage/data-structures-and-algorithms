
package main

func Powerset(array []int) [][]int {
	// Call the powerset helper function to compute the powerset of the array
	return powerset(array, len(array)-1)
}

func powerset(array []int, index int) [][]int {
	// Base case: If the index is less than 0, all elements have been processed, return the empty set
	if index < 0 {
		return [][]int{{}}
	}

	// Retrieve the element at the current index
	element := array[index]

	// Recursively call the powerset function with the array and the index decremented by 1
	subset := powerset(array, index-1)

	// Calculate the length of the current subset
	length := len(subset)

	// Iterate over the existing subsets and create new subsets by appending the current element
	for i := 0; i < length; i++ {
		currentSubset := subset[i]
		newSubset := append([]int{}, currentSubset...) // Create a new subset by making a copy of the current subset
		newSubset = append(newSubset, element)         // Append the current element to the new subset
		subset = append(subset, newSubset)             // Add the new subset to the existing subset slice
	}

	// Return the updated subset slice containing all the subsets of the original array
	return subset
}

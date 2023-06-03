/*
	Given an array of integers between 1 and n, inclusive where n  is the length of the array, write a function
	that returns the first integer that appears more than once (when the array isread from left to right).

	Sample Input: [2, 3, 1, 4, 2, 5, 3]
	Output: 2
*/

package main

import "fmt"

/*
Approach 1:
	1. We define the `FirstDuplicateValue` function that takes an array of integers as input and returns the
	first duplicate value found in the array.

	2. Inside the function, we create a map named `seenSoFar` using the `make` function. This map will be
	used to keep track of the numbers that have been seen so far in the array.

	3. We iterate over each number in the `array` using the `range` keyword.

	4. For each number, we check if it exists as a key in the `seenSoFar` map. If the value exists, it means
	the number has been seen before and is a duplicate.

	5. If a duplicate value is found, we immediately return the duplicate value as the result.

	6. If the number is not a duplicate, we add it to the `seenSoFar` map by setting the corresponding key to
	`true`, indicating that it has been seen.

	7. After iterating through all the numbers in the array without finding a duplicate, we return -1 to
	indicate that no duplicate value was found.

	In the `main` function, we demonstrate the usage of the `FirstDuplicateValue` function by creating an
	example array with some duplicate values. We call the function and store the result in the `firstDuplicate`
	variable. Finally, we print the `firstDuplicate` value, which gives us the first duplicate value in the array.
	In this case, the output will be "2" since it is the first duplicate value encountered in the array
	`[2, 3, 1, 4, 2, 5, 3]`.
*/

func FirstDuplicateValue(array []int) int {
	// Create a map to store the numbers that have been seen so far.
	seenSoFar := make(map[int]bool)

	// Iterate over each number in the array.
	for _, num := range array {
		// Check if the current number has been seen before.
		if _, valueExists := seenSoFar[num]; valueExists {
			// If the number is already in the map, it is the first duplicate value.
			return num
		}

		// Add the current number to the map to mark it as seen.
		seenSoFar[num] = true
	}

	// If no duplicate value is found, return -1.
	return -1
}

/*
Approach2:
	The code defines a function FirstDuplicateValue that takes an integer array array as its input and returns the
	first integer value that appears more than once in the input array. The function implements this using a
	technique called "negation of visited elements".

	The function first loops through each element in the input array array. For each element, it computes the
	absolute value using the abs function, which is defined as a separate helper function. The absolute value
	is used to get the index of the element in the array (adjusted by -1 to account for 0-based indexing).

	If the element at the computed index in the array is already negative, it means that we have seen this
	element before and hence it is a duplicate. In this case, we return the absolute value of the element.

	If the element is not negative, we negate it to mark it as visited. This is done by multiplying the
	element at the computed index in the array by -1.

	If there are no duplicate values in the input array, the function returns -1.

	Overall, this approach uses constant extra space and has a time complexity of O(n), where n is the
	length of the input array.
*/
// Function to find the first duplicate value in an array.
func FirstDuplicateValue2(array []int) int {
   // Iterate over each element in the array.
   for _, num := range array {
       // Get the absolute value of the current element.
       absValue := abs(num)

       // Check if the value at the index (absValue - 1) in the array is negative.
       if array[absValue - 1] < 0 {
           // If it is negative, then the current element is the first duplicate value.
           return absValue
       }

       // Otherwise, mark the value at the index (absValue - 1) in the array as negative.
       array[absValue - 1] *= -1
   }

   // If no duplicates are found, return -1.
   return -1
}

// Function to get the absolute value of a number.
func abs(num int) int {
    if num < 0 {
        return -num
    }
    return num
}

func main() {
	// Example usage of FirstDuplicateValue function
	array := []int{2, 3, 1, 4, 2, 5, 3}
	firstDuplicate := FirstDuplicateValue(array)
	fmt.Println("First Duplicate Value:", firstDuplicate)
	firstDuplicate = FirstDuplicateValue2(array)
	fmt.Println("First Duplicate Value:", firstDuplicate)
}
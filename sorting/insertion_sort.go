/*
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
*/

package main

import "fmt"

// InsertionSort is a function that takes an array of integers and sorts it in
// ascending order using the Insertion Sort algorithm.
func InsertionSort(arr []int) []int {
    // Iterate over the array from the second element to the end
    for i := 1; i < len(arr); i++ {
        // Set the current value and the previous index
        current := arr[i]
        j := i - 1

        // Compare the current value with the previous values in the array
        for j >= 0 && arr[j] > current {
            // Shift the values to the right to make space for the current value
            arr[j+1] = arr[j]
            j--
        }

        // Insert the current value in the correct position
        arr[j+1] = current
    }

    // Return the sorted array
    return arr
}

func main() {
    arr := []int{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}
    sortedArr := InsertionSort(arr)
    fmt.Println(sortedArr)
}

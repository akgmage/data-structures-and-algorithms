// Implementation of Bubble sort.
// Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
// that repeatedly steps through the input list element by element,
// comparing the current element with the one after it, swapping their values if needed.
//  These passes through the list are repeated until no swaps had to be performed during a pass,
// meaning that the list has become fully sorted.

// Time Complexity O(n2)

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]

package main

import "fmt"

func main() {
	arr := [6]int{2, 1, 3, 5, 4, 0}
	// arr := [6]int{0, 1, 2, 3, 4, 5} uncomment for best case
	flag := true
	for i := 0; i < 6; i++ {
		for j := 0; j < 6 - i - 1; j++ {
			if(arr[j] > arr[j + 1]) {
				arr[j], arr[j + 1] = arr[j + 1], arr[j]
				flag = false // hack if the array is already sorted, no need for redundant passes
			}
		}
		if flag {
			fmt.Println("Already sorted so no further redundant passes best case O(n)")
			break
		}
	} 
	fmt.Println(arr)

}
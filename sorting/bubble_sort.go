// Implementation of Bubble sort.
// Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
// that repeatedly steps through the input list element by element,
// comparing the current element with the one after it, swapping their values if needed.
//  These passes through the list are repeated until no swaps had to be performed during a pass,
// meaning that the list has become fully sorted. (Source wiki) https://en.wikipedia.org/wiki/Bubble_sort

// Time Complexity worst-case and average complexity O(n^{2})
// Bubble sort is O(n) on a list that is already sorted i.e. Best case

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]

package main

import "fmt"

func bubbleSort(arr []int) {
    n := len(arr)
	flag := true
    // Traverse through all array elements
    for i := 0; i < n-1; i++ {
        // Last i elements are already sorted
        for j := 0; j < n-i-1; j++ {
            // Swap adjacent elements if they are in the wrong order
            if arr[j] > arr[j+1] {
                arr[j], arr[j+1] = arr[j+1], arr[j]
				flag = false
            }
        }
		if flag {
			fmt.Println("Already sorted so no further redundant passes best case O(n)")
			break
		}
    }
}

func main() {
    arr := []int{64, 25, 12, 22, 11}
    bubbleSort(arr)
    fmt.Println("Sorted array:", arr)
}

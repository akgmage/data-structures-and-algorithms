/*
    Here's how the Bubble Sort algorithm works:

    1. We start by comparing the first two elements of the array. If the first element is greater than the second 
       element, we swap them.
    2. We then compare the second and third elements. If the second element is greater than the third element, 
       we swap them.
    3. We continue this process until we reach the end of the array. At this point, the largest element will 
       be at the end of the array.
    4. We then repeat steps 1-3 for the remaining unsorted portion of the array until the entire array is sorted.
    
    The time complexity of Bubble Sort is O(n^2) in the worst and average case, and O(n) in the best case when 
    the input array is already sorted. 
    
    The space complexity is O(1) as Bubble Sort operates on the input array in-place.

    Bubble sort is O(n) on a list that is already sorted i.e. Best case

    Sample Input : [2, 1, 9, 3, 5, 4, 0]
    Output : [0 1 2 3 4 5 9]
*/

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

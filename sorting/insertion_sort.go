/*
Implementation of insertion sort in go.
Insertion sort is a simple sorting algorith that iterates through
the list starting at the second element. We compare each element
to the preceding elements, slide over the preceding larger (or smaller)
elements, and insert the original element into the empty position.

Time Complexity worst-case and average complexity O(n^{2})

Insertion sort is inefficient for large arrays. However it is fast for
small arrays and typically more efficient than bubble sort and selection
sort due to not making as many comparisons on average.

Source: https://en.wikipedia.org/wiki/Insertion_sort

Sample input: [0, 2, 1,-1, 10, 3, 4]
Output: [-1 0 1 2 3 4 10]
*/

package main

import "fmt"

func main() {
	a_lst := []int{0, 2, 1, -1, 10, 3, 4}
	insertion_sort(a_lst)
	fmt.Print(a_lst)
}

/*
	Divide the input array into two subarrays in place. The first subarray should be sorted at all times
	and should start with a length of 1, while the second subarray should be unsorted. 
	Iterate through the unsorted subarray, inserting all of its elements into the sorted subarray 
	in the correct position by swapping them into place. Eventually, the entire array will be sorted.
*/
func insertion_sort(array []int) {
	for i := 1; i < len(array); i++ {
        j := i
        for j > 0 && array[j] < array[j - 1] {
            array[j], array[j - 1] = array[j - 1], array[j] 
            j -= 1
        }
    }
}

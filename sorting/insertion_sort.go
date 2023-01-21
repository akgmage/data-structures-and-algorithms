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

func insertion_sort(a_lst []int) {
	for index := 1; index < len(a_lst); index++ {
		val := a_lst[index]
		position := index - 1
		for 0 <= position && val < a_lst[position] {
			a_lst[position+1] = a_lst[position]
			position--
		}
		a_lst[position+1] = val
	}
}

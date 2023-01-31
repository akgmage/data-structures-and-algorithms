// Program to separate Even and Odd numbers
// Sample input: [1, 2, 3, 4, 5, 6]
// Output : [6 2 4 3 5 1]

package main

import "fmt"

func SeparateEvenAndOdd(Arr []int) []int {
	start, end := 0, len(Arr) - 1

	for start < end {
		for Arr[start] % 2 == 0 && start < end {
			start++ // element in correct place so just increment the counter
		}
		for Arr[end] % 2 == 1 && start < end {
			end-- // element in correct place so just decrement the counter
		}
		// two pointers start and end which are not in correct place so need to be swapped
		if start < end {
			Arr[start], Arr[end] = Arr[end], Arr[start]
			start++ 
			end--
		}
	}
	return Arr
}

func main() {
	Arr := []int{1, 2, 3, 4, 5, 6}
	fmt.Println(SeparateEvenAndOdd(Arr))
}
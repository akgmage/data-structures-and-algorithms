// Program to separate Zeros and Ones
// Sample input: [0, 1, 0, 1, 0, 0, 1]
// Output : [0, 0, 0, 0, 1, 1, 1]

package main

import "fmt"

func SeparateZerosAndOnes(Arr []int) []int {
	start, end := 0, len(Arr) - 1

	for start < end {
		for Arr[start] == 0 && start < end {
			start++ // element in correct place so just increment the counter
		}
		for Arr[end]  == 1 && start < end {
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
	Arr := []int{0, 1, 1, 0, 1, 0, 0, 1}
	fmt.Println(SeparateZerosAndOnes(Arr))
}
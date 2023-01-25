package main

import "fmt"

func FirstOccurance(Arr []int, key int) int {
	start, end, result := 0, len(Arr)-1, -1

	for start <= end {
		mid := start + (end-start)/2
		if Arr[mid] > key {
			end = mid - 1
		} else if Arr[mid] < key {
			start = mid + 1
		} else {
			result = mid
			end = mid - 1
		}
	}
	return result
}

func main() {
	Arr := []int{0, 1, 1, 4, 5}
	fmt.Println(FirstOccurance(Arr, 1))
}
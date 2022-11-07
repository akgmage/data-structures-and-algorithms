package main

import "fmt"

func SelectionSort(arr []int, length int) []int {
	for i := 0; i < length-1; i++ {
		imin := i
		for j := i + 1; j < length; j++ {
			if arr[j] < arr[imin] {
				imin = j
			}
		}
		arr[i], arr[imin] = arr[imin], arr[i]
	}
	return arr
}

func main() {
	arr := []int{2, 1, 9, 3, 5, 4, 0}
	msg := SelectionSort(arr, 7)
	fmt.Println(msg)
}
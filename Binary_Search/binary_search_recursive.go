package main

import "fmt"

func BinarySearch(Arr []int, key int) bool {
	low := 0
	high := len(Arr) - 1
	if low <= high {
		mid := (high + low) / 2
		if Arr[mid] > key {
			return BinarySearch(Arr[:mid], key)
		} else if Arr[mid] < key {
			return BinarySearch(Arr[mid + 1:], key)
		} else {
			return true
		}
	}
	return false
}

func main() {
	Arr := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	fmt.Println(BinarySearch(Arr, 5))
	fmt.Println(BinarySearch(Arr, 6))
	fmt.Println(BinarySearch(Arr, -1))
	fmt.Println(BinarySearch(Arr, -10))
	fmt.Println(BinarySearch(Arr, 70))
}
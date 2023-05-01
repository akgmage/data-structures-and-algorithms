package main

import "fmt"

func FirstDuplicateValue(array []int) int {
	seenSoFar := make(map[int]bool)
	for _, num := range array {
		if _, valueExists := seenSoFar[num]; valueExists {
			return num
		}
		seenSoFar[num] = true
	}
	return -1
}

func main() {
	array := []int{2, 1, 5, 2, 3, 3, 4}
	firstDuplicate := FirstDuplicateValue(array)
	fmt.Println(firstDuplicate)
}

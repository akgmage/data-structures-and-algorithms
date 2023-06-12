package main

import "fmt"

// [1,2,0,2,0,1,2,1,0] --> [0,0,0,1,1,1,2,2,2]

func main() {
	array := []int64{2, 0, 1, 2, 1, 0}
	result := DutchNationalFlag(array)
	fmt.Println(result)

}

func DutchNationalFlag(array []int64) []int64 {

	var (
		Low  = 0
		Mid  = 0
		High = len(array) - 1
	)
	for Mid <= High {
		switch array[Mid] {
		case 0:
			array[Low], array[Mid] = array[Mid], array[Low]
			Low++
			Mid++
		case 1:
			Mid++
		case 2:
			array[Mid], array[High] = array[High], array[Mid]
			High--
		}
	}
	return array

}

package main

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

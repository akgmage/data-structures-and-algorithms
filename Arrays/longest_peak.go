package main

import "fmt"

// LongestPeak function takes an integer array and returns the length of the longest peak in the array.
func LongestPeak(array []int) int {
	longestPeak := 0
	i := 1
	for i < len(array)-1 {
		// check if i is a peak (i.e., it's greater than its neighbors)
		isPeak := array[i-1] < array[i] && array[i] > array[i+1]
		if !isPeak {
			// if i is not a peak, move to the next element
			i += 1
			continue
		}

		// search left of i to find the beginning of the peak
		leftIndex := i - 2
		for leftIndex >= 0 && array[leftIndex] < array[leftIndex+1] {
			leftIndex--
		}

		// search right of i to find the end of the peak
		rightIndex := i + 2
		for rightIndex < len(array) && array[rightIndex] < array[rightIndex-1] {
			rightIndex++
		}

		// calculate the length of the current peak
		currentPeak := rightIndex - leftIndex - 1

		// update longestPeak if currentPeak is longer
		if currentPeak > longestPeak {
			longestPeak = currentPeak
		}

		// move i to the end of the current peak
		i = rightIndex
	}
	return longestPeak
}

func main() {
	array := []int{1, 2, 3, 4, 5, 4, 3, 2, 1}
	longestPeak := LongestPeak(array)
	fmt.Println(longestPeak) // Output: 9
}
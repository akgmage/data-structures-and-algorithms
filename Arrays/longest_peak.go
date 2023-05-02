package main

func LongestPeak(array []int) int {
	longestPeak := 0
	i := 1
	for i < len(array)-1 {
		isPeak := array[i-1] < array[i] && array[i] > array[i+1]
		if !isPeak {
			i += 1
			continue
		}

		leftIndex := i - 2
		for leftIndex >= 0 && array[leftIndex] < array[leftIndex+1] {
			leftIndex--
		}

		rightIndex := i + 2
		for rightIndex < len(array) && array[rightIndex] < array[rightIndex-1] {
			rightIndex++
		}
		currentPeak := rightIndex - leftIndex - 1
		if currentPeak > longestPeak {
			longestPeak = currentPeak
		}
		i = rightIndex
	}
	return longestPeak
}
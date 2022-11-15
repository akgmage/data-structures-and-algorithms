package main

import "fmt"

func TwoNumberSum(array []int, target int) []int {
	// Write your code here.
	m := make(map[int]int)
	var result []int
	for i := 0; i < len(array); i++ {
		required := target - array[i]
		if _, ok := m[required]; ok {
			result = append(result, required)
			result = append(result, array[i])
			return result
		} else {
			m[array[i]] = i
		}
	}
	return result
}

func main() {
	arr := []int{2, 1, 3, -1, 11, 5, 4, 0}
	msg := TwoNumberSum(arr, 10)
	fmt.Println(msg)
}
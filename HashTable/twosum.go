/*
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.
  Sample Input: [2, 1, 3, -1, 11, 5, 4, 0] Target: 10
  Output: [-1 11]
*/
package main

import "fmt"

// Bruteforce method continuously scan the array
// for every i run j len(array) times, if target sum is found then return
func TwoNUmberSumBruteForce(array []int, target int) []int {
	// nil array to hold result
	var result []int
	for i := 0; i < len(array) - 1; i++ {
		for j := i + 1; j < len(array); j++ {
			// look for target
			if array[i] + array[j] == target {
				// add found values in array
				result = append(result, array[i])
				result = append(result, array[j])
				return result
			}
		}
	}
	return result 
}

func TwoNumberSum(array []int, target int) []int {
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
	msg = TwoNUmberSumBruteForce(arr, 10)
	fmt.Println(msg)
}
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

import (
	"fmt"
	"sort"
)

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
// Two Pointer approach
// sort the given array, set i as initial index and j as last
// add element at i and j and compate with target, if it matches then return
// if element is greater then target decrease index of j by 1
// if element is lesser then target increase index of i by 1
func TwoNumberSumTwoPointerMethod(array []int, target int) []int {
	var result []int
	// sort the given array in place
	sort.Ints(array)
	j := len(array) - 1 // set j as last
	i := 0 // set i as initial index
	// i and j should not overlap
	for i < j { 
		// check if it matches sum
		if array[i] + array[j] == target {
			// add result in array
			result = append(result, array[i])
			result = append(result, array[j])
			// return the result
			return result
		} else if array[i] + array[j] > target {
			// elements is greater that means look to left side of j
			j--;
		} else if array[i] + array[j] < target {
			// // elements is smaller that means look to right side of i
			i++;
		}
	}
	return result
}

func TwoNumberSum(array []int, target int) []int {
	// Create map to keep track of what we ahve seen so far
	m := make(map[int]int)
	 // initialize empty array for result
	var result []int
	 // traverse array
	for i := 0; i < len(array); i++ {
		// lets say first element in our array is 3, and target sum is 10
        // then we will look for 7 in our map, if its present then we simply return 7 and 3 
		required := target - array[i]
		// if the required value is found then store result
		if _, ok := m[required]; ok {
			result = append(result, required)
			result = append(result, array[i])
			return result
		} else {
			// keep track of what value in array we have seen so far
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
	arr = []int{2, 1, 3, -1, 11, 5, 4, 0, 44}
	msg = TwoNumberSumTwoPointerMethod(arr, 9)
	fmt.Println(msg)
}
/*
	You're given a list of integers nums. Write a function that returns a boolean representing 
	whether there exists a zero-sum subarray of nums

	Sample Input :  = [-5, -5, 2, 3, -2]
	Output : True
	The subarray [-5, 2, 3] has a sum of 0 
*/

package main

func ZeroSumSubarray(nums []int) bool {
	sums := map[int]bool{0: true}
    currentSum := 0
    for _, num := range nums {
        currentSum += num
        if _, sumIsInSet := sums[currentSum]; sumIsInSet {
            return true
        }
        sums[currentSum] = true
        print(currentSum , " ")
    }
    return false
}

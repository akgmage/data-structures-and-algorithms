/*
	You're given a list of integers nums. Write a function that returns a boolean representing 
	whether there exists a zero-sum subarray of nums

	Sample Input :  = [-5, -5, 2, 3, -2]
	Output : True
	The subarray [-5, 2, 3] has a sum of 0 
*/
/*
Approach:

  A good way to approach this problem is to first think of a simpler version.
  How would you check if the entire array sum is zero?
  
  If the entire array does not sum to zero, then you need to check if there are
  any smaller subarrays that sum to zero. For this, it can be helpful to keep
  track of all of the sums from [0, i], where i is every index in the array.
  
  After recording all sums from [0, i], what would it mean if a sum is repeated?
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

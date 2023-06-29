/*
	-> The firstMissingPositive function takes a slice of integers called nums as input.

    -> The function determines the length of the slice nums and assigns it to the variable n.

    -> Step 1: Move positive numbers to their correct positions
        - The algorithm iterates through each element of the slice using a for loop.
        - Inside the loop, it checks if the current number (nums[i]) is positive and within the range of 1 to n.
        - If the number is valid, it checks whether the number at its correct position (nums[nums[i]-1]) is different 
		from the current number itself. This ensures that the number is not already in its correct place.
        - If the numbers are different, it swaps the current number with the number at its correct position using the 
		Go idiomatic way of swapping values (nums[nums[i]-1], nums[i] = nums[i], nums[nums[i]-1]).
        - The swapping process continues until the number at index i is either non-positive or already in its correct 
		place. This step ensures that all positive numbers are placed in their respective positions.

    -> Step 2: Find the first missing positive
        After completing the first pass through the slice, the algorithm performs a second pass using another for loop.
        Inside the loop, it checks if the number at index i is equal to i + 1. If not, it means that i + 1 is missing from the slice.
        In this case, the algorithm returns i + 1 as the smallest missing positive integer.

    -> If all positive integers from 1 to n are present in the slice, the function reaches the end without finding a 
	missing positive. In this case, it returns n + 1 as the smallest missing positive integer.

The Go implementation of the algorithm ensures that it modifies the input slice nums in-place without using any 
additional data structures, meeting the O(1) auxiliary space requirement. The time complexity of the algorithm 
remains O(n) as it performs two passes through the slice, visiting each element once.
*/

/*
Example->

Example 1:
Input: nums := []int{1, 2, 0}
Output: 3
Explanation: The smallest missing positive integer in the slice is 3.

Example 2:
Input: nums := []int{3, 4, -1, 1}
Output: 2
Explanation: The smallest missing positive integer in the slice is 2.

Example 3:
Input: nums := []int{7, 8, 9, 11, 12}
Output: 1
Explanation: The smallest missing positive integer in the slice is 1.

*/

func firstMissingPositive(nums []int) int {
	n := len(nums)

	// Step 1: Move positive numbers to their correct positions
	for i := 0; i < n; i++ {
		for nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i] {
			nums[nums[i]-1], nums[i] = nums[i], nums[nums[i]-1]
		}
	}

	// Step 2: Find the first missing positive
	for i := 0; i < n; i++ {
		if nums[i] != i+1 {
			return i + 1
		}
	}

	// If all positive integers are present, return n + 1
	return n + 1
}

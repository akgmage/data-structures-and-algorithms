## Contributing

## Fork this repository

Get involved! Fork this repository by clicking on the fork button on the top of this page. This will create a copy of this repository in your account.

- [How to Fork a repo](https://docs.github.com/en/get-started/quickstart/fork-a-repo)

Before you get started, we encourage you to read these documents which describe some of our community norms:

Our [code of conduct](https://github.com/akgmage/data-structures-and-algorithms/blob/main/CODE_OF_CONDUCT.md), which stipulates explicitly that everyone must be gracious, respectful, and professional. This also documents our conflict resolution policy and encourages people to ask questions.

Contributions are always welcome!

- Pick any good first issue and add comment on it (Example: "I'll take this up"), or Add classic DSA problem which is currently not present in this repo
- Read description on the issue (Mostly it will be the link to the question)
- Add question on top of file
- Add sample input and output
- Explain approach with comments
- Add Time and Space complexity
- Take care of Readability (Code is written once and read multiple times, so keep this in mind)
- Provide link for further reading (optional)
- Send a Pull Request (PR) against main branch and mention issue number in the request format (#ISSUENUMBER)

# Example program

```go
/*
	Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array)
	whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number from
	the first array in the first position.

	Note that the absolute difference of two integers is the distance between them on the real number line.
	For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.

  	You can assume that there will only be one pair of numbers with the smallest difference.

	Sample Input Array1 = [-1, 5, 10, 20, 28, 3]
	Sample Input Array2 = [26, 134, 135, 15, 17]

	Sample Output = [28, 26]

    Explanation :

	This code implements the Smallest Difference problem which takes two arrays of integers as input and returns a pair of integers,
	one from each array, with the smallest absolute difference between them.

	The function first initializes two variables current and smallest to the maximum integer value. It then sorts both input arrays
	in ascending order using the sort.Ints function from the sort package.

	The function then iterates through both arrays using two pointers, idx1 and idx2, initialized to 0. Inside the loop, it compares
	the elements at the current indices of the two arrays, first and second, and calculates the absolute difference between
	them in the current variable.

	If current is smaller than the smallest variable, it updates smallest to current and assigns the current pair of integers
	to the result variable.

	The function returns the result variable, which contains the pair of integers with the smallest absolute difference.

	If there are identical integers in the two input arrays, the function will return them immediately, without any further comparisons.

	O(nlog(n) + mlog(m)) time | O(1) space - where n is the length of the first input array and m is the length of the second input array
*/

package main

import (
	"math"
	"sort"
)

// SmallestDifference takes two integer slices as input and returns a slice with two integers.
// The two integers in the returned slice have the smallest absolute difference among all pairs
// of integers from the two input slices.
func SmallestDifference(array1, array2 []int) []int {
	// Initialize variables for the smallest difference and the current difference being calculated
	current, smallest := math.MaxInt32, math.MaxInt32
	// Sort the input slices
	sort.Ints(array1)
	sort.Ints(array2)
	// Initialize variables for the indices for the two slices
	idx1, idx2 := 0, 0
	// Initialize an empty slice for the result
	result := []int{}
	// Loop through the two slices until we reach the end of one of the slices
	for idx1 < len(array1) && idx2 < len(array2) {
		// Get the values at the current indices for the two slices
		first, second := array1[idx1], array2[idx2]
		// Calculate the current difference between the two values
		if first < second {
			current = second - first
			idx1++
		} else if second < first {
			current = first - second
			idx2++
		} else {
			// If the two values are equal, we can return the pair
			return []int{first, second}
		}
		// Update the smallest difference and result slice if the current difference is smaller
		if smallest > current {
			smallest = current
			result = []int{first, second}
		}
	}
	// Return the pair with the smallest absolute difference
	return result
}

```

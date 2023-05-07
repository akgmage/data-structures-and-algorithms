/*
	Given an array of integers A, find and return the product array of the same size where the ith 
	element of the product array will be equal to the product of all the elements divided by the ith 
	element of the array.

	Note: It is always possible to form the product array with integer (32 bit) values. 
	Solve it without using the division operator.

	Input: [1, 2, 3, 4, 5]
	Output : [120, 60, 40, 30, 24]
	
	Explanation:
	This code implements a function called `ArrayOfProducts`, which takes an input array of integers and returns a 
	new array of the same size, where each element in the new array is the product of all the elements in the input 
	array except for the element at that index.

	To accomplish this, the function first creates a new result array with the same length as the input array. 
	Then, it initializes a `leftRunningProduct` variable to 1, and loops through the input array from left to right. 
	For each element in the input array, the function sets the corresponding element in the result array to the 
	current value of `leftRunningProduct`, and then updates `leftRunningProduct` to be the product of `leftRunningProduct` 
	and the current element in the input array.

	Next, the function initializes a `rightRunningProduct` variable to 1, and loops through the input array from right to left. 
	For each element in the input array, the function multiplies the corresponding element in the result array by `rightRunningProduct`, 
	and then updates `rightRunningProduct` to be the product of `rightRunningProduct` and the current element in the input array.

	Finally, the function returns the result array.

	This algorithm has a time complexity of O(n), where n is the length of the input array, since it loops through the input array 
	three times. It has a space complexity of O(n), since it creates a new result array of size n, and two additional integer variables.
 */

package main

func ArrayOfProducts(array []int) []int {
	// create two arrays to store the products of all elements to the left and right of each element in the input array
	leftProduct := make([]int, len(array))
	rightProduct := make([]int, len(array))

	// compute the product of all elements to the left of each element in the input array
	leftRunningProduct := 1
	for i := 0; i < len(array); i++ {
		leftProduct[i] = leftRunningProduct
		leftRunningProduct *= array[i]
	}

	// compute the product of all elements to the right of each element in the input array
	rightRunningProduct := 1
	for i := len(array) - 1; i >= 0; i-- {
		rightProduct[i] = rightRunningProduct
		rightRunningProduct *= array[i]
	}

	// compute the product of all elements to the left and right of each element in the input array
	for i := 0; i < len(array); i++ {
		rightProduct[i] = leftProduct[i] * rightProduct[i]
	}

	// return the array of products
	return rightProduct
}

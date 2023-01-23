package main

import "fmt"

/**
 * Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
 *
 * Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 * Output Format
 *
 * Return the product array.
 * Constraints
 *
 * 2 <= length of the array <= 1000
 * 1 <= A[i] <= 10
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 * Output 1:
 *     [120, 60, 40, 30, 24]
 *
 * Input 2:
 *     A = [5, 1, 10, 1]
 * Output 2:
 *     [10, 50, 5, 50]
 */

func ArrayOfProducts(Arr[]int) {
	Result := make([]int, len(Arr))
	product := 1
	// fill left prefix product in result array
	for i := 0; i < len(Arr); i++ {
		Result[i] = product
		product = product * Arr[i]
	}

	// fill right prefix product in result array
	product = 1
	for i := len(Arr) - 1; i >= 0; i-- {
		Result[i] = Result[i] * product
		product = product * Arr[i]
	}

	for i := 0; i < len(Arr); i++ {
		fmt.Print(Result[i]," ")
	}
}

 func main() {
	Arr := []int{5, 1, 10, 1}
	ArrayOfProducts(Arr)
 }
// Statement:

//// Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.

// Example:

//// Input: N = 5 arr[] = {5, 4, 1, 7, 3}, K = 2
//// Output: 5 4 7 7
//// Explanation: 	Maximum of 5, 4 is 5
////           	Maximum of 4, 1 is 4
////           	Maximum of 1, 7 is 7
////           	Maximum of 7, 3 is 7

// Approach:

//// We will travel from 0 to (N-K)th element of the given array. 
//// At each index, we will find the maximum of K indexes including the current index and print.
//// Suppose we are at ith index then we will find maximum of i, i+1, i+2, .. i+k-1 elements and print it.    

// Complexity:

//// Time  Complexity: O(N*K)
//// Space Complexity: O(1)

// Code: 

package main
import "fmt"

func printKMax(arr []int, N int, K int) {
    
	var j, max int

	// Finding the maximum elemnt in each window
	for i := 0; i <= N-K; i++ {
		max = arr[i]

		for j = 1; j < K; j++ {		
			if arr[i+j] > max {
				max = arr[i+j]
			}
		}
		fmt.Printf("%d ", max)
	}
}

func main() {

	var N, K int  					// Variable declaration 
	fmt.Scan(&N) 					// Initialise length of array 
	
	arr := make([]int, N)			// Array Declaration
	for i := 0; i < N; i++ {			// Array Initialisation
	    fmt.Scan(&arr[i])
	}
	
	fmt.Scan(&K)					// Window length initialisation
	
	printKMax(arr, N, K)			// Function call to print maximum element in the window
}

/*
Problem:
You are given a 2D matrix, and the task is to modify it such that if an element in the matrix is zero, you need to set all the elements in the 
corresponding row and column to zero as well.

Solution:
To solve this problem, you can follow the steps below:

1. Create two sets, rows and columns, to keep track of the rows and columns that need to be set to zero.

2. Iterate through the matrix row by row, and for each element, if it is zero, add its row index to the rows set and its column index to the columns set.

3. Iterate through the matrix again, and for each element, check if its row index or column index exists in the respective sets (rows or columns). 
If either index exists, set the element to zero.

4. Finally, iterate through the matrix one more time, and for each row or column index in the rows or columns sets, set all the elements in that 
row or column to zero.

5. Return the modified matrix.

Complexity:
Let's assume the matrix has dimensions MxN.

Step 2: In this step, we iterate through the matrix once, which takes O(M*N) time.

Step 3: In this step, we again iterate through the matrix once, which takes O(M*N) time.

Step 4: In this step, we iterate through the rows and columns sets, which contain at most M+N elements. Therefore, this step takes O(M+N) time.

Overall, the time complexity of the solution is O(MN + M + N), which can be simplified to O(MN). The space complexity is O(M+N) since we are 
using two sets to store the rows and columns that need to be set to zero.
*/

package main

import (
	"fmt"
)

func setZeroes(matrix [][]int) {
	rows := make(map[int]bool)
	columns := make(map[int]bool)

	// Step 1: Find the rows and columns that need to be set to zero
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] == 0 {
				rows[i] = true
				columns[j] = true
			}
		}
	}

	// Step 2: Set the corresponding rows and columns to zero
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if rows[i] || columns[j] {
				matrix[i][j] = 0
			}
		}
	}
}

func main() {
	matrix := [][]int{
		{1, 1, 1},
		{1, 0, 1},
		{1, 1, 1},
	}

	fmt.Println("Original Matrix:")
	printMatrix(matrix)

	setZeroes(matrix)

	fmt.Println("Modified Matrix:")
	printMatrix(matrix)
}

func printMatrix(matrix [][]int) {
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			fmt.Print(matrix[i][j], " ")
		}
		fmt.Println()
	}
}

/// How would you approach finding the maximum path sum in a binary tree using dynamic programming in Go?
// Provide a sample input and output, explain your approach using comments, 
//  and analyze the time and space complexity of your solution.

// sample input:         1
//						/ \
//						2   3
// sample output: Maximum Path Sum: 6

/// Explanation : 
//   1. Implement a function that calculates the maximum path sum in a binary tree using dynamic programming.
//   2. Create a struct treeNode to represent each node in the binary tree, including a Val field for the node's value, Left field for the left child, and Right field for the right child.
//   3. Define a helper function pathMaxSum that takes the root node as input and returns the maximum path sum.
//   4 Within maxPathSum, initialize a variable maxSum with the minimum integer value to track the maximum path sum.
//   5. Call the recursive helper function findMaxSum and pass the root node and the maxSum variable as arguments.
//   6. In the findMaxSum function, handle the base case: if the node is nil, return 0.
//   7. Recursively find the maximum path sum for the left and right subtrees by calling findMaxSum on the left and right children of the current node.
//   8. Calculate the maximum path sum that includes the current node:
		// Check if the left sum is negative (less than 0), assign it as 0.
		// Check if the right sum is negative (less than 0), assign it as 0.
		// Update the maxSum by comparing it with the sum of the current node's value, left sum, and right sum.//
//   9. Return the maximum path sum including the current node (either the current node's value plus the maximum of left or right sum).
//   10. Finally, return the maxSum from the pathMaxSum function.
//   11. In the main function, create a sample binary tree and call pathMaxSum to find the maximum path sum. Print the result.

// Time Complexity: The time complexity of this solution is O(N), where N is the number of nodes in the binary tree, as we need to traverse each node once.

// Space Complexity: The space complexity is O(H), where H is the height of the binary tree. This is due to the recursive calls on the stack, which can go up to the height of the tree.


package main

import (
	"fmt"
	"math"
)

type treenode struct {
	Val int
	Left *treenode
	Right *treenode
}

// Function to find the maximum path sum in a binary tree
func pathMaxSum(root *treenode) int{
	maxSum := math.MinInt32
	findMaxSum(root, &maxSum)
	return maxSum
}

// finding the maximum path sum starting from a given node
func findMaxSum(node *treenode, maxSum *int) int {
	if node == nil {
		return 0
	}

	leftSum := max(0, findMaxSum(node.Left,maxSum))
	rightSum := max(0,findMaxSum(node.Right,maxSum))

	*maxSum = max(*maxSum,node.Val+leftSum+rightSum)

	// returning the max sum plus the current node
	return node.Val + max(leftSum,rightSum)
}

// function to find the maximum of two numbers
func max(a,b int) int {
	if a >b {
		return a
	}
	return b
}

func main() {
	// creating sample binary tree
	root := &treenode{Val: 1}
	root.Left = &treenode{Val: 2}
	root.Right = &treenode{Val: 3}

	// Calculate the maximum path sum
	maxSum := pathMaxSum(root)
	fmt.Println("Maximum Path Sum:", maxSum)
}
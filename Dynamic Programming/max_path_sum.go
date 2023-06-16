// Dynamic Programming: Find Binary Tree Maximum Path Sum in Go
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
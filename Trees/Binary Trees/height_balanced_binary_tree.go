/*
	You're given the root node of a Binary Tree. Write a function that returns true
	if this Binary Tree is height balanced and false if it isn't.

	Explanation:

	The provided code is for checking whether a binary tree is height-balanced or not. Here's how it works:

	- The code defines a `BinaryTree` struct representing a node in a binary tree. Each node has a value and
	pointers to its left and right child nodes.

	- The code also defines a `TreeeInfo` struct to store information about a binary tree. It includes a boolean
	field `isBalanced` indicating whether the tree is balanced or not, and an integer field `height` representing
	the height of the tree.

	- The `HeightBalancedBinaryTree` function is the main function that checks if a binary tree is height-balanced.
	It takes the root of the tree as input and returns a boolean value indicating the balance status.

	- The `getTreeInfo` function is a helper function that recursively calculates the information of a binary tree.
	It takes a binary tree node as input and returns the `TreeeInfo` struct containing the balance status and height
	of the tree.

	- In the `getTreeInfo` function, there are two base cases:
	- If the current tree node is `nil`, it is considered balanced with height -1.
	- If the current tree node is not `nil`, the function recursively calculates the tree information of its
	left and right subtrees.

	- After getting the information of the left and right subtrees, the code checks if both subtrees are balanced
	(`isBalanced` field is `true`) and their height difference is at most 1. If so, the current tree is considered
	balanced.

	- The height of the current tree is calculated by taking the maximum height of the left and right subtrees and
	adding 1.

	- Finally, the `max` function is used to get the maximum of two integers, and the `abs` function is used to get
	the absolute value of an integer.

	To determine whether a binary tree is height-balanced, you can call the `HeightBalancedBinaryTree` function with
	the root of the tree. It will return `true` if the tree is balanced and `false` otherwise.

	The time complexity of the `HeightBalancedBinaryTree` function is O(N), where N is the number of nodes in the
	binary tree. This is because the function needs to traverse each node of the tree once to calculate the tree
	information.

	The space complexity of the `HeightBalancedBinaryTree` function is O(H), where H is the height of the binary tree.
	This is because the recursive calls to the `getTreeInfo` function will utilize the call stack, and the maximum
	depth of the recursive calls is equal to the height of the tree. Additionally, the space complexity of the
	`getTreeInfo` function itself is O(1) as it uses a constant amount of space for the `TreeeInfo` struct.

	Overall, the space complexity is determined by the height of the binary tree, and the time complexity is
	determined by the number of nodes in the binary tree.

*/
package main

import "fmt"

// This is an input class. Do not edit.
type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

type TreeeInfo struct {
	isBalanced bool
	height     int
}

// HeightBalancedBinaryTree checks if a binary tree is height-balanced.
func HeightBalancedBinaryTree(tree *BinaryTree) bool {
	// Retrieve the tree information using the helper function.
	treeInfo := getTreeInfo(tree)

	// Return the balance status of the tree.
	return treeInfo.isBalanced
}

// getTreeInfo retrieves the information of a binary tree, including its balance status and height.
func getTreeInfo(tree *BinaryTree) TreeeInfo {
	// Base case: If the tree is nil, it is considered balanced with height -1.
	if tree == nil {
		return TreeeInfo{isBalanced: true, height: -1}
	}

	// Recursively calculate the tree information of the left and right subtrees.
	leftSubtreeInfo := getTreeInfo(tree.Left)
	rightSubtreeInfo := getTreeInfo(tree.Right)

	// Check if both left and right subtrees are balanced and their height difference is at most 1.
	isBalanced := leftSubtreeInfo.isBalanced && rightSubtreeInfo.isBalanced &&
		abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1

	// Calculate the height of the current tree by taking the maximum height of the left and right subtrees plus 1.
	height := max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1

	// Create and return the tree information.
	return TreeeInfo{
		isBalanced: isBalanced,
		height:     height,
	}
}

// max returns the maximum of two integers.
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// abs returns the absolute value of an integer.
func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func main() {
	// Create a binary tree
	tree := &BinaryTree{
		Value: 1,
		Left: &BinaryTree{
			Value: 2,
			Left: &BinaryTree{
				Value: 4,
			},
			Right: &BinaryTree{
				Value: 5,
			},
		},
		Right: &BinaryTree{
			Value: 3,
			Right: &BinaryTree{
				Value: 6,
				Left: &BinaryTree{
					Value: 7,
				},
			},
		},
	}

	// Check if the binary tree is height-balanced
	isBalanced := HeightBalancedBinaryTree(tree)

	// Output the result
	if isBalanced {
		fmt.Println("The binary tree is height-balanced.")
	} else {
		fmt.Println("The binary tree is not height-balanced.")
	}
}

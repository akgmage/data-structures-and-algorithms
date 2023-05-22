/*
  You're given the root node of a Binary Tree. Write a function that returns true  if this Binary Tree is height balanced and
  false if it isn't.
  Sample Input:
		  1
        /   \
       2     3
      / \     \
     4   5     6
              /
             7
	Output: False

	Explanation:

 	The code checks whether a given binary tree is height-balanced or not. A binary tree is height-balanced if
	the heights of its left and right subtrees differ by at most 1, and both the left and right subtrees
	are themselves height-balanced.

	The HeightBalancedBinaryTree function is the entry point of the code. It calls the getTreeInfo helper
	function to retrieve the tree information, including the balance status and height.

	The getTreeInfo function recursively calculates the tree information of the current node by
	obtaining the tree information of its left and right subtrees. It checks if both subtrees are
	balanced and calculates the height of the current tree.

	The balance status is determined by checking if the left and right subtrees are balanced and if their
	height difference is at most 1.

	The height of the current tree is the maximum height between the left and right subtrees plus 1.

	The max function returns the maximum of two integers, and the abs function returns the absolute value of an integer.
	These helper functions are used in the main logic of the code.

	Overall, the code efficiently determines whether a binary tree is height-balanced by recursively calculating the tree information and checking the balance status based on height differences.

	The time complexity of the `HeightBalancedBinaryTree` function, which calls the `getTreeInfo` helper function, is O(n), where n is the number of nodes in the binary tree.
	This is because the function traverses each node once in a depth-first manner, calculating the tree information for each node.

	The space complexity is O(h), where h is the height of the binary tree. This is because the recursive calls consume memory on the call
	stack proportional to the height of the tree. In the worst case, for a skewed tree where the height is equal to the number of nodes,
	the space complexity would be O(n).

	However, in a balanced binary tree, the height is logarithmic in the number of nodes, resulting in a space complexity of O(log n).

	Additionally, the `max` and `abs` helper functions have constant time complexity as they perform simple
	mathematical operations on two integers. They do not depend on the size of the tree.

	Overall, the time complexity is O(n) and the space complexity is O(h) or O(log n) in the case of a
	balanced binary tree.

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
		abs(leftSubtreeInfo.height-rightSubtreeInfo.height) <= 1

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

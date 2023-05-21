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

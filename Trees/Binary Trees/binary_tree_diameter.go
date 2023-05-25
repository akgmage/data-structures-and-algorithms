/*
	Write a function that takes in a Binary Tree and returns its diameter. The diameter of a binary tree
	is defined as the length of its longest path, even if that path doesn't pass through the root of the tree.

	Sample Input :
	          1
            /   \
           3     2
         /   \
        7     4
       /       \
      8         5
     /           \
    9             6
	Output: 6
	Diameter being 9 -> 8 -> 7 -> 3 -> 4 -> 5 -> 6
*/
package main

// This is an input class. Do not edit.
type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

type TreeInfo struct {
	height   int
	diameter int
}

// Calculates the diameter of a binary tree.
func BinaryTreeDiameter(tree *BinaryTree) int {
	return getTreeInfo(tree).diameter
}

// Recursively calculates the height and diameter of the binary tree.
func getTreeInfo(tree *BinaryTree) TreeInfo {
	// Base case: If the tree is nil, return height 0 and diameter 0.
	if tree == nil {
		return TreeInfo{0, 0}
	}

	// Recursively calculate the height and diameter of the left and right subtrees.
	leftTreeInfo := getTreeInfo(tree.Left)
	rightTreeInfo := getTreeInfo(tree.Right)

	// Calculate the longest path passing through the root node.
	longestPathThroughRoot := leftTreeInfo.height + rightTreeInfo.height

	// Calculate the maximum diameter seen so far.
	maxDiameterSoFar := max(leftTreeInfo.diameter, rightTreeInfo.diameter)

	// Calculate the current diameter, which is the maximum among the longest path through root and max diameter so far.
	currentDiameter := max(longestPathThroughRoot, maxDiameterSoFar)

	// Calculate the current height, which is the maximum height among the left and right subtrees plus 1.
	currentHeight := 1 + max(leftTreeInfo.height, rightTreeInfo.height)

	// Return the current height and diameter as the tree information.
	return TreeInfo{currentHeight, currentDiameter}
}

// Returns the maximum of two integers.
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

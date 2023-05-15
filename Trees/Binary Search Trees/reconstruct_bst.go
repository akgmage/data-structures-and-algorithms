package main

import "math"

// BST represents a binary search tree node.
type BST struct {
	Value int
	Left  *BST
	Right *BST
}

// Approach 1: Time complexity O(n^2) Space O(n), where n is length of input array
// ReconstructBst takes a slice of integers representing the pre-order traversal of a BST and returns the reconstructed BST.
func ReconstructBst(preOrderTraversalValues []int) *BST {
	// Base case: If the pre-order traversal is empty, return nil indicating an empty tree.
	if len(preOrderTraversalValues) == 0 {
		return nil
	}

	// Get the current value from the pre-order traversal values.
	currentVal := preOrderTraversalValues[0]

	// Find the index where the right subtree starts by searching for the first value greater than or equal to the current value.
	rightSubTreeRootIdx := len(preOrderTraversalValues)
	for i := 1; i < len(preOrderTraversalValues); i++ {
		value := preOrderTraversalValues[i]
		if value >= currentVal {
			rightSubTreeRootIdx = i
			break
		}
	}

	// Recursively reconstruct the left and right subtrees by calling the ReconstructBst function on the appropriate sub-arrays.
	leftSubTree := ReconstructBst(preOrderTraversalValues[1:rightSubTreeRootIdx])
	rightSubTree := ReconstructBst(preOrderTraversalValues[rightSubTreeRootIdx:])

	// Create a new BST node with the current value and the reconstructed left and right subtrees.
	return &BST{Value: currentVal, Left: leftSubTree, Right: rightSubTree}
}


// Approach 2: Time complexity O(n) Space O(n), where n is length of input array

// treeInfo is a helper struct to keep track of the current root index during the reconstruction process.
type treeInfo struct {
	rootIdx int
}

// ReconstructBst takes a slice of integers representing the pre-order traversal of a BST and returns the reconstructed BST.
func ReconstructBst2(preOrderTraversalValues []int) *BST {
	// Create a treeInfo struct to keep track of the current root index.
	treeInfo := &treeInfo{rootIdx: 0}

	// Call the helper function to reconstruct the BST from the given range and return the result.
	return reconstructBSTFromRange(math.MinInt32, math.MaxInt32, preOrderTraversalValues, treeInfo)
}

// reconstructBSTFromRange reconstructs the BST recursively within the given range using the pre-order traversal values.
func reconstructBSTFromRange(lowerBound, upperBound int, preOrderTraversalValues []int, currentSubtreeInfo *treeInfo) *BST {
	// Check if the root index has reached the end of the pre-order traversal values. If so, return nil indicating an empty subtree.
	if currentSubtreeInfo.rootIdx == len(preOrderTraversalValues) {
		return nil
	}

	// Get the value of the current root from the pre-order traversal values.
	rootValue := preOrderTraversalValues[currentSubtreeInfo.rootIdx]

	// Check if the root value is out of the valid range defined by the lower and upper bounds. If so, return nil indicating an invalid subtree.
	if rootValue < lowerBound || rootValue >= upperBound {
		return nil
	}

	// Increment the root index to move to the next element in the pre-order traversal values.
	currentSubtreeInfo.rootIdx++

	// Recursively reconstruct the left subtree within the range (lowerBound, rootValue) using the updated root index.
	leftSubtree := reconstructBSTFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubtreeInfo)

	// Recursively reconstruct the right subtree within the range (rootValue, upperBound) using the updated root index.
	rightSubtree := reconstructBSTFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubtreeInfo)

	// Create a new BST node with the current root value and the reconstructed left and right subtrees.
	return &BST{Value: rootValue, Left: leftSubtree, Right: rightSubtree}
}

/*
	Reconstruct BST
	The pre-order traversal of a Binary Tree is a traversal technique that starts at the tree's root node and visits nodes in the following order:
		Current Node
		Left Subtree
		Right Subtree

  	Given a non-empty array of integers representing the pre-order traversal of a Binary Search Tree (BST),
	write a function that creates the relevant BST and returns its root node.

    The input array will contain the values of BST nodes in the order in which these nodes would be visited with a pre-order traversal.

	Sample Input: [10, 4, 2, 1, 5, 17, 19, 18]
	Sample Output:
	    10
      /    \
     4      17
   /   \      \
  2     5     19
 /           /
1           18

	Explanation:

	Approach 1:

	The ReconstructBst function takes a slice preOrderTraversalValues which represents the pre-order traversal of a binary search tree.
	It reconstructs the BST using a recursive approach. Here's how the algorithm works:

	The base case is defined when the preOrderTraversalValues slice is empty, in which case it returns nil indicating an empty tree.

	The first element in the preOrderTraversalValues slice represents the current node value of the BST.

	The algorithm finds the index (rightSubTreeRootIdx) where the right subtree starts by iterating over the remaining elements in
	the preOrderTraversalValues slice and finding the first value greater than or equal to the current value.

	It recursively calls ReconstructBst on the sub-array representing the left subtree (preOrderTraversalValues[1:rightSubTreeRootIdx])
	to reconstruct the left subtree.

	It recursively calls ReconstructBst on the sub-array representing the right subtree (preOrderTraversalValues[rightSubTreeRootIdx:])
	to reconstruct the right subtree.

	Finally, it creates a new BST node with the current value, the reconstructed left subtree, and the reconstructed right subtree,
	and returns the node.

	The algorithm builds the BST in a top-down manner by dividing the pre-order traversal values into left and right subtrees.
	It constructs the left subtree first and then the right subtree.

	The time complexity of the algorithm is O(n^2) in the worst case, where n is the number of nodes in the BST.


	******************************************************************************************

	Approach 2:

	The ReconstructBst function takes a slice preOrderTraversalValues which represents the pre-order traversal of a binary search tree.
	It reconstructs the BST using a range-based approach. Here's how the algorithm works:

	The ReconstructBst function initializes a treeInfo struct to keep track of the current root index.

	The ReconstructBst function calls the reconstructBSTFromRange helper function, passing the minimum and maximum integer values
	as the initial range, the pre-order traversal values, and the treeInfo struct.

	The reconstructBSTFromRange function first checks if the current root index has reached the end of the pre-order traversal values.
	If so, it returns nil indicating an empty subtree.

	It retrieves the value of the current root from the pre-order traversal values.

	It checks if the root value is outside the valid range defined by the lower and upper bounds. If so, it returns

	The time complexity of the ReconstructBst function is O(n), where n is the number of nodes in the reconstructed BST.
	This is because the function processes each node exactly once.

	The space complexity of the ReconstructBst function is O(n), where n is the number of nodes in the reconstructed BST.
	This is because the function creates BST nodes and recursively calls itself to construct the left and right subtrees.
	The space complexity is determined by the height of the BST, which can be at most n in the worst case for a skewed BST.
*/
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

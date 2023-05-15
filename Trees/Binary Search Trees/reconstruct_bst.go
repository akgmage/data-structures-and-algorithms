package main

// BST represents a binary search tree node.
type BST struct {
	Value int
	Left  *BST
	Right *BST
}

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

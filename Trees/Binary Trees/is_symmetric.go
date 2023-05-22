package main

// This is an input class. Do not edit.
type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

// Approach 1: Recursive Approach
// SymmetricalTree checks if a binary tree is symmetrical.
func SymmetricalTreerecursive(tree *BinaryTree) bool {
	// Call the helper function to check if the left and right subtrees are mirrored.
	return treesAreMirrored(tree.Left, tree.Right)
}

// treesAreMirrored checks if two binary trees are mirrored.
func treesAreMirrored(left, right *BinaryTree) bool {
	// Base case: If both left and right trees are non-nil and have the same value,
	// recursively check if their subtrees are mirrored.
	if left != nil && right != nil && left.Value == right.Value {
		return treesAreMirrored(left.Left, right.Right) && treesAreMirrored(left.Right, right.Left)
	}

	// If either left or right tree is nil or their values are not equal, they are not mirrored.
	// Also, if both left and right trees are nil, they are considered mirrored.
	return left == right
}

/*  Explanation:

	The code snippet defines a function SymmetricalTree that checks if a binary tree is symmetrical. 
	The binary tree is represented by the BinaryTree struct, which has a Value field and pointers to 
	its left and right child nodes.

	The function uses two stacks, stackLeft and stackRight, to perform a mirror traversal of the 
	left and right subtrees of the input tree. It starts by pushing the left child of the root 
	node onto stackLeft and the right child of the root node onto stackRight.

	The function then enters a loop that continues until the stackLeft is empty. In each iteration 
	of the loop, it pops the top nodes from stackLeft and stackRight, assigning them to variables 
	left and right, respectively.

	If both left and right are nil, it means the corresponding subtrees are symmetric, so the loop 
	continues to the next iteration.

	If either left or right is nil, or their values are not equal, it means the tree is not symmetric, 
	and the function returns false.

	Otherwise, it pushes the left child of left and the right child of right onto stackLeft and stackRight, 
	respectively, in reverse order. This ensures that the subsequent nodes popped from the stacks are 
	compared as mirror images.

	Once the loop is completed, and no asymmetry has been detected, the function returns true, indicating 
	that the binary tree is symmetric.

	The time complexity of this algorithm is O(n), where n is the number of nodes in the binary tree, as 
	it traverses each node once. The space complexity is O(max(d, h)), where d is the maximum width of 
	the tree (number of nodes at the widest level) and h is the height of the tree. The space complexity 
	depends on the maximum number of nodes stored in the stacks during the traversal.
*/

// Approach 2: Iterative Approach using Stack
func SymmetricalTreeIterative(tree *BinaryTree) bool {
	stackLeft := []*BinaryTree{tree.Left}   // Initialize stackLeft with the left child of the root node
	stackRight := []*BinaryTree{tree.Right} // Initialize stackRight with the right child of the root node

	// Perform mirror traversal of the left and right subtrees
	for len(stackLeft) > 0 {
		var left, right *BinaryTree
		left, stackLeft = stackLeft[len(stackLeft)-1], stackLeft[:len(stackLeft)-1]       // Pop the top node from stackLeft
		right, stackRight = stackRight[len(stackRight)-1], stackRight[:len(stackRight)-1] // Pop the top node from stackRight

		if left == nil && right == nil {
			continue // Both left and right subtrees are symmetric, continue to the next iteration
		}

		if left == nil || right == nil || left.Value != right.Value {
			return false // Asymmetry detected, tree is not symmetric
		}

		// Push the children of left and right onto the respective stacks in reverse order
		stackLeft = append(stackLeft, left.Left, left.Right)
		stackRight = append(stackRight, right.Right, right.Left)
	}

	return true // Tree is symmetric
}
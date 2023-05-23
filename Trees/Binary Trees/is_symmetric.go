/*
  Write a function that takes in a Binary Tree and returns if that tree is symmetrical. A tree is symmetrical 
  if the left and right subtrees are mirror images of each other.
*/
package main

// This is an input class. Do not edit.
type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}
/*
The code consists of two functions. The SymmetricalTree function serves as an entry point and checks if the 
binary tree is symmetrical by calling the treesAreMirrored helper function with the left and right subtrees 
of the root node.

The treesAreMirrored function is a recursive helper function that checks if two binary trees are mirrored. 
It uses a bottom-up approach to compare corresponding nodes of the left and right subtrees. 

The function performs the following steps:

	1. Base case: If both the left and right trees are non-nil and have the same value, recursively check if 
	their respective subtrees are mirrored by calling treesAreMirrored with the left subtree's left and 
	the right subtree's right children, as well as the left subtree's right and the right subtree's left children.

	2. If either the left or right tree is nil or their values are not equal, they are not mirrored, and the function returns false.

	3. If both the left and right trees are nil, they are considered mirrored, and the function returns true.
	
	The recursive nature of the treesAreMirrored function allows it to traverse and compare corresponding nodes 
	in a symmetrical manner. If the function successfully reaches the base case for all nodes, it indicates 
	that the binary tree is symmetrical.

	Overall, the code leverages recursion and the concept of mirror images to determine if a binary tree is symmetrical or not.
	The time and space complexity of the code snippet can be analyzed as follows:

	Time Complexity:
	The time complexity of the SymmetricalTree function primarily depends on the size of the binary tree. 
	In the worst case, where the tree is symmetric, the function needs to traverse all the nodes of the tree once.

	Let's assume there are 'n' nodes in the tree. In the worst case, the function will visit each node exactly once. 
	Therefore, the time complexity is O(n), where 'n' is the number of nodes in the binary tree.

	Space Complexity:
	The space complexity is determined by the recursive calls and the stack space used during the recursion.

	In the worst case, when the binary tree is highly unbalanced and resembles a linked list, the depth of the 
	recursion can be 'n' (the number of nodes in the tree). This means that the space required on the function 
	call stack will be O(n).

	Additionally, the space complexity also includes the space used to store the function arguments and local variables. 
	However, as these are constant-sized values (pointers), they don't contribute significantly to the overall space complexity.

	Therefore, the overall space complexity is O(n), where 'n' is the number of nodes in the binary tree, considering the worst-case scenario.

	In summary, the time complexity is O(n), and the space complexity is O(n), where 'n' is the number of nodes in the binary tree.
*/
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
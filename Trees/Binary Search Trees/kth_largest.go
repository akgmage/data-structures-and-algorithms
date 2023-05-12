// Kth largest in BST
package main

// Approach 1: Using Brute Force
// Since Inorder traversal of BSt always comes in sorted order, we can directly access kth from end
type BST struct {
	Value int

	Left  *BST
	Right *BST
}

func FindKthLargestValueInBst(tree *BST, k int) int {
	sortedValues := make([]int, 0)
    inOrderTraverse(tree, &sortedValues)
	return sortedValues[len(sortedValues) - k]
}

func inOrderTraverse(tree *BST, sortedValues *[]int) {
    if tree.Left != nil {
        inOrderTraverse(tree.Left, sortedValues)
    }
    *sortedValues = append(*sortedValues, tree.Value)
    if tree.Right != nil {
        inOrderTraverse(tree.Right, sortedValues)
    }
}    


// Approach 2: Using Reverse InOrder Traversal      
/*
	The given code implements a function to find the Kth largest value in a Binary Search Tree (BST). Here's how it works:

	1. The `BST` struct represents a node in the BST, with a `Value` field and pointers to the left and right child nodes.

	2. The `treeInfo` struct is a helper struct used to store information during the traversal of the BST. It contains two fields: `numberOfNodesVisited` to keep track of the number of nodes visited, and `latestVisitedNodeValue` to store the value of the latest visited node.

	3. The `FindKthLargestValueInBst` function takes the root of the BST and the value of K as input and returns the Kth largest value in the BST.

	4. Inside the `FindKthLargestValueInBst` function, a `treeInfo` instance is created to track the traversal progress.

	5. The `reverseInOrderTraverse` function is called to perform a reverse in-order traversal of the BST. It starts from the right child, then visits the current node, and finally visits the left child.

	6. In the `reverseInOrderTraverse` function, the base case is checked: if the current node is `nil` or the desired Kth largest value has already been found (i.e., `numberOfNodesVisited` is equal to K), the function returns.

	7. The `reverseInOrderTraverse` function is recursively called on the right child node, which traverses the BST in descending order.

	8. After the right subtree is traversed, the function checks if `numberOfNodesVisited` is still less than K. If so, it increments `numberOfNodesVisited`, assigns the current node's value to `latestVisitedNodeValue`, and recursively calls the function on the left child node.

	9. The reverse in-order traversal ensures that the largest values are visited first, so when `numberOfNodesVisited` reaches K, the value stored in `latestVisitedNodeValue` will be the Kth largest value in the BST.

	10. Finally, the Kth largest value is returned by the `FindKthLargestValueInBst` function.

	The code efficiently finds the Kth largest value in a BST by performing a reverse in-order traversal, keeping track of the 
	number of visited nodes and the latest visited node value. 
	
	The time complexity of the algorithm is O(H + K), where H is the height of the BST and K is the input value.
	
	The space complexity of the code is O(h), where h is the height of the BST.
	During the execution of the FindKthLargestValueInBst function, the space usage is primarily determined by the recursive 
	calls to the reverseInOrderTraverse function. Each recursive call adds a new frame to the call stack, 
	consuming additional memory.

	In the worst case scenario, where the BST is skewed and has a height of h (resembling a linked list), the space 
	complexity will be O(h). This is because the function will make h recursive calls before reaching the base case.

	However, in a balanced BST where the height is log(N), where N is the number of nodes in the tree, the space 
	complexity will be O(log(N)).

	It's important to note that the space complexity only accounts for the additional space used by the recursive calls 
	and the call stack. The space required to store the BST itself is not considered in this analysis as it is part of 
	the input data.

*/         
// Helper struct to store traversal information
type treeInfo struct {
	numberOfNodesVisited   int
	latestVisitedNodeValue int
}

// FindKthLargestValueInBst finds the Kth largest value in the BST
func FindKthLargestValueInBst2(tree *BST, k int) int {
	// Create treeInfo to track traversal progress
	treeInfo := treeInfo{0, -1}
	reverseInOrderTraverse(tree, k, &treeInfo)
	return treeInfo.latestVisitedNodeValue
}

// reverseInOrderTraverse performs reverse in-order traversal of the BST
func reverseInOrderTraverse(tree *BST, k int, treeInfo *treeInfo) {
	// Base case: if current node is nil or Kth largest value found, return
	if tree == nil || treeInfo.numberOfNodesVisited == k {
		return
	}

	// Traverse the right subtree
	reverseInOrderTraverse(tree.Right, k, treeInfo)

	// Check if Kth largest value has been found
	if treeInfo.numberOfNodesVisited < k {
		// Increment the count of visited nodes and update the latest visited node value
		treeInfo.numberOfNodesVisited++
		treeInfo.latestVisitedNodeValue = tree.Value

		// Traverse the left subtree
		reverseInOrderTraverse(tree.Left, k, treeInfo)
	}
}
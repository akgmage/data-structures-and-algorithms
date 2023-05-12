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
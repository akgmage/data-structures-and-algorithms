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

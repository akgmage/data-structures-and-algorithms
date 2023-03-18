// Branch Sums
package main

type BinaryTree struct {
	Value int
	Left  *BinaryTree
	Right *BinaryTree
}

func BranchSums(root *BinaryTree) []int {
	sums := []int{}
    calculateBranchSums(root, 0, &sums)
    return sums
}

func calculateBranchSums(node *BinaryTree, runningSum int, sums *[]int) {
    if node == nil {
        return
    }
    runningSum += node.Value
    if node.Left == nil && node.Right == nil {
        *sums = append(*sums, runningSum)
    }
    calculateBranchSums(node.Left, runningSum, sums)
    calculateBranchSums(node.Right, runningSum, sums)
}
/*
	Write a function that takes in a Binary Tree and returns a list of its branch
	sums ordered from leftmost branch sum to rightmost branch sum.


	A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
	branch is a path of nodes in a tree that starts at the root node and ends at
	any leaf node.

	Sample Input
	       1
        /     \
       2       3
     /   \    /  \
    4     5  6    7
  /   \  /
 8    9 10

 	Output:[15, 16, 18, 10, 11]

*/

/*
	As you recursively traverse the tree, if you reach a leaf node (a node with no "left" or "right" Binary Tree nodes),
	add the relevant running sum that you've calculated to a list of sums (which you'll also have to pass to the recursive
	function). If you reach a node that isn't a leaf node, keep recursively traversing its children nodes,
	passing the correctly updated running sum to them.

	Time and Space complexity : O(n) time | O(n) space - where n is the number of nodes in the Binary Tree
*/
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
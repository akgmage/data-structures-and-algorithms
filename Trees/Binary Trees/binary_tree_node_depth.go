/*
  The distance between a node in a Binary Tree and the tree's root is called the
  node's depth.

  Write a function that takes in a Binary Tree and returns the sum of its nodes'
  depths.

  Sample Input:
          1
       /     \
      2       3
    /   \   /   \
   4     5 6     7
 /   \
8     9
  Output: 16
*/

/*
	The depth of any node in the tree is equal to the depth of its parent node plus 1.
	By starting at the root node whose depth is 0, you can pass down to every node in
	the tree its respective depth, and you can implement the algorithm that does this
	and that sums up all of the depths either recursively or iteratively.

	Time and Space complexity
	Average case: when the tree is balanced
	O(n) time | O(h) space - where n is the number of nodes in the Binary Tree and h is the height of the Binary Tree
*/
package main

type BinaryTree struct {
	Value       int
	Left, Right *BinaryTree
}

func NodeDepths(root *BinaryTree) int {
	return nodeDepthHelper(root, 0)
}

func nodeDepthHelper(root *BinaryTree, depth int) int {
    if root == nil {
        return 0
    }
    return depth + nodeDepthHelper(root.Left, depth + 1) + nodeDepthHelper(root.Right, depth + 1)
}
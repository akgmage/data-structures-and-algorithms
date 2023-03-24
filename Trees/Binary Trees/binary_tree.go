/*
	A tree is called binary tree if each node has zero child, one child or two children. Empty tree is also a valid binary
	tree. We can visualize a binary tree as consisting of a root and two disjoint binary trees, called the left and right
	subtrees of the root.

	Types of Binary Trees
	1) Strict Binary Tree: A binary tree is called  strict binary tree if each node has exactly two children or no children.
	2) Full Binary Tree: A binary tree is called full binary tree if each node has exactly two children and all leaf nodes
	   are at the same level.
	3) Complete Binary Tree: Before defining the complete binary tree, let us assume that the height of the binary tree
	   is ℎ. In complete binary trees, if we give numbering for the nodes by starting at the root (let us say the root node
	   has 1) then we get a complete sequence from 1 to the number of nodes in the tree. While traversing we should give
	   numbering for nil pointers also. A binary tree is called complete binary tree if all leaf nodes are at height ℎ or ℎ − 1
	   and also without any missing number in the sequence.

	              1
                /   \
               2      3
              / \    / \
             4   5  6   7
*/
package main

import (
	"fmt"
	"math/rand"
)

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
}
// NewBinaryTree returns a new, random binary tree
func NewBinaryTree(n, k int) *BinaryTreeNode {
	var root * BinaryTreeNode
	for _, v := range rand.Perm(n) {
		root = Insert(root, (1 + v) * k)
	}
	return root
}
// Insert, inserts an element in binary tree 
func Insert(root *BinaryTreeNode, v int) *BinaryTreeNode {
	if root == nil {
		// fmt.Printf("%d root", v)
		return &BinaryTreeNode{nil, v, nil}
	}
	// data less than root of data the insert in left subtree
	if v < root.data {
		// fmt.Printf("%d left\n", v)
		root.left = Insert(root.left, v)
		return root
	}
	// data greater than or equal to root of data the insert in right subtree
	// fmt.Printf("%d right\n", v)
	root.right = Insert(root.right, v)
	return root
}

// Pre-order traversal
// Preorder traversal is defined as follows:
// 1 Visit the root.
// 2 Traverse the left subtree in Preorder.
// 3 Traverse the right subtree in Preorder.
// Time Complexity: O(n). Space Complexity: O(n).
// The nodes of tree would be visited in the order: 1 2 4 5 3 6 7
func PreOrder(root *BinaryTreeNode) {

	if root == nil {
		return
	}
	fmt.Printf("%d ", root.data)
	PreOrder(root.left)
	PreOrder(root.right)
}

// Inorder traversal is defined as follows:
// 1 Traverse the left subtree in Inorder.
// 2 Visit the root.
// 3 Traverse the right subtree in Inorder.
// Time Complexity: O(n). Space Complexity: O(n).
// The nodes of tree would be visited in the order: 4 2 5 1 6 3 7
func InOrder(root *BinaryTreeNode) {
	if root == nil {
		return
	}
	InOrder(root.left)
	fmt.Printf("%d", root.data)
	InOrder(root.right)
}

// PostOrder traversal is defined as follows:
// 1 Traverse the left subtree in PostOrder.
// 2 Traverse the right subtree in PostOrder.
// 3 Visit the root.
// The nodes of the tree would be visited in the order: 4 5 2 6 7 3 1
func PostOrder(root *BinaryTreeNode) {
	if root == nil {
		return
	}
	PostOrder(root.left)
	PostOrder(root.right)
	fmt.Printf("%d", root.data)
}



func main() {
	t1 := NewBinaryTree(10, 1)
	PreOrder(t1)
	fmt.Println()
	InOrder(t1)
	fmt.Println()
	PostOrder(t1)
	fmt.Println()
}
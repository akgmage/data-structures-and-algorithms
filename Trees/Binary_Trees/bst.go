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

// Pre-order traversal

func PreOrder(root *BinaryTreeNode) {
	if root == nil {
		return
	}
	fmt.Printf("%d ", root.data)
	PreOrder(root.left)
	PreOrder(root.right)
}

func NewBinaryTree(n, k int) *BinaryTreeNode {
	var root * BinaryTreeNode

	for _, v := range rand.Perm(n) {
		root = insert(root, (1 + v) * k)
	}
}


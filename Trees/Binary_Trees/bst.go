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
	return root
}

func insert(root * BinaryTreeNode, v int) *BinaryTreeNode {
	if root == nil {
		fmt.Printf("%d root", v)
		return &BinaryTreeNode{nil, v, nil}
	}
	if v < root.data {
		fmt.Printf("%d left\n", v)
		root.left = insert(root.left, v)
		return root
	}
	fmt.Printf("%d right\n", v)
	root.right = insert(root.right, v)
	return root
}

func main() {
	t1 := NewBinaryTree(10, 1)
	PreOrder(t1)
	fmt.Println()
}
// Binary Search tree implementation
package main

import (
	"fmt"
	"math/rand"
)

type BSTNode struct {
	left *BSTNode
	data int
	right *BSTNode
}

func ConstructBST(n, k int) *BSTNode {
	var root *BSTNode
	for _, v := range rand.Perm(n) {
		root = Insert(root, (1 + v) * k)
	}
	return root
}

func Insert(root *BSTNode, data int) *BSTNode {
	if root == nil {
		return &BSTNode{nil, data, nil}
	}
	if data < root.data {
		root.left = Insert(root.left, data)
		return root
	}
	root.right = Insert(root.right, data)
	return root
}

func SearchElement(root *BSTNode, data int) *BSTNode {
	if root == nil {
		return root
	}
	if data < root.data {
		return SearchElement(root.left, data)
	} else if data > root.data {
		return SearchElement(root.right, data)
	}
	return root
}

func main() {
	tree := ConstructBST(10, 1)
	fmt.Println(tree)
	fmt.Println(SearchElement(tree, 5))
}
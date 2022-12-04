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

func SearchElementRecursive(root *BSTNode, data int) *BSTNode {
	if root == nil {
		return root
	}
	if data < root.data {
		return SearchElementRecursive(root.left, data)
	} else if data > root.data {
		return SearchElementRecursive(root.right, data)
	}
	return root
}

func SearchElementNonRecursive(root *BSTNode, data int) *BSTNode {
	if root == nil {
		return root
	}
	for root != nil {
		if data == root.data {
			return root
		} else if data < root.data {
			root = root.left
		} else {
			root = root.right
		}
	}
	return nil
}

func main() {
	tree := ConstructBST(10, 1)
	fmt.Println(tree)
	fmt.Println(SearchElementRecursive(tree, 5))
	fmt.Println(SearchElementNonRecursive(tree, 5))
}
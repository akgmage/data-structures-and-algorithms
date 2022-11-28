package main

import (
	"fmt"
	"math"
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

func InOrder(root *BinaryTreeNode) {
	if root == nil {
		return
	}
	InOrder(root.left)
	fmt.Printf("%d", root.data)
	InOrder(root.right)
}

func PostOrder(root *BinaryTreeNode) {
	if root == nil {
		return
	}
	PostOrder(root.left)
	PostOrder(root.right)
	fmt.Printf("%d", root.data)
}

func NewBinaryTree(n, k int) *BinaryTreeNode {
	var root * BinaryTreeNode
	for _, v := range rand.Perm(n) {
		root = insert(root, (1 + v) * k)
	}
	return root
}
// Time Complexity: O(n). Space Complexity: O(n).
// Approach: find maximum in left sub tree, find maximum in right subtree
// compare them with root data and select the one which is giving the max value
// recursive appraoch
func FindMax(root *BinaryTreeNode) int {
	max := math.MinInt32
	if root != nil {
		rootVal := root.data
		left := FindMax(root.left)
		right := FindMax(root.right)
		if left > max {
			max = left
		} else {
			max = right
		}
		if rootVal > max {
			max = rootVal
		}
	}
	return max
}
// Time Complexity: O(n). Space Complexity: O(n).
// Approach: recurse down the tree choose left or right branch by comparing data with each node's data
func SearchAnElement(root *BinaryTreeNode, data int) *BinaryTreeNode {
	// base case empty tree
	if root == nil {
		return root
	} else {
		// if found return root
		if data == root.data {
			return root
		} else {
			// recurse down correct subtree
			temp := SearchAnElement(root.left, data)
			if temp != nil {
				return temp
			} else {
				return SearchAnElement(root.right, data)
			}
		}
	}
}
// Time Complexity: O(n). Space Complexity: O(n).
// Approach: calculate the size of left and right subtree recursively
// add 1 (curr node) and return to its parent
func Size(root *BinaryTreeNode) int {
	if root == nil {
		return 0
	} else {
		return Size(root.left) + 1 + Size(root.right)
	}
}

func insert(root * BinaryTreeNode, v int) *BinaryTreeNode {
	if root == nil {
		// fmt.Printf("%d root", v)
		return &BinaryTreeNode{nil, v, nil}
	}
	if v < root.data {
		// fmt.Printf("%d left\n", v)
		root.left = insert(root.left, v)
		return root
	}
	// fmt.Printf("%d right\n", v)
	root.right = insert(root.right, v)
	return root
}

func main() {
	t1 := NewBinaryTree(10, 1)
	PreOrder(t1)
	fmt.Println()
	msg := FindMax(t1)
	fmt.Println(msg)
	res := SearchAnElement(t1, 1)
	fmt.Println(res)
	size := Size(t1)
	fmt.Println(size)
}
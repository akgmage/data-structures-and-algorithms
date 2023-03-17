// Find max in Binary tree
package main

import "math"

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
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
// Approach: Using level order traversal observe the elements data
func FindMaxWithoutRecursion(root *BinaryTreeNode) int {
	max := math.MinInt32
	if root == nil {
		return max
	}
	queue := []*BinaryTreeNode{root}
	for len(queue) > 0 {
		qlen := len(queue)
		for i := 0; i < qlen; i++ {
			node := queue[0]
			if node.data > max {
				max = node.data
			}
			queue = queue[1:]
			if node.left != nil {
				queue = append(queue, node.left)
			}
			if node.right != nil {
				queue = append(queue, node.right)
			}
		}
	}
	return max
}
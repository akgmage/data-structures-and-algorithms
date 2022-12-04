/*
	Binary Search tree implementation
	In computer science, a binary search tree (BST), also called an ordered or sorted binary tree, is a rooted binary tree data structure
	with the key of each internal node being greater than all the keys in the respective node's left subtree and less than the ones
	in its right subtree. The time complexity of operations on the binary search tree is directly proportional to the height of the tree.

	The complexity analysis of BST shows that, on average, the insert, delete and search
	takes O(log n) fot n nodes. In the worst case, they degrade to that of a singly linked list O(n).

	Source(https://en.wikipedia.org/wiki/Binary_search_tree)

	Opeartions on BST:
	1 Find/ Find Minimum / Find Maximum element in binary search trees
	2 Inserting an element in binary search trees
	3 Deleting an element from binary search trees

*/
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

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: start with root and keep moving left or right recursively
// if data we are searching is same as current node's data then return current node
// if data is less than node's data then resurse left, else recurse right
// if no data then it will return nil
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

// Time Complexity: O(n). Space Complexity: O(1).
// Approach: start with root and keep moving left or right
// if data we are searching is same as current node's data then return current node
// if data is less than node's data then resurse left, else recurse right
// if no data then it will return nil
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
// FindMIn: finds min element in BST,
// Approach :  start with root and keep moving left
// min element is the left most node in BST
// Time Complexity: O(n). Space Complexity: O(n).
func FindMinRecursive(root *BSTNode) *BSTNode {
	if root == nil {
		return nil
	} else if root.left == nil {
		return root
	} else {
		return FindMinRecursive(root.left)
	}
}

func FindMinNonRecursive(root *BSTNode) *BSTNode {
	if root == nil {
		return root
	}
	for root.left != nil {
		root = root.left
	}
	return root
}
func main() {
	tree := ConstructBST(10, 1)
	fmt.Println(tree)
	fmt.Println(SearchElementRecursive(tree, 5))
	fmt.Println(SearchElementNonRecursive(tree, 5))
	fmt.Println(FindMinRecursive(tree))
}
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
	"math"
	"math/rand"
)

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
}

func NewBinaryTree(n, k int) *BinaryTreeNode {
	var root * BinaryTreeNode
	for _, v := range rand.Perm(n) {
		root = insert(root, (1 + v) * k)
	}
	return root
}

func insert(root *BinaryTreeNode, v int) *BinaryTreeNode {
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

// Level order traversal is defined as follows:
// 1 Visit the root.
// 2 While traversing level 􀝈, keep all the elements at level 􀝈 + 1 in queue.
// 3 Go to the next level and visit all the nodes at that level.
// 4 Repeat this until all levels are completed.
// The nodes of the tree are visited in the order: [1] [2 3] [ 4 5 6 7]
func LevelOrder(root *BinaryTreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	var result [][]int
	queue := []*BinaryTreeNode{root}
	for len(queue) > 0 {
		qlen := len(queue)
		var level []int
		for i:= 0; i < qlen; i++ {
			node := queue[0]
			level = append(level, node.data)
			queue = queue[1:]
			if node.left != nil {
				queue = append(queue, node.left)
			}
			if node.right != nil {
				queue = append(queue, node.right)
			}
		}
	}
	return result
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
// Approach: using level order traversal we can solve this problem, check whether
// the root data is equal to the element we want to search
func SearchAnElementWithoutRecursion(root *BinaryTreeNode, data int) *BinaryTreeNode {
	if root == nil {
		return root
	}
	queue := []*BinaryTreeNode{root}
	for len(queue) > 0 {
		qlen := len(queue)
		for i := 0; i < qlen; i++ {
			node := queue[0]
			if data == node.data {
				return node
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
	return nil
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

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: use level order traversal and count nodes
func SizeWithoutUsingRecursion(root *BinaryTreeNode) int {
	if root == nil {
		return 0
	}
	var result int
	queue := []*BinaryTreeNode{root}
	for len(queue) > 0 {
		qlen := len(queue)
		//var level []int
		for i := 0; i < qlen; i++ {
			node := queue[0]
			result++
			//level = append(level, node.data)
			queue = queue[1:]
			if node.left != nil {
				queue = append(queue, node.left)
			}
			if node.right != nil {
				queue = append(queue, node.right)
			}
		}
	}
	return result
}

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: Recursively calculate height of left and right subtrees of a node 
// and assign height to the node as max of heights of two children + 1
func Height(root *BinaryTreeNode) int {
	if root == nil {
		return 0
	} else {
		// compute depth of each subtree
		leftHeight := Height(root.left)
		rightHeight := Height(root.right)
		if leftHeight > rightHeight {
			return leftHeight + 1
		} else {
			return rightHeight + 1
		}

	}
}

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: The inverse of an empty tree is an empty tree
// The inverse of a tree with root r, and subtrees right and left is a tree with
// root, whose right subtree is the inverse of left and whoose left subtree
// is the inverse of right
func InvertTree(root *BinaryTreeNode) *BinaryTreeNode {
	if root != nil {
		root.left, root.right = InvertTree(root.right), InvertTree(root.left)
	}
	return root
}

// Time Complexity: O(􀝊). Space Complexity: O(􀝊).
// Method2 : swap pointers
func InvertTree2(root *BinaryTreeNode) *BinaryTreeNode {
	if root == nil {
		return root
	}
	// swap the pointers in this node
	root.left, root.right = root.right, root.left
	InvertTree(root.left)
	InvertTree(root.right)
	return root
}

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: before deleting parent node, delete all its children nodes
// using post order traversal we can solve this problem 
func DeleteTree(root *BinaryTreeNode) *BinaryTreeNode {
	if root == nil {
		return nil
	}
	// deleet both subtrees
	root.left = DeleteTree(root.left)
	root.right = DeleteTree(root.right)
	// delete current node after deleting subtrees
	root = nil
	return root
}


// Time Complexity: O(n). Space Complexity: O(n).
// Approach: recurse both left and right subtree and check if the node doesn't have
// left and right children
func RemoveLeafNodes(root *BinaryTreeNode) *BinaryTreeNode {
	if root == nil {
		return root
	}
	// if it doesnt have left and right children then delete it
	if root.left == nil && root.right == nil {
		root = nil
		return root
	} else { // recurse to left and right subtree
		root.left = RemoveLeafNodes(root.left)
		root.right = RemoveLeafNodes(root.right)
	}
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
	size = SizeWithoutUsingRecursion(t1)
	fmt.Println("Size without recursion")
	fmt.Println(size)
	height := Height(t1)
	fmt.Println(height)
	invert := InvertTree(t1)
	fmt.Println(invert)
	deleteLeaf := RemoveLeafNodes(t1)
	fmt.Println(deleteLeaf)
	PreOrder(deleteLeaf)
}
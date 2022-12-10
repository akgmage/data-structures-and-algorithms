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
	"math"
	"math/rand"
)

type BSTNode struct {
	left *BSTNode
	data int
	right *BSTNode
}

// ConstructBST returns a new, random binary tree
func ConstructBST(n, k int) *BSTNode {
	var root *BSTNode
	for _, v := range rand.Perm(n) {
		root = Insert(root, (1 + v) * k)
	}
	return root
}

// Insert, inserts an element in binary tree
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

// FindMin: finds min element in BST,
// Approach:  start with root and keep moving left
// Min element is the left most node in BST
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

// FindMIn: finds max element in BST,
// Approach:  start with root and keep moving right
// Max element is the right most node in BST
// Time Complexity: O(n). Space Complexity: O(1).
func FindMinNonRecursive(root *BSTNode) *BSTNode {
	if root == nil {
		return root
	}
	for root.left != nil {
		root = root.left
	}
	return root
}

// FindMax: finds min element in BST,
// Approach:  start with root and keep moving left
// min element is the left most node in BST
// Time Complexity: O(n). Space Complexity: O(n).
func FindMaxRecursive(root *BSTNode) *BSTNode {
	if root == nil {
		return nil
	}
	if root.right == nil {
		return root
	}
	return FindMaxRecursive(root.right)
}

// FindMIn: finds max element in BST,
// Approach:  start with root and keep moving right
// Max element is the right most node in BST
// Time Complexity: O(n). Space Complexity: O(1).
func FindMaxNonRecursive(root *BSTNode) *BSTNode {
	if root == nil {
		return nil
	}
	for root.right != nil {
		root  = root.right
	}
	return root
}
func DeleteMin(root *BSTNode) *BSTNode{
	if root.left == nil {
		return root.right
	}
	root.left = DeleteMin(root.left)
	return root
}

// DeleteFromBST deleted given value from bst and doesn't break the node
// Time Complexity: O(n). Space Complexity: O(n).
func DeleteFromBST(root *BSTNode, data int) *BSTNode {
	if root == nil {
		return nil
	}
	// traverse left or right recursively until you find data
	if data < root.data {
		DeleteFromBST(root.left, data)
	} else if data > root.data {
		DeleteFromBST(root.right, data)
	} else {
		// straight forward conddition no child set root as nil and return root
		if root.right == nil && root.left == nil{
			fmt.Println("hit")
			root = nil
			return root
		}
		// if left is nil and right has children set root as root.right 
		if root.left == nil && root.right != nil {
			temp := root.right
			root = temp
			return root
		}
		// if right is nil and left has children set root as root.left
		if root.right == nil && root.left != nil {
			fmt.Println(" boom")
			temp := root.left
			root = temp
			return root 
		}
		// if both left and right have children
		// find min in the right sub tree, 
		// set root.data as minimum value you found you found in right sub tree
		// call DeleteFromBST and delete min value
		temp := FindMinNonRecursive(root.right)
		DeleteMin(root.right)
		root.data = temp.data
		root.right = DeleteFromBST(root.right, temp.data)
		
	}
	return root
}


// Pre-order traversal
// Preorder traversal is defined as follows:
// 1 Visit the root.
// 2 Traverse the left subtree in Preorder.
// 3 Traverse the right subtree in Preorder.
// Time Complexity: O(n). Space Complexity: O(n).
// The nodes of tree would be visited in the order: 1 2 4 5 3 6 7
func PreOrder(root *BSTNode) {
	if root == nil {
		return
	}
	fmt.Print(root.data)
	PreOrder(root.left)
	PreOrder(root.right)
}

func InOrder(root *BSTNode) {
	if root == nil {
		return
	}
	InOrder(root.left)
	fmt.Print(root.data)
	InOrder(root.right)
}
// IsBST: checks whether a given tree is a valid BST or not
// Time Complexity: O(n2). Space Complexity: O(n).
func IsBST(root *BSTNode) bool {
	if root == nil {
		return true
	}
	// if max on left tree is greater then root then return false
	max := FindMaxRecursive(root.left)
	if root.left != nil && max.data > root.data {
		return false
	}
	// if min on right tree is less then root then return false
	min := FindMinNonRecursive(root.right)
	if root.right != nil && min.data < root.data {
		return false
	}
	// recursively check if left or right is not a BST
	if !IsBST(root.left) || !IsBST(root.right) {
		return false
	}
	return true
}
// Time Complexity: O(n). Space Complexity: O(n).
func IsBSTOptimal(root *BSTNode, min, max int) bool {
	if root == nil {
		return true
	}
	return (
		root.data > min && 
		root.data < max && 
		IsBSTOptimal(root.left, min, root.data) &&  
		IsBSTOptimal(root.right, root.data, max))
}

// IsBSTInorder: Using Inorder traversal we can solve this problem 
// Inorder traversal gives us sorted values, while traversing the BST in inorder,
// at each node check the condition that its key value should be greater than 
// the key value of its previous visited node, initialize prev with minimum integer value
// Time Complexity: O(n). Space Complexity: O(n).
func IsBSTInorder(root *BSTNode, prev *int) bool {
	if root == nil {
		return true
	}
	if !IsBSTInorder(root.left, prev) {
		return false
	}
	// compare root value with prev visited value
	if root.data < *prev {
		return false
	}
	// set prev value as root's value
	*prev = root.data
	return IsBSTInorder(root.right, prev)
}

// Helper created balanced binary search tree
// also it ensures height is balanced
// Approach : Using Divide and Conquer strategy
// It is similar to binary seaarch algorithm 
func Helper(Arr []int, low int, high int) *BSTNode {
	if low > high {
		return nil
	}
	// middle element will form the root of BST
	mid := low + (high - low) / 2
	// create new node (allocate memory)
	node := new(BSTNode)
	// assign data to newly created node
	node.data = Arr[mid]
	// elements left from mid will form left sub tree
	node.left = Helper(Arr, low, mid - 1)
	// elements right from mid will form right sub tree
	node.right = Helper(Arr, mid + 1, high)
	return node
}

// Time Complexity: O(n). Space Complexity: O(n).
func ConvertSortedArrayToBST(Arr []int) *BSTNode {
	if Arr == nil {
		return nil
	}
	return Helper(Arr, 0, len(Arr)-1)
}

// Time Complexity: O(n). Space Complexity: O(1).
func kthSmallest(root *BSTNode, k int) *BSTNode {
	counter := 0
	return helperKthSmallest(root, k, &counter)
}

// Helper method to find kth smallest element
// Approach: Inorder traversal gives us sorted list , so we can determine kth smallest 
// element in tree easily
func helperKthSmallest(root *BSTNode, k int, counter *int) *BSTNode {
	if root == nil {
		return nil
	}
	left := helperKthSmallest(root.left, k, counter)
	if left != nil {
		return left
	}
	// while traversing the tree keep track of the number of elements visited
	*counter += 1
	if *counter == k {
		return root
	}
	return helperKthSmallest(root.right, k, counter)
}

// FloorInBST gives floor value of the supplied key in BST
// Floor of the key is the largest key in the BST 
// less than tor equal to the key 
// Time Complexity: O(n). Space Complexity: O(n).
func FloorInBST(root *BSTNode, key int) *BSTNode {
	if root == nil {
		return root
	}
	if key > root.data {
		r := FloorInBST(root.right, key)
		if r == nil {
			return root
		} else {
			return r
		}
	} else if key < root.data {
		return FloorInBST(root.left, key)
	} else {
		return root
	}
}

// CeilInBST gives ceil value of the supplied key in BST
// Ceil of the key is the smallest key in the BST 
// greater than tor equal to the key 
// Time Complexity: O(n). Space Complexity: O(n).
func CeilInBST(root *BSTNode, key int) *BSTNode {
	if root == nil {
		return root
	}
	if root.data == key {
		return root
	} else if root.data < key {
		return CeilInBST(root.right, key)
	} else {
		l := CeilInBST(root.left, key)
		if l != nil {
			return l
		}
	}
	return root
}

// RangePrintBST prints the value in trees which lies in range  from start and end
// Approach: Traverse in inorder, if key lie within range then print them
// Time Complexity: O(n). Space Complexity: O(n).
func RangePrintBST(root *BSTNode, start int, end int) {
	if root == nil {
		return
	}
	// look in left side
	if root.data >= start {
		RangePrintBST(root.left, start, end)
	}
	// if value lies within supplied range print them
	if root.data >= start && root.data <= end {
		fmt.Printf("%v ", root.data)
	}
	// look in right side
	if root.data <= end {
		RangePrintBST(root.right, start, end)
	}
}

// RangePrintQueueBST prints the value in trees which lies in range  
// from start and end using queue (level order traversal)
// Approach: while adding the elements to queue check for range
// Time Complexity: O(n). Space Complexity: O(n).
func RangePrintQueueBST(root *BSTNode, start, end int) {
	if root == nil {
		return
	}
	var result [][]int
	queue := []*BSTNode{root}
	for len(queue) > 0 {
		qlen := len(queue)
		var level []int
		for i := 0; i < qlen; i++ {
			node := queue[0]
			level = append(level, node.data)
			queue = queue[1:]
			// if data lies within range then print data
			if node.data >= start && node.data <= end {
				fmt.Printf("%v", node.data)
			}
			// append left node to queue
			if node.left != nil && node.data >= start {
				queue = append(queue, node.left)
			}
			// append right node to queue
			if node.right != nil && node.data <= end {
				queue = append(queue, node.right)
			}
		}
		result = append(result, level)
	}
}

// CountTrees: returns how many structurally unique BST's are possible
// Approach: Consider each value to be root, recursively find the size of the left and right
// subtrees. Let p be the root in BST with n nodes from 1 to n
// The left subtree has p - 1 nodes, right tree has n - p nodes.
func CountTrees(n int) int {
	if n <= 1 {
		return 1
	} else {
		sum := 0
		// iterate through all values that could be the root
		for root := 1; root <= n; root++ {
			left := CountTrees(root - 1)
			right := CountTrees(n - root)
			// number of possible trees withcurr root = left * right
			sum += left * right
		}
		return sum
	}
}

func main() {
	tree := ConstructBST(10, 1)
	fmt.Println(tree)
	fmt.Println(SearchElementRecursive(tree, 5))
	fmt.Println(SearchElementNonRecursive(tree, 5))
	fmt.Println(FindMinRecursive(tree))
	fmt.Println(FindMinNonRecursive(tree))
	fmt.Println(FindMaxRecursive(tree))
	fmt.Println(FindMaxNonRecursive(tree))
	PreOrder(tree)
	
	tree = DeleteFromBST(tree, 6)
	fmt.Println()
	PreOrder(tree)
	//fmt.Println(SearchElementRecursive(tree, 7))
	fmt.Print(IsBST(tree))
	fmt.Print(IsBSTOptimal(tree, math.MinInt32, math.MaxInt32))
	var prev = math.MinInt32
	fmt.Println(IsBSTInorder(tree, &prev))

	arr := []int {1, 2, 3, 4, 5 ,6}
	node := ConvertSortedArrayToBST(arr)
	InOrder(node)
	fmt.Println(kthSmallest(tree, 3))
	RangePrintBST(tree, 3, 7)
	RangePrintQueueBST(tree, 3, 7)
}
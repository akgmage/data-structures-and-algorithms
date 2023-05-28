// Search an element in Binary tree
package main

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
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
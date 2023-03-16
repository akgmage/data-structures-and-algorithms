package main

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
}

// Level order traversal is defined as follows:
// 1 Visit the root.
// 2 While traversing level 􀝈, keep all the elements at level 􀝈 + 1 in queue.
// 3 Go to the next level and visit all the nodes at that level.
// 4 Repeat this until all levels are completed.
// The nodes of the tree are visited in the order: [1] [2 3] [ 4 5 6 7]
// Time Complexity: O(n), Space Complexity: O(n) In the worst case, all the nodes on the entire last level could be in the queue.
func LevelOrder(root *BinaryTreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	// Data from each level is being returned as a separate list
	var result [][]int
	queue := []*BinaryTreeNode{root}
	for len(queue) > 0 {
		qlen := len(queue)
		var level []int
		for i:= 0; i < qlen; i++ {
			node := queue[0]
			level = append(level, node.data)
			queue = queue[1:]
			// if there are left children then append them in queue
			if node.left != nil {
				queue = append(queue, node.left)
			}
			// if there are right children then append them in queue
			if node.right != nil {
				queue = append(queue, node.right)
			}
		}
	}
	return result
}

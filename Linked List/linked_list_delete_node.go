/*
	We are given a pointer to a node (not the tail node) in a singly linked list. Delete that node from the
	linked list.
*/
package main

/*
	Approach:
	1. We can move the data from the next node into the current node
	2. Delete the next node.
*/
func deleteNode(node *ListNode) {
	temp = node.next
	node.data = node.next.data
	node.next = temp.next
	temp = nil
}
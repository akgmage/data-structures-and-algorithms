/*
	We are given a pointer to a node (not the tail node) in a singly linked list. Delete that node from the
	linked list.
*/
package main

func deleteNode(node *ListNode) {
	temp = node.next
	node.data = node.next.data
	node.next = temp.next
	temp = nil
}
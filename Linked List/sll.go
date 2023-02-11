/*
	The linked list consists of a series of structures called nodes. We can think of each node as a record. The first part
	of the record is a field that stores the data, and the second part of the record is a field that stores a pointer to a
	node. So, each node contains two fields: a data field and a next field which is a pointer used to link one node to
	the next node. Generally, "linked list" means a singly linked list. This list consists of a number of nodes in which
	each node has a pointer to the following element. The link of the last node in the list is nil, which indicates
	the end of the list.

	Basic Operations on a List
		--> Traversing the list
		--> Inserting an item in the list
		--> Deleting an item from the list
*/
package main

import "fmt"

// Linked list node contains a pointer to the next node as well as data.
// The generic behavior is achieved by marking the data field as type interface
type ListNode struct { // define a ListNode in a sll
	data interface{} // datum
	next *ListNode // pointer to next ListNode
}

type LinkedList struct {
	head *ListNode
	size int
}

func (ll *LinkedList) Display() error {
	if ll.head == nil {
		return fmt.Errorf("Display: List is empty")
	}
	current := ll.head
	for current != nil {
		fmt.Printf("%v->", current.data)
		current = current.next
	}
	fmt.Println()
	return nil
	
}
// Length: returns the linked list size
func (ll *LinkedList) Length() int {
	size := 0
	current := ll.head
	for current != nil {
		size++
		current = current.next
	}
	return size
}
// InsertAtBeginning: Update the next pointer of new node to point to the current head
// Update the head pointer to point to the new node
func (ll *LinkedList) InsertAtBeginning(data interface{}) {
	node := &ListNode{
		data: data,
	}
	// if there is no head then set new node as head
	if ll.head == nil {
		ll.head = node
	} else {
		node.next = ll.head
		ll.head = node
	}
	ll.size++
	return
}
// InsertAtEnd: We need to modify two next pointers, new node next pointer points to nil
// Last nodes next pointer points to the new node
func (ll *LinkedList) InsertAtEnd(data interface{}) {
	node := &ListNode{
		data: data,
	}
	if ll.head == nil {
		ll.head = node
	} else {
		current := ll.head
		for current.next != nil {
			current = current.next
		}
		current.next = node
	}
	ll.size++
	return
}
// InsertAtAnyPos: To add an element at pos 3 we stop at pos 2, That means we traverse 
// 2 nodes and insert the new node.
// Prev will point to the predecessor of new node and next pointer of new node 
// points to the next node of the prev node
func (ll *LinkedList) InsertAtAnyPos(data interface{}, position int) error {
	// base case check position valid or not
	if position < 1 || position > ll.size + 1 {
		return fmt.Errorf("insert: Error out of bounds")
	}
	newNode := &ListNode{data, nil}
	var prev, current *ListNode
	prev = nil
	current = ll.head
	for position > 1 {
		prev = current
		current = current.next
		position--
	}
	if prev != nil {
		prev.next = newNode
		newNode.next = current
	} else {
		newNode.next = current
		ll.head = newNode
	}
	ll.size++
	return nil
}
// DeleteFirst: create a temporaty node which will point to the same node as that of head
// and move the head nodes pointer to the next node and dispose temporary node
// Time Complexity: O(1), for scanning the list of size. Space Complexity: O(1).
func (ll *LinkedList) DeleteFirst() (interface{}, error) {
	if ll.head == nil {
		return nil, fmt.Errorf("deleteFront: List is empty")
	}
	data := ll.head.data
	ll.head = ll.head.next
	ll.size--
	return data, nil
}
// DeleteLast: traverse the list, while traversingmaintain the previous node address.
// by the time we reach end of list we have two pointers, one pointing to the tail node and
// other pointing to the node before tail node
// Time Complexity: O(n), for scanning the list of size 􀝊. Space Complexity: O(1).
func (ll *LinkedList) DeleteLast() (interface{}, error) {
	if ll.head == nil {
		return nil, fmt.Errorf("deleteLast: List is empty")
	}
	var prev *ListNode
	current := ll.head
	// last and second last node
	for current.next != nil {
		prev = current
		current = current.next
	}
	if prev != nil {
		prev.next = nil
	} else {
		ll.head = nil
	}
	ll.size--
	return current.data, nil
}
// DeleteFromAnyPos: maintain the previous node while traversing the list.
// Once we find the node to be deleted, 
// change the previous node's next pointer to the next pointer of the node to be deleted
// Time Complexity: O(n). In the worst case, we may need to delete the node from the end of the linked list.
// Space Complexity: O(1).
func (ll *LinkedList) DeleteFromAnyPos(position int) (interface{}, error) {
	if position < 1 || position > ll.size + 1 {
		return nil, fmt.Errorf("insert: Index out of bounds")
	}
	var prev, current *ListNode
	prev = nil
	current = ll.head
	pos := 0
	// delete head and set head as next node
	if position == 1 {
		ll.head = ll.head.next
	} else { // maintain two nodes
		for pos != position - 1 {
			pos = pos + 1
			prev = current
			current = current.next
		}
		if current != nil {
			prev.next = current.next
		}
	}
	ll.size--
	return current.data, nil
}
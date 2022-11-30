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

func (ll *LinkedList) DeleteFirst() (interface{}, error) {
	if ll.head == nil {
		return nil, fmt.Errorf("deleteFront: List is empty")
	}
	data := ll.head.data
	ll.head = ll.head.next
	ll.size--
	return data, nil
}
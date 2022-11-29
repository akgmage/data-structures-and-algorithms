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
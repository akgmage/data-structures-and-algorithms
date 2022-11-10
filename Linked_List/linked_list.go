// Basic implementation of a Singly Linked List PushBack function
// Sample Input:  PushBack(10), PushBack(20), PushBack(30)
// Output: 10 -> 20 -> 30 ->
package main

import "fmt"

// has two fields [data] of type integer and [next] of type *node (holds the memory address of next node)
type node struct {
	data int
	next *node
}
//has three fields length, head and tail node
type linkedlist struct {
	length int
	head   *node
	tail   *node
}
// Received in *node as an input and nadds it to linkedlist
func (ll *linkedlist) PushBack(n *node) {
	// make incoming *node as head and tail node
	if ll.head == nil {
		ll.head = n
		ll.tail = n
		ll.length++
	} else {
		// store memory address of incoming node and point tail to the incoming node
		ll.tail.next = n
		ll.tail = n
		ll.length++
	}
}
// Traverse the linkedlist and print data
func (ll linkedlist) Display() {
	for ll.head != nil {
		fmt.Printf("%v -> ", ll.head.data)
		ll.head = ll.head.next
	}
}
func main() {
	list := linkedlist{}
	node1 := &node{data: 10}
	node2 := &node{data: 20}
	node3 := &node{data: 30}
	list.PushBack(node1)
	list.PushBack(node2)
	list.PushBack(node3)
	list.Display()
}
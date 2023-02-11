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
// Return's the head if its present or returns error
func (ll linkedlist) Front() (int, error) {
	if ll.head == nil {
		return 0, fmt.Errorf("No Front value present")
	}
	return ll.head.data, nil
}
// Return's the tail if its present or returns error
func (ll linkedlist) Back() (int, error) {
	if ll.tail == nil {
		return 0, fmt.Errorf("No tail found")
	}
	return ll.tail.data, nil
}
// Delete front node if any
func (ll *linkedlist) DeleteFromFront() {
	if ll.head == nil {
		fmt.Println("Nothing to delete")
		return
	}
	ll.head = ll.head.next
	ll.length--;
}
// Delete from back 
func (ll *linkedlist) DeleteFromBack() {
	if ll.head == nil {
		fmt.Println("Nothing to delete")
		return
	}
	var prev *node = nil
	var temp *node = ll.head
	// traverse to second last element
	for temp.next != nil {
		prev = temp
		temp = temp.next
	}
	// point second last to nil
	prev.next = nil
}

// Traverse the linkedlist and print data
func (ll linkedlist) Display() {
	// go till last and keep printing, 
	for ll.head != nil {
		fmt.Printf("%v -> ", ll.head.data)
		ll.head = ll.head.next // at some point this will point ti nil so loop terminates
	}
}
func main() {
	list := linkedlist{}
	msg, err := list.Back()
	fmt.Println("\n",msg, err)
	list.DeleteFromBack()
	msg, err = list.Front()
	fmt.Println("\n",msg, err)
	node1 := &node{data: 10}
	node2 := &node{data: 20}
	node3 := &node{data: 30}
	node4 := &node{data: 40}
	list.PushBack(node1)
	list.PushBack(node2)
	list.PushBack(node3)
	list.PushBack(node4)
	list.Display()
	msg, err = list.Front()
	fmt.Println("\n",msg, err)
	msg, err = list.Back()
	fmt.Println("\n",msg, err)
	list.DeleteFromFront()
	list.Display()
	list.DeleteFromBack()
	fmt.Println("")
	list.Display()
}
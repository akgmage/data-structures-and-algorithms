package main

import (
	"errors"
	"fmt"
)

/*
   insertAtTail (val)
   insertAtHead (val)
   deleteAtTail ()
   deleteAtHead ()
   getLength ()
   print ()
   getAtIdx (idx)
   replaceAtIdx (val, idx)
   deleteAtIdx (idx)
   search (val)
   toArray ()
   reverse ()
*/

// struct for a node type, we use interface{} to allow for any type of value, you could replace this
// with another value if you want to have more control over the type of value that can be inserted
type node struct {
	val  interface{}
	next *node
}

// struct for the linked list type
type linkedList struct {
	head   *node
	tail   *node
	length int
}

// constructor for a node type
func newNode(val interface{}) *node {
	return &node{val: val, next: nil}
}

// constructor for a linked list type
func newLinkedList() *linkedList {
	return &linkedList{head: nil, tail: nil, length: 0}
}

// function for linked lists to check if the linked list is empty
func (l *linkedList) IsEmpty() bool {
	return l.head == nil
}

// function for linked lists to insert a value at the tail of the linked list
func (l *linkedList) insertAtTail(val interface{}) {
	node := newNode(val)
	if l.IsEmpty() {
		l.head = node
		l.tail = l.head
		l.length += 1
		return
	} else {
		node := node
		l.tail.next = node
		l.tail = node
		l.length += 1
	}
}

// function for linked lists to insert a value at the head of the linked list

func (l *linkedList) insertAtHead(val interface{}) {
	// create a new node
	node := newNode(val)
	// check if the list is empty
	if l.IsEmpty() {
		// if it is, set the head and tail to the new node and increase the length
		l.head = node
		l.tail = l.head
		l.length += 1
		return
	} else {
		// if it is not, set the new node's next to the current head and set the head to the new node
		node.next = l.head
		l.head = node
		l.length += 1
	}

}

func (l *linkedList) print() {
	c := l.head
	for c != nil {
		fmt.Printf("%v", c.val)
		if c.next == nil {
			fmt.Println()
			break
		}
		c = c.next

		fmt.Print(" -> ")
	}
	fmt.Printf("Current Length: %v\n", l.length)

}

// function for linked lists to delete a node at the tail of the linked list
func (l *linkedList) deleteAtTail() {
	if l.IsEmpty() {
		fmt.Println("Empty List")
		return
	}

	if l.head.next == nil {
		l.head = nil
		l.tail = nil
		l.length -= 1
		return
	}

	c := l.head
	for {
		if c.next.next == nil {
			c.next = nil
			l.tail = c
			l.length -= 1
			return
		}
		c = c.next
	}

}

// function for linked lists to delete a node at the head of the linked list
func (l *linkedList) deleteAtHead() {
	if l.IsEmpty() {
		fmt.Println("Empty List")
		return
	}

	if l.head.next == nil {
		l.head = nil
		l.tail = nil
		l.length -= 1
		return
	}

	l.head = l.head.next
	l.length -= 1
}

// function for linked lists to get the length of the linked list
func (l *linkedList) getLength() int {
	return l.length
}

// function of a linked list to get the value at a given index
func (l *linkedList) getAtIdx(idx int) (interface{}, error) {
	if idx >= l.length {
		return nil, errors.New("index out of range")
	}

	c := l.head
	for i := 0; i < idx; i++ {
		c = c.next
	}

	return c.val, nil
}

// function of a linked list to replace the value at a given index
// index starts at 0
func (l *linkedList) replaceAtIdx(val interface{}, idx int) error {
	if idx >= l.length {
		return errors.New("index out of range")
	}

	c := l.head
	for i := 0; i < idx; i++ {
		c = c.next
	}

	c.val = val
	return nil
}

// function of a linked list to delete the value at a given index
func (l *linkedList) deleteAtIdx(idx int) error {
	if idx >= l.length {
		return errors.New("index out of range")
	}

	c := l.head
	for i := 0; i < idx-1; i++ {
		c = c.next
	}

	c.next = c.next.next
	l.length -= 1
	return nil
}

// function to find the index of a given value
// returns -1 and an error if the value is not found
func (l *linkedList) search(val interface{}) (int, error) {
	c := l.head
	for i := 0; i < l.length; i++ {
		if c.val == val {
			return i, nil
		}
		c = c.next
	}

	return -1, errors.New("value not found")
}

// function to convert a linked list to an array
func (l *linkedList) toArray() []interface{} {
	arr := make([]interface{}, l.length)
	c := l.head
	for i := 0; i < l.length; i++ {
		arr[i] = c.val
		c = c.next
	}

	return arr
}

// function to reverse the linked list
// This is a recursive implementation to show something different
func (l *linkedList) reverse() error {
	if l.IsEmpty() {
		return errors.New("Empty List")
	}
	l.head = reverseListRecursive(l.head)
	return nil
}

// recursive function to reverse a linked list recursively
func reverseListRecursive(head *node) *node {
	if head == nil || head.next == nil {
		return head
	}

	rest := reverseListRecursive(head.next)
	head.next.next = head
	head.next = nil

	return rest
}

// example of a linked list
func main() {
	list := newLinkedList()

	list.insertAtHead(1)
	list.insertAtTail(2)
	list.insertAtTail(3)
	list.insertAtTail(4)
	list.insertAtTail(5)
	list.insertAtTail(6)
	list.insertAtTail(7)
	list.insertAtTail(8)
	list.insertAtTail(9)
	list.insertAtTail(10)
	list.insertAtTail(11)
	list.print()

	list.deleteAtTail()
	list.print()

	err := list.replaceAtIdx(9000, 4)
	if err != nil {
		fmt.Println(err)
	}
	list.print()

	i, err := list.search(9000)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(i)
	}

	err = list.reverse()
	if err != nil {
		fmt.Println(err)
	}

	list.print()
	idx, err := list.search(3)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(idx)
	}
	fmt.Println(list.toArray())

}

package main

import "fmt"

type node struct {
	data int
	next *node
}

type linkedlist struct {
	length int
	head   *node
	tail   *node
}

func (ll *linkedlist) PushBack(n *node) {
	if ll.head == nil {
		ll.head = n
		ll.tail = n
		ll.length++
	} else {
		ll.tail.next = n
		ll.tail = n
		ll.length++
	}
}
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
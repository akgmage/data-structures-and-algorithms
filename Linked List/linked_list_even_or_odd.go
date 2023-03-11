package main
import "fmt"

// has two fields [data] of type integer and [next] of type *node (holds the memory address of next node)
type node struct {
	data int
	next *node
}
//has three fields length, head and tail node
type LinkedList struct {
	length int
	head   *node
	tail   *node
}

func (ll *LinkedList) IsLengthEven() bool {
	current := ll.head
	for current != nil && current.next != nil {
		current = current.next.next
	}
	if current != nil {
		return false
	}
	return true
}
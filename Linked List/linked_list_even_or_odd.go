/*
	Check whether the given Linked List length is even or odd?

	Approach:
	Use a 2x pointer. Take a pointer that moves at 2x [two nodes at a time]. At the end, if the length is even,
	then the pointer will be nil; otherwise it will point to the last node.
*/
// Time Complexity: O(⌊n/2⌋) ≈O(n). Space Complexity: O(1).
package main

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
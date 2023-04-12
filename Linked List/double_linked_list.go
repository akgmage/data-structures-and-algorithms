//  Implementation of a doubly linked list in Go
/*
	In this implementation, we define a Node struct that contains the data as well as pointers to the previous and next nodes.
	We also define a LinkedList struct that contains a pointer to the head and tail nodes.

	The AddNode method adds a new node to the end of the list. If the list is empty, the new node is set as both the head and tail.
	Otherwise, the new node is added after the current tail, and the current tail is set as the previous node of the new node.
	Finally, the new node is set as the new tail.

	The PrintList method traverses the list from the head node and prints the data of each node.

	In the main function, we create a new doubly linked list, add some nodes to it, and print the list.
*/
package main

import "fmt"

// Node represents a node in the doubly linked list
type Node struct {
    data int
    prev *Node
    next *Node
}

// LinkedList represents the doubly linked list
type LinkedList struct {
    head *Node
    tail *Node
}

// AddNode adds a new node to the end of the doubly linked list
func (list *LinkedList) AddNode(data int) {
    // Create a new node
    newNode := &Node{data: data}

    // If the list is empty, set the new node as head and tail
    if list.head == nil {
        list.head = newNode
        list.tail = newNode
        return
    }

    // Set the new node as the next node of the current tail
    list.tail.next = newNode

    // Set the current tail as the previous node of the new node
    newNode.prev = list.tail

    // Set the new node as the new tail
    list.tail = newNode
}

// PrintList prints the doubly linked list
func (list *LinkedList) PrintList() {
    // Start from the head node
    currNode := list.head

    // Traverse the list and print the data of each node
    for currNode != nil {
        fmt.Printf("%d ", currNode.data)
        currNode = currNode.next
    }
}

func main() {
    // Create a new doubly linked list
    list := &LinkedList{}

    // Add nodes to the list
    list.AddNode(1)
    list.AddNode(2)
    list.AddNode(3)

    // Print the list
    list.PrintList()
}

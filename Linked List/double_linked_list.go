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

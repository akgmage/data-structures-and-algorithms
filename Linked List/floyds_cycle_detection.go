// Definition for singly-linked list.
package main

import "fmt"
type Node struct {
    value int
    next  *Node
}


// DetectCycle detects if there's a cycle in a linked list using Floyd's cycle detection algorithm
func DetectCycle(head *Node) bool {
    // Initialize slow and fast pointers
    slow, fast := head, head

    // Move slow and fast pointers until they meet or fast pointer reaches end of the list
    for fast != nil && fast.next != nil {
        slow = slow.next
        fast = fast.next.next

        // If slow and fast pointers meet, there's a cycle
        if slow == fast {
            return true
        }
    }

    // If fast pointer reaches end of the list, there's no cycle
    return false
}

func main() {
    // Create a linked list with a cycle
    head := &Node{value: 1}
    node2 := &Node{value: 2}
    node3 := &Node{value: 3}
    node4 := &Node{value: 4}
    node5 := &Node{value: 5}
    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node2 // Create a cycle

    // Detect cycle in the linked list
    hasCycle := DetectCycle(head)
    fmt.Println(hasCycle) // Output: true
}

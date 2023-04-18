// Definition for singly-linked list.
package main
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


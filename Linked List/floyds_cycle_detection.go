// Floyds Cycle Detection
/*
	Explanation:
	The Floyd's cycle detection algorithm is a two-pointer algorithm used to detect if a linked list has a
	cycle. It works by initializing two pointers, slow and fast, both pointing to the head of the linked list.
	Then, it moves the slow pointer by one step and the fast pointer by two steps. If there is a cycle in the linked list,
	the fast pointer will eventually catch up to the slow pointer. If there is no cycle, the fast pointer will reach the
	end of the linked list. This algorithm has a time complexity of O(n) and a space complexity of O(1).

	In the implementation above, we define a Node struct to represent a node in the linked list.
	The hasCycle function takes the head of the linked list as input and returns a boolean indicating
	whether the linked list has a cycle or not. We initialize two pointers, slow and fast, both pointing
	to the head of the linked list. We then loop through the linked list while the fast pointer is not
	null and the next of the fast pointer is not null. In each iteration, we move the slow pointer
	by one step and the fast pointer by two steps. If the slow and fast pointers meet, we know there
	is a cycle and we return true. Otherwise, we continue the loop until the end of the linked list and return false.

	The time complexity of Floyd's cycle detection algorithm is O(n), where n is the number of nodes in the linked list.
	This is because in the worst case, we would need to traverse the entire linked list twice: once to reach the point
	 where the cycle begins, and once more to detect the cycle.

	The space complexity of the algorithm is O(1), as we are only using a few constant extra variables to perform
	the detection, regardless of the size of the linked list.
*/

package main

import "fmt"

// Definition for singly-linked list.
type Node struct {
    value int
    next  *Node
}


// DetectCycle detects if there's a cycle in a linked list using Floyd's cycle detection algorithm
func hasCycle(head *Node) bool {
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
    hasCycle := hasCycle(head)
    fmt.Println(hasCycle) // Output: true
}

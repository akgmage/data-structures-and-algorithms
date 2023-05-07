// Implementation of reversing a linked list recursively and iteratively
/*
	In this code, we define a ListNode struct which represents a node in the linked list. We then define two functions:
	ReverseListIteratively and ReverseListRecursively which reverse the linked list iteratively and recursively, respectively.
	In ReverseListIteratively, we declare two pointers prev and curr, initialize curr to head, and iterate over the
	linked list until curr becomes nil. In each iteration, we store the Next pointer of curr in a temporary variable
	nextTemp, point curr.Next to prev, update prev to curr, and update curr to nextTemp. Finally, we return prev,
	which now points to the new head of the reversed linked list.

	In ReverseListRecursively, we first check if head is nil or if head.Next is nil, in which case we return head itself.
	Otherwise, we call ReverseListRecursively on head.Next, which returns the new head of the reversed linked list.
	We then set head.Next.Next to head and head.Next to nil. Finally, we return the new head.

	In the main function, we create a linked list 1 -> 2 -> 3 -> 4 -> 5, reverse it both iteratively and recursively,
	and print out the reversed linked lists.
*/
package main

import "fmt"

// ListNode represents a node in the linked list
type ListNode struct {
    Val  int
    Next *ListNode
}

// ReverseListIteratively reverses a linked list iteratively
func ReverseListIteratively(head *ListNode) *ListNode {
    var prev, curr *ListNode
    curr = head

    for curr != nil {
        nextTemp := curr.Next
        curr.Next = prev
        prev = curr
        curr = nextTemp
    }

    return prev
}

// ReverseListRecursively reverses a linked list recursively
func ReverseListRecursively(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }

    newHead := ReverseListRecursively(head.Next)
    head.Next.Next = head
    head.Next = nil

    return newHead
}

func main() {
    // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
    head := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}

    // Reverse the linked list iteratively
    reversedListIteratively := ReverseListIteratively(head)
    fmt.Println("Reversed linked list (iteratively):")
    for reversedListIteratively != nil {
        fmt.Printf("%d ", reversedListIteratively.Val)
        reversedListIteratively = reversedListIteratively.Next
    }
    fmt.Println()

	head = &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
    // Reverse the linked list recursively
    reversedListRecursively := ReverseListRecursively(head)
    fmt.Println("Reversed linked list (recursively):")
    for reversedListRecursively != nil {
        fmt.Printf("%d ", reversedListRecursively.Val)
        reversedListRecursively = reversedListRecursively.Next
    }
    fmt.Println()
}

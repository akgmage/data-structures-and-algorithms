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

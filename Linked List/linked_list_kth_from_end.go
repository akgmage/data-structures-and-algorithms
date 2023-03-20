// Finding Kth node from end of a LinkedList
package main

/*
Approach
1. Make two pointers slow and fast and keep them both on the head of the linked list.
2. Now, move the fast pointer k steps away from the slow pointer.
3. Now, move the fast pointer and the slow pointer each one step at a time till
   the fast pointer reaches the tail of the linked list. When the fast pointer reaches the tail,
   the node at which the slow pointer resides will be our answer.
*/
func kthFromEnd(head *ListNode, n int) *ListNode {
    first, second := head, head
    for ; n > 0; n-- {
        second = second.next
    }
    for ; second.next != nil; first, second = first.next, second.next {
    }
    first.next = first.next.next
    return first
}  
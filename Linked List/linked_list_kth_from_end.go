// Finding Kth node from end of a LinkedList
package main

/*
Approach
1. Make two pointers slow and fast and keep them both on the head of the linked list.
2. Now, move the fast pointer k steps away from the slow pointer.
3. Now, move the fast pointer and the slow pointer each one step at a time till
   the fast pointer reaches the tail of the linked list. When the fast pointer reaches the tail,
   the node at which the slow pointer resides will be our answer.

Time and space complexity

	Time complexity of the solution is O(n) as we have traversed the linked list once.
	We have traversed it in two parts.
	First we traversed k elements and then we traversed the remaining (size minus k) elements.

	Space complexity is O(1) as we have not used any extra space for the solution.


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
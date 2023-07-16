/**
 * Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.
 *
 * Example #1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * 
 * Example #2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Constraints: 
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 * 
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 *
 * Solution: to find the middle of a linked list, we can use two pointers ("slow" and "fast"). They should both start at head. 
 * While traversing the list, we move the slow pointer one node at a time and the fast pointer two nodes at a time. 
 * When the fast pointer reaches the end of the linked list, the slow pointer will be pointing to the middle node.
 *
 * Time complexity: O(n), space complexity: O(n)
 */
 func middleNode(head *ListNode) *ListNode {
    slow, fast := head, head
    
    for (fast != nil && fast.Next != nil) {
        slow = slow.Next
        fast = fast.Next.Next
    }

    return slow
}

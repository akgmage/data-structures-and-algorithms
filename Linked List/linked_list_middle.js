/* 
    Given the head of a singly linked list, return the middle node of the linked list.

    If there are two middle nodes, return the second middle node.

    Example 1:

    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.

    Example 2:

    Input: head = [1,2,3,4,5,6]
    Output: [4,5,6]
    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
    
    Constraints:

    The number of nodes in the list is in the range [1, 100].
    1 <= Node.val <= 100
*/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
    let curr = head // Initialize the current node to the head
    let size = 0 // Initialize the size to 0

    // Traverse the Linked List
    while (curr) { 
        size += 1 // Keep track of the size of the Linked List
        curr = curr.next
    } // curr is equal to null at the end of the loop

    let mid = Math.floor(size / 2) + 1 // Calculate the middle of the List
    let count = 0 
    curr = head // Reset current to head

    // Traverse the Linked List
    while (curr) {
        count += 1 // Keep track of the number of visited nodes in the List

        if (count === mid) return curr // When middle node found, return it

        curr = curr.next
    }
};
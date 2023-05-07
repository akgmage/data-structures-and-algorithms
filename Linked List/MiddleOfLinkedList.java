/* QUESTION and SAMPLE I/O

    Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node.

    Sample Input = [1,2,3,4,5]
    Sample Output = 3
    
   APPROACH and EXPLANATION
   
    This program is done using two pointers: slow pointer and fast pointer. 
        * Both pointer starts from the head node.
        * Slow pointer moves one step at a time.
        * Fast pointer moves two steps at a time.
        * As the fast pointer reaches the end, slow pointer will be at the middle of the linked list.
        * Accessing the slow pointer's value for 'val' will give you the value for the middle element of linked list.


    Time Complexity: O(n)
    Space Complexity: O(1)

 */

 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow_pointer = head;       //initialize slow pointer
        ListNode fast_pointer = head;       //initialize fast pointer
        while(fast_pointer!=null && fast_pointer.next!=null){
            slow_pointer = slow_pointer.next;       //moves to next node
            fast_pointer = fast_pointer.next.next;      //moves two nodes forward
        }
        return slow_pointer;
    }
}
/**
  Problem :-Remove the nth node from end of the list
  https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

  Approach:- 
  1. First find the length of the list and store it in a variable named 'len'.
  2. Then traverse the list  (len-n)
  3. Now you are one node behind the node that we have to remove.

  4. Now set the current node's next to the next.next i.e temp.next=temp.next.next.

    Time Complexity : O(N) 
    we traverse the list for calculating its length and removing the node.Hence O(N).

    Space Complexity : O(1)
    No extra space is required

    Note :- The code is well documented. So take a look.



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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;          // If the head is null, return the head itself
        if (head.next == null) {                // If there is only one node in the list
            if (n == 1) return null;            // If n is 1, remove the node and return null
            return head;                        // Otherwise, return the head itself
        }
        
        ListNode temp = head;                    // Create a temporary node pointing to the head

        int len = size(head);                   // Get the length of the list
        if (len - n == 0) {                  // If the node to be removed is the head itself
            head = head.next;                    // Move the head to the next node
            return head;
        }
        
        len -= n;                   // Calculate the index of the previous node of the node to be removed
        for (int i = 1; i < len; i++) {      // Traverse to the previous node so we can remove the next node
            temp = temp.next;
        }
        
        if (temp != null && temp.next != null) {     // If the previous node and the node to be removed exist
            temp.next = temp.next.next;    // Point the previous node to the node after the one to be removed
        }
        
        return head;  // Return the updated head
    }
    
    int size(ListNode temp) {
        ListNode s = temp;
        int n = 0;
        while (s != null) {  // Traverse the list to count the number of nodes
            s = s.next;
            n += 1;
        }
        return n;  // Return the size of the list
    }
}

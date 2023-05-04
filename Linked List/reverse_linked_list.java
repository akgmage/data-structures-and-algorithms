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

/*Explaination of the code which reverses the linked list
* --> Initially we are given the head of the linked list. The approach used here is that
* for reversing the linked list we can take the user of three pointers
*
* --> These pointers are named as prev, curr, and right. Initially prev points to NULL, curr
* points to the current node (node of which the pointer has to be reversed) and the right node
* which always points to the node next to the current
*
* --> Idea here is that at each pass we will be reversing the pointer of the current node and
* move all the pointers forward by one step
*
* --> So initially, the current node points to head node, it's pointer is reversed and is made to
* point to he NULL, since now this first node becomes the last node.
*
* --> To move forward, prev is now at the location of current node, current node moves by
* one step, by making it point to the location where right is pointing now. (Using right pointer
* since the track of the next node is lost as we have reveresed the pointer).
*
* --> Loop stops when the current node becomes null. At the itereation, last node is being pointed
* by prev, which is now the first node logically, so assign head to prev.
*
* --> Example input: 1->2->3->4->5
*     Output : 5->4->3->2->1
* */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode right=curr.next;
            curr.next=prev;
            prev=curr;
            curr=right;
        }
        head=prev;
        return head;
    }
}
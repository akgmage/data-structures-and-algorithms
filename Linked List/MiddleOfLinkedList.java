/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 */
package Linear.LinkedLists;

import java.awt.*;
import java.util.ArrayList;

public class MiddleOfLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {

        ListNode tail =  new ListNode(8, null);
        ListNode node2 = new ListNode(2, tail);
        ListNode node1 = new ListNode(4, node2);
        ListNode head = new ListNode(3, node1);


        ListNode ans  = solve(head);

        System.out.println(ans.val);
    }
    public static ListNode solve(ListNode head) {

        // O(N) time | O(N) space
//        ListNode[] array = new ListNode[100];
//
//        int t = 0;
//        while (head != null) {
//            array[t++] = head;
//            head = head.next;
//            t++;
//        }
//        return array[t / 2];

        // O(N) time | O(1) space
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

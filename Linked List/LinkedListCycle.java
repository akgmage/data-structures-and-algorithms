/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 */
package Linear.LinkedLists;

import java.util.List;

public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        ListNode node2 = new ListNode(0);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(3, node1);
        ListNode tail = new ListNode(-4,node1);
        node2.next = tail;

        boolean ans = solve(head);
        System.out.println(ans);
    }
    public static boolean solve(ListNode head) {
        // O(N) time | O(1) space
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { return true; }
        }
        return false;
    }
}

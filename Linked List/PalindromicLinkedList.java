/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 *  or false otherwise.
 *
 *  Input: head = [1,2,2,1]
 *  Output: true
 */
package Linear.LinkedLists;

import java.util.List;

public class PalindromicLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(1, null);
        ListNode node2 = new ListNode(2, tail);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        boolean ans = solve(head);
        System.out.println(ans);
    }
    public static boolean solve(ListNode head) {
        // O(N) time  | O(1) space
        if (head == null) return true;

        // Find the end of the first half and reverse second half
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfHead = reverse(firstHalfEnd);

        while (secondHalfHead != null) {
            if (head.val != secondHalfHead.val) return false;
            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;

    }
    public static ListNode endOfFirstHalf(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;

    }
    public static ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
             ListNode nextNode = currNode.next;
             currNode.next = prevNode;
             prevNode = currNode;

             currNode = nextNode;
        }
        return prevNode;
    }
}

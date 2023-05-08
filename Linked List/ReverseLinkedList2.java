package Linear.LinkedLists;

import java.util.List;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 */
public class ReverseLinkedList2 {
    public static class ListNode {
        int value;
        ListNode next;
        ListNode () {}
        ListNode (int value) { this.value = value;}
        ListNode (int value, ListNode next) { this.value = value; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(5, null);
        ListNode node4 = new ListNode(4, tail);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode linkedList = solve (head, 2, 4);
        while (linkedList != null) {
            System.out.print(linkedList.value + " ");
            linkedList = linkedList.next;
        }
    }
    public static ListNode solve (ListNode head, int left, int right) {
        // O(N) time | O(1) space
        if (head == null || left == right) return head;

        ListNode dummyNode = new ListNode(0, head);

        ListNode before = dummyNode;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode prevNode = before;
        ListNode currNode = before.next;

        for (int i = left; i <= right; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        before.next.next = currNode;
        before.next = prevNode;

        return dummyNode.next;
    }

}
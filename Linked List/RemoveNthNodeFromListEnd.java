package Linear.LinkedLists;

import java.awt.*;

public class RemoveNthNodeFromListEnd {
    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) { this.value = value; this.next = null; }
    }
    public static void main(String[] args) {

        ListNode linkedList = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(40);
        ListNode node4 = new ListNode(50);
        ListNode node5 = new ListNode(60);
        ListNode node6 = new ListNode(70);
        ListNode node7 = new ListNode(80);
        ListNode node8 = new ListNode(90);

        linkedList.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode head = solve (linkedList, 15);

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
    public static ListNode solve(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int counter = 1;

        while (counter <= n && second != null) {
            second = second.next;
            counter++;
        }

        if (second == null) {
            ListNode tempHead = head.next;
            head.next = tempHead;
            head = tempHead;
            return head;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }
}

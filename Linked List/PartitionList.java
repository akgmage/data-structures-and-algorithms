/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 */
package Linear.LinkedLists;

import java.util.List;

public class PartitionList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(2, null);
        ListNode node4 = new ListNode(5, tail);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode head = new ListNode(1, node1);

        ListNode ans = solve(head, 3);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    } public static ListNode solve(ListNode head, int x) {
        // O(N) time | O(1) space
//        ListNode[] arr1 = new ListNode[200];
//        ListNode[] arr2 = new ListNode[200];
//
//        int l1 = 0, l2 = 0;
//
//        ListNode currNode = head;
//
//        while (currNode != null) {
//            if (currNode.val < x) {
//                arr1[l1++] = currNode;
//            } else {
//                arr2[l2++] = currNode;
//            }
//            ListNode prevNode = currNode;
//            currNode = currNode.next;
//            prevNode.next = null;
//        }
//
//        ListNode tempNode = new ListNode();
//        ListNode tempHead = tempNode;
//
//        for (int i = 0; arr1[i] != null; i++) {
//           tempNode.next = arr1[i];
//           tempNode = tempNode.next;
//        }
//
//        for (int i = 0; arr2[i] != null; i++) {
//           tempNode.next = arr2[i];
//           tempNode = tempNode.next;
//        }
//
//        return tempHead.next;

//        O(N) time | O(1) space
        /**
         * before and after are the two pointers used to create the two list
         * before_head and after_head are used to save the heads of the two lists.
         * All of these are initialized with the dummy nodes created.
         */
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        ListNode currNode = head;

        while (currNode != null) {
            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (currNode.val < x) {
                before.next = currNode;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = currNode;
                after = after.next;
            }
            currNode = currNode.next;
        }
        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = afterHead.next;

        return beforeHead.next;
    }
}

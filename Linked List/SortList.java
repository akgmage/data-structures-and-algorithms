/**
 * Problem Description
 * Sort a linked list, A in O(n log n) time.
 *
 *
 *
 * Problem Constraints
 * 0 <= |A| = 105
 *
 *
 *
 * Input Format
 * The first and the only arugment of input contains a pointer to the head of the linked list, A.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the sorted linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [3, 4, 2, 8]
 * Input 2:
 *
 * A = [1]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 3, 4, 8]
 * Output 2:
 *
 * [1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
 * Explanation 2:
 *
 *  The sorted form of [1] is [1].
 */
package Linear.LinkedLists;

import java.util.List;

public class SortList {
    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
        ListNode(int x, ListNode next) { val = x; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(8);
        ListNode node2 = new ListNode(2, tail);
        ListNode node1 = new ListNode(4, node2);
        ListNode head = new ListNode(3, node1);

        ListNode ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode head) {
        // O(NLogN) time | O(LogN) space

        if (head == null || head.next == null) return head;

        ListNode middleNode = getMiddleNode(head);
        ListNode head2 = middleNode.next;
        middleNode.next = null;

        ListNode list1 = solve(head);
        ListNode list2 = solve(head2);

        ListNode ans = doMerge(list1, list2);

        return ans;
    }
    public static ListNode doMerge(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;

        return head.next;
    }
    public static ListNode getMiddleNode(ListNode node) {
        // get the first middle node

        ListNode slow = node;
        ListNode fast = node;

        // to get the first middle node
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

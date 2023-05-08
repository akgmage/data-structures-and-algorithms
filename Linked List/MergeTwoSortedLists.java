/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
package Linear.LinkedLists;

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode tail1 = new ListNode(4, null);
        ListNode node1 = new ListNode(3, tail1);
        ListNode head1 = new ListNode(1, node1);

        ListNode tail2 = new ListNode(4, null);
        ListNode node2 = new ListNode(2, tail2);
        ListNode head2 = new ListNode(1, node2);

        ListNode ans = solve(head1, head2);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode list1, ListNode list2) {
        // O(m + n) time | O(1) space
        // keep track of the head of the new list, and the tail to add on to

        ListNode head = new ListNode();
        ListNode tail = head;

        // iterate until we reach the end of one list
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
       tail.next = list1 == null ? list2 : list1;

        return head.next;
    }
}

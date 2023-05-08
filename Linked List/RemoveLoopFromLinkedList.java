/**
 * Problem Description
 * You are given a linked list that contains a loop.
 * You need to find the node, which creates a loop and break it by making the node point to NULL.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 1000
 *
 *
 *
 * Input Format
 * The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
 * The second line of the input contains an integer which denotes the position of node where cycle starts.
 *
 *
 *
 * Output Format
 * return the head of the updated linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 * 1 -> 2
 * ^    |
 * | - -
 * Input 2:
 *
 * 3 -> 2 -> 4 -> 5 -> 6
 *           ^         |
 *           |         |
 *           - - - - - -
 *
 *
 * Example Output
 * Output 1:
 *
 *  1 -> 2 -> NULL
 * Output 2:
 *
 *  3 -> 2 -> 4 -> 5 -> 6 -> NULL
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Chain of 1->2 is broken.
 * Explanation 2:
 *
 *  Chain of 4->6 is broken.
 */
package Linear.LinkedLists;

public class RemoveLoopFromLinkedList {
    public static  class ListNode {
        public int val;
        public ListNode next;
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
            ListNode node2 = new ListNode(4);
            ListNode node1 = new ListNode(2, node2);
            ListNode head = new ListNode(3, node1);
            ListNode tail = new ListNode(6, node1);
            ListNode node3 = new ListNode(5, tail);
            node2.next = node3;

            ListNode ans = solve(head);

            while (ans != null) {
                System.out.print(ans.val + " ");
                ans = ans.next;
            }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { break; }
        }
        if (fast == null || fast.next == null) return head;

        slow = head;
        ListNode fastPrev = slow;
        while (slow != fast) {
            fastPrev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        fastPrev.next = null;
        return head;
    }
}

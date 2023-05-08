package Linear.LinkedLists;

/**
 * Problem Description
 * You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
 *
 * NOTE: You have to do it in-place and in one-pass.
 *
 *
 *
 * Problem Constraints
 * 1 <= Length of linked list <= 105
 *
 * Value of each node is within the range of a 32-bit integer.
 *
 *
 *
 * Input Format
 * First and only argument is a linked-list node A.
 *
 *
 *
 * Output Format
 * Return a linked-list node denoting the head of the reversed linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * Input 2:
 *
 *  A = 3 -> NULL
 *
 *
 * Example Output
 * Output 1:
 *
 *  5 -> 4 -> 3 -> 2 -> 1 -> NULL
 * Output 2:
 *
 *  3 -> NULL
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL
 * Expalantion 2:
 *
 *  The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode () {}
        ListNode (int val) { this.val = val;}
        ListNode (int val, ListNode next) { this.val = val;this.next = next; }
    }
    public static void main(String[] args) {

        ListNode node4 = new ListNode(50, null);
        ListNode node3 = new ListNode(40, node4);
        ListNode node2 = new ListNode(30, node3);
        ListNode node1 = new ListNode(20, node2);
        ListNode head = new ListNode(10, node1);

        ListNode ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
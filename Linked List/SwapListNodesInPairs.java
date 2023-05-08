/**
 * Problem Description
 * Given a linked list A, swap every two adjacent nodes and return its head.
 *
 * NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the given linked list.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the modified linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 1 -> 2 -> 3 -> 4
 * Input 2:
 *
 *  A = 7 -> 2 -> 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  2 -> 1 -> 4 -> 3
 * Output 2:
 *
 *  2 -> 7 -> 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
 * Explanation 2:
 *
 *  In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped.
 */
package Linear.LinkedLists;

public class SwapListNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode () {}
        ListNode (int val) { this.val = val;}
        ListNode (int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode node4 = new ListNode(50, null);
        ListNode node3 = new ListNode(40, null);
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

        // O(N) time | O(N) space
//       if (head == null || head.next == null) { return head; }
//
//       ListNode nextNode = head.next;
//       head.next = solve(head.next.next);
//       nextNode.next = head;
//
//       return nextNode;

        // O(N) time | O(1) space
        ListNode tempNode = new ListNode();
        tempNode.next = head;

        ListNode prevNode = tempNode;
        while (prevNode.next != null && prevNode.next.next != null) {
            ListNode firstNode = prevNode.next;
            ListNode secondNode = prevNode.next.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode.next = secondNode;

            prevNode = firstNode;
        }
        return tempNode.next;
    }
}

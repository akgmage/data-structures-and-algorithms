/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */
package Linear.LinkedLists;

public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(5, null);
        ListNode node3 = new ListNode(4, tail);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        ListNode ans = solve(head, 2);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    } public static ListNode solve(ListNode head, int k) {
        // O(N) time | O(1) space
        if (head == null) return null;

        int length = 1;
        ListNode listTail = head;
        while (listTail.next != null) {
            listTail = listTail.next;
            length++;
        }
        int offset = Math.abs(k) % length;
        if (offset == 0) return head;
        int newTailPosition = k > 0 ? length - offset : offset;
        ListNode newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        listTail.next = head;

        return newHead;
    }
}

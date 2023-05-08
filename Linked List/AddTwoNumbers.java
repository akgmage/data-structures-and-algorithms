/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
package Linear.LinkedLists;

public class AddTwoNumbers {
      public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static void main(String[] args) {
        ListNode tail1 = new ListNode(3);
        ListNode node1 = new ListNode(4, tail1);
        ListNode head1 = new ListNode(2, node1);

        ListNode tail2 = new ListNode(4);
        ListNode node2 = new ListNode(6, tail2);
        ListNode head2 = new ListNode(5, node2);

        ListNode ans = solve(head1, head2);

        while (ans != null) {
            System.out.println(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode head1, ListNode head2) {
        /**
         * 1. create a dummy node
         * 2. take the mod of both values of nodes and create a node, put the next to the dummy-node,
         * continue till carry, list1, list2 becomes empty
         * 3. return dummy-next
         */
        // O(Max(N, M) time | O(Max(N, M) space , where N is length of first list,
        // M is the length of second list.

        ListNode newLinkedHeadPointer = new ListNode();
        ListNode currentNode = newLinkedHeadPointer;
        int carry = 0;

        ListNode l1 = head1;
        ListNode l2 = head2;

        while (l1 != null || l2 != null || carry != 0) {
            int valueOne = (l1 != null) ? l1.val : 0;
            int valueTwo = (l2 != null) ? l2.val : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int newValue = sumOfValues % 10;
            ListNode newNode = new ListNode(newValue);
            currentNode.next = newNode;
            currentNode = currentNode.next;

            carry = sumOfValues / 10;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return newLinkedHeadPointer.next;
    }
}

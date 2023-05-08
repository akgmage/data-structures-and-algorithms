package Linear.LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(6, null);
        ListNode node2 = new ListNode(5, tail);
        ListNode node1 = new ListNode(2, node2);
        ListNode head1 = new ListNode(1, node1);

        ListNode node4 = new ListNode(4, node2);
        ListNode head2 = new ListNode(3, node4);

        ListNode ans = solve(head1, head2);
        System.out.println(ans.val);
    }
    public static ListNode solve(ListNode head1, ListNode head2) {

        // O(N+M) time |  O(1) space
        ListNode p1 = head1;
        ListNode p2 = head2;

        // if there is no intersection, then at one time p1 and p2 points to null, and exists the loop.
        while (p1 != p2) {
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1;
        // O(N+M) time |  O(M) space
//        Set<ListNode> set = new HashSet<>();
//
//        while (head2 != null) {
//            set.add(head2);
//            head2 = head2.next;
//        }
//
//        while (head1 != null) {
//            // if we find the node pointed to by head1,
//            // in our set containing nodes of 2, then return the node
//            if (set.contains(head1)) { return head1; }
//            head1 = head1.next;
//        }
//        return null;
    }
}

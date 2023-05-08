package Linear.LinkedLists;

public class ReorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(40, null);
        ListNode node2 = new ListNode(30, tail);
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
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode firstHalfHead = head;
        ListNode secondHalfHead = splitLinkedList(head);
        ListNode reverseSecondHalf = reverse(secondHalfHead);

        ListNode l1 = firstHalfHead;
        ListNode l2 = reverseSecondHalf;

        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
        return firstHalfHead;
    }
    public static ListNode splitLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfHead = slow.next;
        slow.next = null;
        return secondHalfHead;

    }
    public static ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;

            currNode = nextNode;
        }
        return prevNode;
    }
}

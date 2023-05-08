package Linear.LinkedLists;

public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
         ListNode linkedList = new ListNode(10);
         ListNode node1 = new ListNode(10);
         ListNode node2 = new ListNode(10);
         ListNode node3 = new ListNode(20);
         ListNode node4 = new ListNode(20);
         ListNode node5 = new ListNode(30);
         ListNode node6 = new ListNode(40);
         ListNode node7 = new ListNode(40);

        linkedList.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode head = solve(linkedList);

        while (head != null) {
            if (head.next == null)
                System.out.print(head.value);
            else System.out.print(head.value + " ");
            head = head.next;
        }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode nextDistinctNode = currentNode.next;
            while (nextDistinctNode != null && currentNode.value == nextDistinctNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return head;
    }
}

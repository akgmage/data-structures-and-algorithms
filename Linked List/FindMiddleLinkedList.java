/* 
In this code, the ListNode class represents a node in the linked list, with an integer value val and a reference to the next node next. The FindMiddleLinkedList class has a findMiddle method that takes a ListNode as its input and returns the middle node of the linked list using the fast and slow pointers algorithm.

*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class FindMiddleLinkedList {
    public ListNode findMiddle(ListNode head) {
        // Create two pointers, slow and fast, both initially pointing to the head of the linked list.
        ListNode slow = head;
        ListNode fast = head;

        // Move the slow pointer one step at a time and the fast pointer two steps at a time, until the fast pointer reaches the end of the list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When the fast pointer reaches the end of the list, the slow pointer will be pointing to the middle of the list.
        return slow;
    }

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create an instance of the FindMiddleLinkedList class
        FindMiddleLinkedList f = new FindMiddleLinkedList();

        // Call the findMiddle method to get the middle node of the linked list
        ListNode middleNode = f.findMiddle(head);

        // Print the value of the middle node
        System.out.println("The middle node has value: " + middleNode.val);
    }
}

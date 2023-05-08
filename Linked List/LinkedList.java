package Linear.LinkedLists;

/**
 * Problem Description
 * Design and implement a Linked List data structure.
 * A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:
 *
 * insert_node(position, value) - To insert the input value at the given position in the linked list.
 * delete_node(position) - Delete the value at the given position from the linked list.
 * print_ll() - Print the entire linked list, such that each element is followed by a single space (no trailing spaces).
 * Note:
 *
 * If an input position does not satisfy the constraint, no action is required.
 * Each print query has to be executed in a new line.
 *
 *
 * Problem Constraints
 * 1 <= value <= 105
 * 1 <= position <= n where, n is the size of the linked-list.
 *
 *
 *
 * Input Format
 * First line contains an integer denoting number of cases, let's say t.
 * Next t line denotes the cases.
 *
 *
 * Output Format
 * When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space. There should not be any trailing space.
 * NOTE: You don't need to return anything.
 *
 *
 * Example Input
 * 5
 * i 1 23
 * i 2 24
 * p
 * d 1
 * p
 *
 *
 * Example Output
 * 23 24
 * 24
 *
 *
 * Example Explanation
 * After first two cases linked list contains two elements 23 and 24.
 * At third case print: 23 24.
 * At fourth case delete value at first position, only one element left 24.
 * At fifth case print: 24.
 */

public class LinkedList {
    static ListNode head;
    static int length;
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {

    }

    public static void insertNode(int position, int value) {
        if (position > length + 1) { // more than tail length
            return;
        }
        ListNode newNode = new ListNode(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode prev = null;
            ListNode curr = head;
            int counter = 1;
            while (counter < position && curr != null) {
                prev = curr;
                curr = curr.next;
                counter++;
            }
            assert prev != null;
            prev.next = newNode;
            newNode.next = curr;
        }
        length++;
    }

    public static void deleteNode(int position) {
        if (position > length) {
            return;
        }

        if (position == 1) {
            head = head.next;
        } else {
            ListNode prev = null;
            ListNode curr = head;
            int counter = 1;
            while (counter < position && curr != null) {
                prev = curr;
                curr = curr.next;
                counter++;
            }
            assert prev != null;
            assert curr != null;
            prev.next = curr.next;
        }
        length--;
    }
    public static void printLinkedList() {
        if (length == 0) return;

        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null)
                System.out.print(curr.val + " ");
            else System.out.print(curr.val);
            curr = curr.next;
        }
    }

}
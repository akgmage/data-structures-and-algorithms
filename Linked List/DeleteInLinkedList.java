package Linear.LinkedLists;

/**
 * Problem Description
 * You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
 *
 * Note : Follow 0-based indexing for the node numbering.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of linked list <= 105
 * 1 <= value of nodes <= 109
 * 0 <= B < size of linked list
 *
 *
 *
 * Input Format
 * The first argument A is the head of a linked list.
 *
 * The second arguement B is an integer.
 *
 *
 *
 * Output Format
 * Return the head of the linked list after deletion
 *
 *
 *
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3
 * B = 1
 * Input 2:
 * A = 4 -> 3 -> 2 -> 1
 * B = 0
 *
 *
 * Example Output
 * Output 1:
 * 1 -> 3
 * Output 2:
 * 3 -> 2 -> 1
 *
 *
 * Example Explanation
 * For Input 1:
 * The linked list after deletion is 1 -> 3.
 * For Input 2:
 * The linked list after deletion is 3 -> 2 -> 1.
 */

public class DeleteInLinkedList {
    public static class Node {
        public int val;
        public Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(50);
        Node node5 = new Node(60);
        Node node6 = new Node(70);
        Node node7 = new Node(80);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        solve(head, 4);
    }
    public static Node solve(Node A, int B) {
        if (B == 0) return A.next;
        Node temp = A;
        int i = 0;

        while ( i < B - 1) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        return A;
    }
}
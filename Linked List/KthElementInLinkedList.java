package Linear.LinkedLists;

/**
 * Problem Description
 * You are given the head of a linked list A and an integer B. You need to find the B-th element of the linked list.
 *
 * Note : Follow 0-based indexing for the node numbering.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of linked list <= 105
 *
 * 1 <= value of nodes <= 109
 *
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
 * Return an integer.
 *
 *
 *
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3
 * B = 0
 * Input 2:
 * A = 4 -> 3 -> 2 -> 1
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 3
 *
 *
 * Example Explanation
 * For Input 1:
 * The 0-th element of the linked list is 1.
 * For Input 2:
 * The 1-st element of the linked list is 3.
 */
public class KthElementInLinkedList {

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

        int ans = solve(head, 4);
    }
    public static int solve(Node node, int k) {
        int i = 0;
        Node temp = node;

        while (i < k) {
            temp = temp.next;
        }
        return temp.val;
    }

}
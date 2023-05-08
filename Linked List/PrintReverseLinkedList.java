package Linear.LinkedLists;

/**
 * Problem Description
 * You are given a singly linked list having head node A. You need to print the linked list in reverse order.
 *
 * Note :- The node values must be space separated. You must give a newline after printing all the nodes.
 *
 *
 *
 * Problem Constraints
 * 1 <= Length of linked list <= 105
 *
 * 1 <= Value of each linked list node <= 109
 *
 *
 *
 * Input Format
 * First and only argument is a linked-list node A.
 *
 *
 *
 * Output Format
 * Print the linked list in reverse order
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * Input 2:
 *
 *  A = 3 -> NULL
 *
 *
 * Example Output
 * Output 1:
 *
 *  5 4 3 2 1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL
 * Expalantion 2:
 *
 *  The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL
 */

public class PrintReverseLinkedList {

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

        solve(head);
    }
    public static void solve(Node node) {
        if (node == null) return;
        solve(node.next);
        System.out.print(node.val + " ");
    }
}
package Linear.LinkedLists;

/**
 * Problem Description
 * Given heads of two linked lists A and B, check if they are identical i.e. each of their corresponding nodes should contain the same data. The two given linked lists may or may not be of the same length.
 *
 *
 * Problem Constraints
 * 1 <= size of linked lists <= 105
 *
 * 1 <= value of each node <= 109
 *
 *
 *
 * Input Format
 * You are given the head of two linked lists A and B.
 *
 *
 * Output Format
 * Return 1 if both the linked lists are identical and 0 otherwise
 *
 *
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3
 * B = 1 -> 2 -> 3
 * Input 2:
 * A = 4 -> 3 -> 2 -> 1
 * B = 4 -> 2 -> 3 -> 1
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 *
 *
 * Example Explanation
 * For Input 1:
 * Both the linked lists are identical
 * For Input 2:
 * The value in the second node of both the linked lists
 * are different.
 */

public class CompareLinkedList {

    public static class Node {
        public int val;
        public Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        Node head1 = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(50);
        Node node5 = new Node(60);
        Node node6 = new Node(70);
        Node node7 = new Node(80);

        Node head2 = new Node(10);
        Node node8 = new Node(20);
        Node node9 = new Node(30);
        Node node10 = new Node(40);
        Node node11 = new Node(50);
        Node node12 = new Node(60);
        Node node13 = new Node(70);
        Node node14 = new Node(80);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        head2.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        System.out.println(solve(head1, head2));
    }

    public static int solve(Node head1, Node head2) {
            Node temp1 = head1;
            Node temp2 = head2;

            while (temp1 != temp2) {
                if (temp1.val != temp2.val) return 0;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return 0;
    }
}
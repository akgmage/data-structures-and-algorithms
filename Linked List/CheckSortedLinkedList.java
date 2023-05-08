package Linear.LinkedLists;

/**
 * Problem Description
 * You are given the head of a linked list A. Check if the data inside it exists in non-decreasing order.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of linked list <= 105
 * 1 <= value of nodes <= 109
 *
 *
 *
 * Input Format
 * The first argument A is the head of a linked list.
 *
 *
 *
 * Output Format
 * Return 1 if the data of nodes is non-decreasing and 0 otherwise
 *
 *
 *
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3 -> 3
 * Input 2:
 * A = 4 -> 3 -> 2 -> 1
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
 * The data of nodes follow a non-decreasing order.
 * For Input 2:
 * The data of nodes are not in non-decreasing order.
 */

public class CheckSortedLinkedList {
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
    public static int solve(Node head) {
       Node temp = head;

       while (temp != null) {
           if (temp.next != null) {
               if (temp.next.val < temp.val) {
                   return 0;
               }
           }
           temp = temp.next;
       }
       return 1;
    }
}
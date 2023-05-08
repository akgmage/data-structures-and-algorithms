package Linear.LinkedLists;

/**
 * Problem Description
 * You are given A which is the head of a linked list. Print the linked list in space separated manner.
 *
 * Note : The last node value must also be succeeded by a space and after printing the entire list you should print a new line
 *
 *
 *
 * Problem Constraints
 * 1 <= size of linked list <= 105
 *
 * 1 <= value of nodes <= 109
 *
 *
 *
 * Input Format
 * The first argument A is the head of a linked list.
 *
 *
 * Output Format
 * You dont need to return anything
 *
 *
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3
 * Input 2:
 * A = 4 -> 3 -> 2 -> 1
 *
 *
 * Example Output
 * Output 1:
 * 1 2 3
 * Output 2:
 * 4 3 2 1
 *
 *
 * Example Explanation
 * For Input 1:
 * We print the given linked list
 * For Input 2:
 * We print the given linked list
 */

public class PrintLinkedList {

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
        
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}
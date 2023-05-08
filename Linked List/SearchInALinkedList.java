package Linear.LinkedLists;

/**
Problem Description
You are given the head of a linked list A and an integer B, check if there is any node which contains this value B.

Return 1 if such a node is present else return 0.



Problem Constraints
1 <= size of linked list <= 105
1 <= value of nodes <= 109
1 <= B <= 109



Input Format
The first argument A is the head of a linked list.

The second arguement B is an integer.



Output Format
Return 1 if such a node is present otherwise return 0.


Example Input
Input 1:
A = 1 -> 2 -> 3
B = 4
Input 2:
A = 4 -> 3 -> 2 -> 1
B = 4


Example Output
Output 1:
0
Output 2:
1


Example Explanation
For Input 1:
None of the nodes have a value 4.
For Input 2:
The first node has a value 4.
*/

public class SearchInALinkedList {

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

        solve(head, 60);
    }
    public static int solve(Node node, int b) {
        Node temp = node;

        while (temp != null) {
            if (node.val == b) return 1;
            temp = temp.next;
        }
        return 0;
    }

}
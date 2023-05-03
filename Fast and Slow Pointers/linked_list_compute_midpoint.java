/*
 * LEETCODE 876
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
*Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

*Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

*CODE EXPLAINATION WITH DRY RUN:
This Java code finds the midpoint node of a singly-linked list. If the linked list has an even number 
of nodes, it returns the second middle node.

First, the Node class is defined with a constructor that takes in an integer value and initializes
the next reference to null. The insertAtTail() method takes in a head node and an integer value,
and inserts a new node with the given value at the end of the linked list. The printLinkedList() method 
takes in a head node and prints out all the values in the linked list.

The makeLinkedList() method prompts the user to enter integers until -1 is inputted. Each integer is 
inserted into a new node at the tail of the linked list. The computeMidpoint() method takes in a head 
node and returns the middle node(s) of the linked list. If the linked list has no nodes or only one node, 
it just returns the head node. Otherwise, it initializes a slow pointer and a fast pointer to the head 
node. The while loop advances the fast pointer by two nodes and the slow pointer by one node at each 
iteration until the fast pointer reaches the end of the linked list. At that point, the slow pointer 
will be pointing to the midpoint node(s) of the linked list.

Finally, in the main() method, a new linked list is created by calling makeLinkedList(). The linked 
list is printed using printLinkedList(). The midpoint of the linked list is computed using 
computeMidpoint(), and its value is printed out.

*Example Dry Run:
Suppose we have the following input:
1 2 3 4 5 -1
This creates a linked list with the following structure:
1 -> 2 -> 3 -> 4 -> 5 -> null
Initially, the slow pointer and fast pointer both point to the head node, which is 1. In the first iteration of the while loop, the fast pointer moves two nodes ahead to node 3, while the slow pointer moves one node ahead to node 2. In the second iteration, the fast pointer moves another two nodes ahead to null, while the slow pointer moves one more node ahead to node 3. At this point, the slow pointer is pointing to the midpoint node(s) of the linked list.
Therefore, computeMidpoint() returns node 3, which is printed out as output.

*/
import java.util.Scanner;

public class linked_list_compute_midpoint {

  static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      next = null;
    }
  }

  static Node insertAtTail(Node head, int data) {
    if (head == null) {
      head = new Node(data);
      return head;
    }
    Node n = new Node(data);
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = n;
    return head;
  }

  static void printLinkedList(Node head) {
    while (head != null) {
      System.out.print(head.data + "->");
      head = head.next;
    }
  }

  static Node makeLinkedList() {
    Scanner scanner = new Scanner(System.in);
    int data = scanner.nextInt();
    Node head = null;
    while (data != -1) {
      head = insertAtTail(head, data);
      data = scanner.nextInt();
    }
    scanner.close();
    return head;
  }

  static Node computeMidpoint(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    Node head = makeLinkedList();
    printLinkedList(head);
    System.out.println();
    Node midpoint = computeMidpoint(head);
    System.out.println(midpoint.data);
  }
}

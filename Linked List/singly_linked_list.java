// Linked list: Implement Singly linked list in Java #982

/*
APPROACH :Node Class: The Node class is defined to represent a single node in the linked list. It has two instance variables: data to store the value and next to store the reference to the next node.

Insertion at the Start: The insertStart method allows inserting a new node at the beginning of the linked list. It creates a new node with the given data value and sets its next reference to the current head. Then, it updates the head to point to the newly inserted node.

Deletion from the Start: The delete method removes the first node from the linked list. It checks if the head is null, indicating an empty list. If not, it updates the head to point to the next node, effectively removing the first node.

Display: The display method is used to print the elements of the linked list. It starts from the head node and iterates through the list by moving to the next node until the current node becomes null. During each iteration, it prints the data value of the current node.

Main Method: The main method demonstrates the usage of the linked list implementation. It creates an empty list by initializing the head to null. It then performs several insertions using the insertStart method to add nodes at the beginning of the list. After that, it calls the display method to print the elements of the list. Next, it performs several deletions using the delete method to remove nodes from the beginning of the list. Finally, it calls the display method again to print the updated list.
*/

import java.lang.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int x) // parameterized constructor
    {
        data = x;
        next = null;
    }
}

class Main
{
    static Node insertStart(Node head, int data)
    {
        // Creating newNode memory & assigning data value
        Node newNode = new Node(data);

        // assigning this newNode's next as current head node
        newNode.next = head;
        // re-assigning head to this newNode
        head = newNode;

        return head;
    }

    public static Node delete(Node head)
    {
        if (head == null){
            System.out.println("List is empty, not possible to delete");
            return head;
        }

        System.out.println("Deleted: " + head.data);
        // move head to next node
        head = head.next;

        return head;
    }

    static void display(Node node) {

        //as linked list will end when Node is Null
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public static void main(String args[])
    {
        Node head = null;
        head = insertStart(head,6);
        head = insertStart(head,5);
        head = insertStart(head,4);
        head = insertStart(head,3);
        head = insertStart(head,2);
        head = insertStart(head,1);

        display(head);

        head = delete(head);
        head = delete(head);
        head = delete(head);

        display(head);


    }
}

/*
the space complexity is O(n), and the time complexity for each operation is either O(1) or O(n), depending on the specific operation being performed.
*/

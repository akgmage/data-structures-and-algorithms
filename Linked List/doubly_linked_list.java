/*A Doubly Linked List is a data structure in which each node contains a reference to the previous node and the next node in the sequence. It extends the functionality of a Singly Linked List by allowing traversal in both forward and backward directions.The first node of the list is referred to as the head, and the last node is referred to as the tail. In this implementation, the Node class represents a node in the doubly linked list. Each node has a data field to store the value, and prev and next fields to maintain references to the previous and next nodes in the list.*/

class Node {
    int data;
    Node prev;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    
    public DoublyLinkedList() {
        this.head = null;
    }
    
    // Insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            // If the list is empty, make the new node the head
            head = newNode;
        } else {
            Node current = head;
            
            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }
            
            // Link the new node to the last node
            current.next = newNode;
            newNode.prev = current;
        }
    }
    
    // Delete a node with the given data value
    public void delete(int data) {
        Node current = head;
        
        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    // If the node to be deleted is not the first node
                    
                    // Update the previous node's next reference
                    current.prev.next = current.next;
                } else {
                    // If the node to be deleted is the first node
                    
                    // Update the head reference to the next node
                    head = current.next;
                }
                
                if (current.next != null) {
                    // If the node to be deleted is not the last node
                    
                    // Update the next node's previous reference
                    current.next.prev = current.prev;
                }
                
                break;
            }
            
            current = current.next;
        }
    }
    
    // Display the elements of the list
    public void display() {
        Node current = head;
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        
        list.display(); // Output: 10 20 30 40
        
        list.delete(20);
        list.delete(40);
        
        list.display(); // Output: 10 30
    }
}

/* Time complexity: O(n) for insertions and deletions, and O(1) for display.
Space complexity: O(1) for all operations */

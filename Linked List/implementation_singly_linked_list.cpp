// Implementation of singly LinkedList
// Program Author : SNEHA CHAUHAN

/*A class and a Node class can be used individually in C++ to represent a linked list. The class contains two elements, data and a next pointer that links to the next node. */
/*Three function are implementing in the Linked list class*/
/*InsertNode: Insetion can be done at the end the linked list*/
/*DeleteNode: Deletion is done using index of the node*/
/*PrintNode: Print the Linked list*/
#include <bits/stdc++.h>
using namespace std;

// Class Represent node of the linked list
class Node
{
public:
    int data;
    Node *next;

    // Default Constructor
    Node()
    {
        data = 0;
        next = NULL;
    }

    // // Parameterized Constructor
    Node(int data)
    {
        this->data = data;
        this->next = NULL;
    }
};

// Linked list class
class Linkedlist
{
    Node *head;

public:
    Linkedlist()
    {
        head = NULL;
    }

    // Function for Instering a node in the Linked list
    void insertNode(int data)
    {
        // Create the new Node.
        Node *newNode = new Node(data);

        // Assign to head
        if (head == NULL)
        {
            head = newNode;
            return;
        }

        // Traverse till end of list
        Node *temp = head;
        while (temp->next != NULL)
        {
            // Update temp
            temp = temp->next;
        }
        // Insert at the last.
        temp->next = newNode;
    }
    // Function for Deleting a node in the Linked list at given position
    void deleteNode(int index)
    {
        Node *temp1 = head, *temp2 = NULL;
        int ListLen = 0;

        if (head == NULL)
        {
            cout << "List empty." << endl;
            return;
        }

        // Find length of the linked-list.
        while (temp1 != NULL)
        {
            temp1 = temp1->next;
            ListLen++;
        }

        // Check if the position to be
        // deleted is greater than the length
        // of the linked list.
        if (ListLen < index)
        {
            cout << "Index out of range"
                 << endl;
            return;
        }

        // Declare temp1
        temp1 = head;

        // Deleting the head.
        if (index == 1)
        {
            // Update head
            head = head->next;
            delete temp1;
            return;
        }

        // Traverse the list to
        // find the node to be deleted.
        while (index-- > 1)
        {
            // Update temp2
            temp2 = temp1;
            // Update temp1
            temp1 = temp1->next;
        }

        // Change the next pointer
        // of the previous node.
        temp2->next = temp1->next;

        // Delete the node
        delete temp1;
    }
    void printList()
    {
        Node *temp = head;

        // Check for empty list.
        if (head == NULL)
        {
            cout << "List empty" << endl;
            return;
        }

        // Traverse the list.
        while (temp != NULL)
        {
            cout << temp->data << " ";
            temp = temp->next;
        }
    }
};

int main()
{
    Linkedlist list;
    list.insertNode(4);
    list.insertNode(2);
    list.insertNode(3);
    list.insertNode(8);

    list.printList();
}
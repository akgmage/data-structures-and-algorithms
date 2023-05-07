// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

//  Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.

// TIME ANS SPACE COMPLEXITY OF THE SOLUTION IS :: 
// Time complexity: O(n)
// Space complexity: O(1)

#include <bits/stdc++.h>
using namespace std;

// creating Node manualy
class Node
{
public:
    int data;
    Node *next;

    Node()
    {
        this->data = 0;
        this->next = NULL;
    }
    Node(int data)
    {
        this->data = data;
        this->next = NULL;
    }
};

Node *middleNode(Node *head)
{

    Node *slow = head;
    Node *fast = head;

    // Move slow pointer by one node at a time and fast pointer two nodes at a time.
    // While fast pointer reaches the end, slow pointer must have reached the middle node.

    while (fast != NULL)
    {
        fast = fast->next;
        if (fast != NULL)
        {
            fast = fast->next;
            slow = slow->next;
        }
    }
    return slow; // return slow as ans
}

int main()
{
    // creating nodes.
    Node *first = new Node(1);
    Node *second = new Node(2);
    Node *third = new Node(3);
    Node *fourth = new Node(4);
    Node *fifth = new Node(5);

    // head of linked list
    Node *head = first;

    // Creating connection of nodes
    first->next = second;
    second->next = third;
    third->next = fourth;
    fourth->next = fifth;

    cout << "The middle node of the list is node " << middleNode(head)->data << endl;
    return 0;
}
/* Name : Aneesh
Github username : 007aneesh
Repository name : data-structures-and-algorithms

Problem : Doubly linked list in c++
Issue Number : #975
Problem statement : Given an integer n representing the length of linked list and you have to print linked list from start and end.

Sample testcases: 

Testcase 1 --> 

Input: 
5
1 2 3 4 5

Output:
Printing forwardly................................
1
2
3
4
5
Printing backwardly................................
5
4
3
2
1


Testcase 2 -->
Input: 
3
10 20 30

Output:
Printing forwardly................................
10
20
30
Printing backwardly................................
30
20
10



Time Complexity = O(n)
Space Complexity = O(n)


Explanation:
In the main function, the program first takes input n,
the number of nodes to be inserted in the linked list.
Then, in a loop, it takes n values as input and creates new nodes with those values.
The nodes are then linked together to form a doubly linked list. 
Finally, it calls the PrintForward and PrintBackward functions
to print the elements of the list in forward and backward order, respectively.
*/

// ----------------------------------------------------------------------------- code begins now!

#include <iostream>
using namespace std;

// Define a Node class
class Node {
public:
    int data;
    Node* next;
    Node* prev;
    Node(int d) {
        this->data = d;
        next = NULL;
        prev = NULL;
    }
};

// Function to print the linked list forward
void PrintForward(Node* head) {
    Node* traverse = head;
    while (traverse != NULL) {
        cout << traverse->data << endl;
        traverse = traverse->next;
    }
}

// Function to print the linked list backward
void PrintBackward(Node* tail) {
    Node* traverse = tail;
    while (tail != NULL) {
        cout << traverse->data << endl;
        traverse = traverse->prev;
    }
}

int main() {
    int n, value;
    cin>>n; // Read the number of nodes to be created
    Node *head = nullptr; // Initialize head pointer
    Node *tail = nullptr; // Initialize tail pointer

    // Read 'n' values and create a doubly linked list
    for (int i = 0; i < n; i++) {
        cin >> value; // Read the value for the current node
        Node* newNode = new Node(value);  // Create a new node with the value
        
        // If the list is empty, set the head and tail to the new node
        if (head == NULL) {
            head = newNode;
            tail = newNode;
        } else {
            // Add the new node to the end of the list
            newNode->next = nullptr;
            newNode->prev = tail;
            tail->next = newNode;
            tail = newNode;
        }
    }

    // Print the linked list forward
    cout << "Printing forwardly................................" << endl;
    PrintForward(head);

    // Print the linked list backward
    cout << "Printing backwardly................................" << endl;
    PrintBackward(tail);

    return 0;
}

/* Implementation of Doubly Linked List with Basic Functions:
		> Addition of Node At Head
		> Addition of Node At Tail
		> Addition of Node In Between Of Linked List
		> Deletion of Node At Head
		> Deletion of Node At Tail
		> Deletion of Intermediary Node Linked List
		> Forward Traversal of Linked List
		> Backward Traversal of Linked List
*/
#include <bits/stdc++.h>
using namespace std;
  
// Define a doubly linked list node

struct Node {
   int val;
   struct Node* next;
   struct Node* prev;
};
  
// Function to inserts node at the head of the list
void insertAtHead(Node** head, int data)
{
   Node* temp = new Node;
   temp->val = data;
  
   temp->next = (*head);
   temp->prev = NULL;
  
   if ((*head) != NULL)
   (*head)->prev = temp;
  
   (*head) = temp;
}

// Function to inserts node at the tail of the list
void insertAtTail(Node** head, int data)
{

   Node* temp = new Node;
   temp->val = data;
   temp->next = NULL;
  
   if (*head == NULL) {
   temp->prev = NULL;
   *head = temp;
    return;
    }
    
    Node* tail = *head; 
  
    while (tail->next != NULL)
    {
        tail = tail->next;
    }

    tail->next = temp;
    temp->prev = tail;
}

// Function to inserts after intermediary node
void insertAfterNode(Node* myNode, int data)
{
   if (myNode == NULL) return;
   
   Node* temp = new Node;
   temp->val = data;
  
   temp->next = myNode->next;
   myNode->next = temp;
   temp->prev = myNode;

   if (temp->next != NULL)
   temp->next->prev = temp;
}

// Function to inserts node at the head of the list
Node* deleteAtHead(Node* head)
{
    if(head==NULL) return NULL;
   Node* temp = head;
   head = temp->next;
  
   head->prev = NULL;
   delete temp;
   return head;

}

// Function to inserts node at the tail of the list
void deleteAtTail(Node* head)
{
    if(head==NULL) return;
   Node* temp = head;
   while (temp->next != NULL)
    {
        temp = temp->next;
    }
    Node* tail=temp->prev;
    tail->next=NULL;
    delete temp;
}

// Function to delete an intermediary node
void deleteNode(Node* myNode)
{
   if (myNode == NULL) return;
   
   Node* nextNode = myNode->next;
   Node* prevNode = myNode->prev;
   
   nextNode->prev=prevNode;
   prevNode->next=nextNode;
   
   delete myNode;
}

// Function for forward Traversal
void displayList_F(Node* head) {
    if(head==NULL) return;
   Node* temp=head;
  
   while (temp != NULL) {
      cout<<temp->val<<" ";
      temp = temp->next;
   }
}

// Function for backward Traversal
void displayList_B(Node* head) {
    if(head==NULL) return;
   displayList_B(head->next);
   cout<<head->val<<" ";
}
 
//main program
int main() {
   /* Start with the empty list */
   Node* head = NULL;
  
   // Insert 40 as last node
   insertAtTail(&head, 40);
  
   // insert 20 at the head
   insertAtHead(&head, 20);
  
   // Insert 10 at the beginning.
   insertAtHead(&head, 10);
  
   // Insert 50 at the end.
   insertAtTail(&head, 50);
  
   // Insert 30, after 20.
   insertAfterNode(head->next, 30);
  
   //Forward Traversal
   cout<<"\n Forward Traversal of Doubly linked list is \n "<<endl;
   displayList_F(head);
   
   //Backward Traversal
   cout<<"\n Backward Traversal of Doubly linked list is \n "<<endl;
   displayList_B(head);
   
   // Delete At Tail
   deleteAtTail(head);
  
  // Delete intermediary node
  deleteNode(head->next->next);
  
  //Forward Traversal
   cout<<"\n Forward Traversal of Doubly linked list is \n "<<endl;
   displayList_F(head);
   
   //Backward Traversal
   cout<<"\n Backward Traversal of Doubly linked list is \n "<<endl;
   displayList_B(head);
  
   return 0;
}

/*
	------------------OUTPUT OF MAIN FUNCTION------------------
	Forward Traversal of Doubly linked list is 
 
	10 20 30 40 50 
	Backward Traversal of Doubly linked list is 
 
	50 40 30 20 10 
	Forward Traversal of Doubly linked list is 
 
	10 20 40 
 	Backward Traversal of Doubly linked list is 
 
	40 20 10 
*/
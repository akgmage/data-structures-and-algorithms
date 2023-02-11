// Finding Midpoint of a LinkedList
// Program Author : Abhisek Kumar Gupta 
// Naive Approach: Find the length of the linked list and return the (length/2)th node.
// One pass Approach: Use two pointers, the 2nd pointer should traverse twice as fast at the first.
#include<bits/stdc++.h>
using namespace std;
class node{
    public:
        int data;
        node* next;
        node(int d){
            data = d;
            next = NULL;
        }
};
void insert_at_tail(node *&head, int data){
    if(head == NULL){
        head = new node(data);
        return;
    }
    node *n = new node(data);
    node * temp = head;
    while(temp -> next != NULL){
        temp = temp->next;
    }
    temp->next = n;
}
void print_linked_list(node *head){
    while(head != NULL){
        cout << head->data << "->";
        head = head->next;
    }
}
void makeLinkedList(node *&head){
    int data;
    cin >> data;
    while(data != -1){
        insert_at_tail(head, data);
        cin >> data;
    }
}
node* compute_midpoint(node *head){
    if(head->next == NULL || head == NULL){
        return head;
    }
    node *slow = head;
    node *fast = head->next;
    while(fast != NULL && fast->next != NULL){
        fast = fast->next->next;
        slow = slow->next;
    }
    return slow;
}
int main(){
    node *head = NULL;
    makeLinkedList(head);
    print_linked_list(head);
    node *midpoint = compute_midpoint(head);
    cout << endl;
    cout << midpoint->data << endl;
    return 0;
}
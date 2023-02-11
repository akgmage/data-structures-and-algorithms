// Swap adjacant Nodes in pair Recursive
// Program Author : Abhisek Kumar Gupta 
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
    cout << endl;
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
node* swapNodesInPairRecursive(node *head){
    if(head == NULL || head->next == NULL){
        return head;
    }
    node *newHead = swapNodesInPairRecursive(head->next->next);
    node *temp = head->next;
    temp->next = head;
    head->next = newHead;
    return temp;
}
int main(){
    node *head = NULL;
    makeLinkedList(head);
    print_linked_list(head);
    head = swapNodesInPairRecursive(head);
    print_linked_list(head);
    return 0;
}
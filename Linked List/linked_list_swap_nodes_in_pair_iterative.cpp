// Swap adjacant Nodes in Pair Iterative
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

node* swapNodesInPairIterative(node *head){
    node *dummy = new node(0);
    node *prev = dummy;
    node *curr = head;
    node *second = NULL;
    node *nextPair = NULL;
    while(curr && curr->next){
        nextPair = curr->next->next;
        second = curr->next;

        second->next = curr;
        curr->next = nextPair;
        prev->next = second;

        prev = curr;
        curr = nextPair;
    }
    return dummy->next;

}  
int main(){
    node *head = NULL;
    makeLinkedList(head);
    print_linked_list(head);
    head = swapNodesInPairIterative(head);
    print_linked_list(head);
    return 0;
}
// Reverse a linkedlist recursively
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

node* recursive_reverse(node *head){
    if(head->next == NULL || head == NULL){
        return head;
    }    
    node *mini_head = recursive_reverse(head->next);
    node *current = head;
    current->next->next = current;
    current->next = NULL;    
    return mini_head;
}
int main(){
    node *head = NULL;
    makeLinkedList(head);
    print_linked_list(head);
    cout << endl;
    head = recursive_reverse(head);
    print_linked_list(head); 
    return 0;
}
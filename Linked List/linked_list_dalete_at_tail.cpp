// Delete from Tail in a  LinkedList
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
void delete_at_tail(node *&head){
    node *prev = NULL;
    node *temp = head;
    while(temp->next != NULL){
        prev = temp;
        temp = temp->next;
    }
    prev->next = NULL;
    delete temp;
}
void print_linked_list(node *head){
    while(head != NULL){
        cout << head->data << "->";
        head = head->next;
    }
}
int main(){
    node *head = NULL;
    insert_at_tail(head, 20);
    insert_at_tail(head, 33);
    insert_at_tail(head, 100);
    insert_at_tail(head, 200);
    insert_at_tail(head, 201);
    insert_at_tail(head, 202);
    print_linked_list(head);
    cout << endl;
    delete_at_tail(head);
    delete_at_tail(head);

    print_linked_list(head);
    return 0;
}

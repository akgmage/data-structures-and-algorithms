// Merge two sorted LinkedList
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
istream& operator>>(istream &is, node *&head){
    makeLinkedList(head);
    return is;
}
ostream& operator<<(ostream &os, node *&head){
    print_linked_list(head);
    return os;
}
node* merge_two_lists(node *a, node *b){
    if(a == NULL){
        return b;
    }
    else if(b == NULL){
        return a;
    }
    node *c = NULL;
    if(a->data < b->data){
        c = a;
        c->next = merge_two_lists(a->next, b);
    }
    else{
        c = b;
        c->next = merge_two_lists(a, b->next);
    }
    return c;
}
int main(){
    node *head = NULL;
    node *head2 = NULL;
    cin >> head >> head2;
    cout << head  << endl << head2;
    cout << endl;
    node *x = merge_two_lists(head, head2);
    cout << x << endl;
    return 0;
}
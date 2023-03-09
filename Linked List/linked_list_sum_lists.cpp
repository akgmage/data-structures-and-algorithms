// sum Lists : you have two numbers represented by a linked list 
// where each node contains a single digit, write a function 
// to add two numbers and returns the sum as linked list
// Program Author: Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int data;
        Node *next;

        Node(int d){
            data = d;
        }
};

void insert_at_head(Node *&head, int data){
    Node *new_node = new Node(data);
    new_node->next = head;
    head = new_node;
}
void print_linked_list(Node *head){
    if(head == NULL)
        return;
    cout << head->data << "->";
    print_linked_list(head->next);    
}
void make_linked_list(Node *&head){
    int data;
    cin >> data;
    while(data != -1){
        insert_at_head(head, data);
        cin >> data;
    }
}
Node* add_lists(Node *l1, Node *l2, int carry){
    
    if(l1 == NULL && l2 == NULL && carry == 0)
        return NULL;
    int value = carry;
    
    if(l1 != NULL)
        value += l1->data;

    if(l2 != NULL)
        value += l2->data;
    
    Node *result = new Node(value % 10);

    if(l1 != NULL || l2 != NULL)
        result->next = add_lists(l1 == NULL ? NULL : l1->next, l2 == NULL ? NULL : l2->next, value >= 10 ? 1 : 0);
    else
        result->next = NULL;

    return result;
}
int main(){
    Node *head1 = NULL;
    Node *head2 = NULL;
    make_linked_list(head1);
    make_linked_list(head2);
    print_linked_list(head1);
    cout << endl;
    print_linked_list(head2);
    Node *result = add_lists(head1, head2, 0);
    cout << endl;
    print_linked_list(result);
}
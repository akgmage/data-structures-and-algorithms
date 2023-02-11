// Find length of a LinkedList
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
int length(node* head){
    int len = 0;
    while(head != NULL){
        head = head->next;
        len++;
    }
    return len;
}
void insert_at_head(node *&head, int data){
    node *n = new node(data);
    n->next = head;
    head = n;
}
void print_linked_list(node *head){
    while(head != NULL){
        cout << head->data << "->";
        head = head->next;
    }
}
int main(){
    node *head = NULL;
    insert_at_head(head, 1);
    insert_at_head(head, 2);
    insert_at_head(head, 3);
    print_linked_list(head);
    int len = length(head);
    cout << endl <<len;
    return 0;
}
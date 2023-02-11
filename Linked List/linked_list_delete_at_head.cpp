// Delete from Head in a LinkedList
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
void insert_at_head(node *&head, int data){
    node *n = new node(data);
    n->next = head;
    head = n;
}
void delete_at_head(node *&head){
    if(head == NULL){
        return;
    }
    node *temp = head;
    head = head->next;
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
    insert_at_head(head, 1);
    insert_at_head(head, 2);
    insert_at_head(head, 3);
    print_linked_list(head);
    cout << endl;
    delete_at_head(head);
    delete_at_head(head);
    print_linked_list(head);
    return 0;
}
// Insert at any position in a LinkedList
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
void insert_at_anypos(node *&head, int data, int pos){
    if(head == NULL || pos == 0){
        insert_at_head(head, data);
    }
    else if(pos > length(head)){
        insert_at_tail(head, data);
    }
    else{
        node* temp = head;
        node *n = new node(data);
        for(int i = 0; i < pos - 1; i++){
            temp = temp->next;
        }
        n->next = temp->next;
        temp->next = n;
    }
}
void delete_at_head(node *&head){
    if(head == NULL){
        return;
    }
    node *temp = head;
    head = head->next;
    delete temp;
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
void delete_at_any_pos(node *&head, int pos){
    if(pos == 0 || pos == 1){
        delete_at_head(head);
        return;
    }
    else if(pos > length(head)){
        delete_at_tail(head);
    }
    else{
        node *prev = NULL;
        node *temp = head;
        for(int i = 0; i < pos - 1; i++){
            prev = temp;
            temp = temp->next;
        }
        prev->next = temp->next;
        delete temp;
    }
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
    insert_at_anypos(head, 6, 10);
    insert_at_tail(head, 33);
    insert_at_head(head, 44);
    insert_at_anypos(head, 66, 4);
    insert_at_tail(head, 100);
    insert_at_anypos(head, 11, 3);
    print_linked_list(head);
    delete_at_any_pos(head, 2);
    delete_at_any_pos(head, 3);
    delete_at_any_pos(head, 4);
    insert_at_anypos(head, 22, 2);
    cout << endl;
    print_linked_list(head);
    delete_at_any_pos(head, 2);
    cout << endl;
    print_linked_list(head);
    return 0;
}
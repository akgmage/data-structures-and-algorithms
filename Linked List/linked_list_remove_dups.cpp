// Remove duplicates from an unsorted linked list 
// Program Author : Abhisek Kumar Gupta 
#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int data;
        Node *next;

        Node(int d){
            data = d;
            next = NULL;
        }
};
void insert_at_tail(Node *&head, int data){
    if(head == NULL){
        head = new Node(data);
        return;
    }
    Node *n = new Node(data);
    Node *temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }
    temp->next = n;
}
void print_linked_list(Node *head){
    while(head != NULL){
        cout << head->data << "->";
        head = head->next;
    }
}
void make_linked_list(Node *&head){
    int data;
    cin >> data;
    while(data != -1){
        insert_at_tail(head, data);
        cin >> data;
    }
}
void remove_duplicates(Node *&head){
    set<int> S;
    Node *temp = head;
    Node *prev = NULL;
    Node *remove = NULL;
    while(temp != NULL){
        if(S.find(temp->data) != S.end()){
            remove = temp;
            prev->next = temp->next;
        }
        else{
            S.insert(temp->data);
            prev = temp;
        }
        temp = temp->next;
        delete remove;
    }
}
void remove_duplicates_without_buffer(Node *&head){
    Node *current = head;
    Node *remove = NULL;
    while(current != NULL){
        Node *runner = current;
        while(runner->next != NULL){
            if(runner->next->data == current->data){
                remove = runner->next;
                runner->next = runner->next->next;
                delete remove;
            }
            else{
                runner = runner->next;
            }
        }
        current = current->next;
    }
}
int main(){
    Node *head = NULL;
    /*
    make_linked_list(head);
    print_linked_list(head);
    cout << endl;
    remove_duplicates(head);
    print_linked_list(head);
    */
    make_linked_list(head);
    print_linked_list(head);
    cout << endl;
    remove_duplicates_without_buffer(head);
    print_linked_list(head);
}
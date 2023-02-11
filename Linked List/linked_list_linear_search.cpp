// Search linearly in a LinkedList
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
bool linear_search(node *head, int key){
    if(head == NULL){
        return false;
    }
    else{
        node *temp = head;
        while(temp != NULL){
            if(temp->data == key){
                return true;
            }
            temp = temp->next;
        }    
    }
    return false;
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
    cout << endl;
    if(linear_search(head, 1)){
        cout << "Found";
    }
    else{
        cout << "Not Found";
    }
    return 0;
}
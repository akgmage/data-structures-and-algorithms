// Finding Kth node from end of a LinkedList
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
node* kth_node_from_end(node *head, int k){
    if(head->next == NULL || head == NULL){
        return head;
    }
    node *slow = head;
    node *fast = head;
    while(k--){
        fast = fast->next;
    }
    while(fast){
        fast = fast->next;
        slow = slow->next;
    }
    return slow;
}
int main(){
    node *head = NULL;
    makeLinkedList(head);
    print_linked_list(head);
    int k;
    cin >> k;
    node *kth_node = kth_node_from_end(head, k);
    cout << endl;
    cout << kth_node->data << endl;
    return 0;
}
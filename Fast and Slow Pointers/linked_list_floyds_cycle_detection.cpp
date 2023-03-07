// Floyds Cycle detection and removal
// Program Author : Abhisek Kumar Gupta 
// The cycle detection problem is to find the cycle in a sequence, 
// and Floyd’s cycle detection algorithm, aka Tortoise and Hare algorithm, 
// is a two-pointer algorithm to detect the cycle and locate the start of the cycle as well.
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
    head->next->next->next = head;
}
bool detect_cycle(node *head){
    node *slow = head;
    node *fast = head;
    while(fast != NULL && fast->next != NULL){
        fast = fast->next->next;
        slow = slow->next;
        if(fast == slow){
            //return true;
            slow = head;
            if(slow == fast){
                while(fast->next != slow) fast = fast->next;
            }
            else{
                while(slow->next != fast->next){
                    slow = slow->next;
                    fast = fast->next;
                }
            }
            fast->next = NULL;
            cout << "Cycle Detected and Removed \n";
        }
    }
    return false;
}
int main(){
    node *head = NULL;
    makeLinkedList(head);
    //print_linked_list(head);
    if(detect_cycle(head)){
        cout << "Cycle detected \n";
    }
    else {
        cout << "No cycle \n";
    }
    print_linked_list(head);
    return 0;
}
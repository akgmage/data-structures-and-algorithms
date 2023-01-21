// Delete  Middle node [given only access to that node]
// Note : No head node is given
// Program Author : Abhisek Kumar Gupta 
// Sample Input : 5 4 3 2 1, delete 3rd node
// Output: 5 4 2 1
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
void insert_at_head(Node *&head, int data){    
    Node *n = new Node(data);
    n->next = head;
    head = n;
}
void make_linked_list(Node *&head){
    int data;
    cin >> data;
    while(data != -1){
        insert_at_head(head, data);
        cin >> data;
    }
}
void print_linked_list(Node *head){
    while(head != NULL){
        cout << head->data << "->";
        head = head->next;
    }
}
bool delete_from_middle(Node *that_node){
    if(that_node == NULL || that_node->next == NULL){
        return false;
    }
    Node *forward = that_node->next;
    that_node->data = forward->data;
    that_node->next = forward->next;
    delete forward;
}
int main(){
    Node *head = NULL;
    make_linked_list(head);
    print_linked_list(head);   cout << endl;
    
    if(delete_from_middle(head->next->next)){
        print_linked_list(head);
    }
    return 0;
}
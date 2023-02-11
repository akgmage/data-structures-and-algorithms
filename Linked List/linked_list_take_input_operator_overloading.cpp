// Take Input in a LinkedList with "Operator overloading"
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
int main(){
    /*node *head = NULL;
    node *head2 = NULL;
    cin >> head >> head2;
    cout << head  << endl << head2;
    */
   int n;
   cin >> n;
   node *arr[n];
   for(int i = 0; i < n; i++){
      arr[i] = NULL;
   }
   for(int i = 0; i < n; i++){
       cin >> arr[i];
   }
   cout << endl;
   for(int i = 0; i < n; i++){
       cout << arr[i] << endl;;
   }
    return 0;
}
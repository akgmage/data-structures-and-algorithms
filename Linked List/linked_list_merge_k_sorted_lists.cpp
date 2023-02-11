// Merge K sorted LinkedLists
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
node* merge_two_lists(node *a, node *b){
    if(a == NULL){
        return b;
    }
    else if(b == NULL){
        return a;
    }
    node *c = NULL;
    if(a->data < b->data){
        c = a;
        c->next = merge_two_lists(a->next, b);
    }
    else{
        c = b;
        c->next = merge_two_lists(a, b->next);
    }
    return c;
}
node* merge_k_lists(node *arr[], int last){
    while(last != 0){
        int i = 0, j = last;
        while(i < j){
            arr[i] = merge_two_lists(arr[i], arr[j]);
            i++;
            j--;
            if(i >= j)
                last = j;
        }
    }
    return arr[0];
}
int main(){

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
   node *head = merge_k_lists(arr, n-1);
   cout << head;
    return 0;
}
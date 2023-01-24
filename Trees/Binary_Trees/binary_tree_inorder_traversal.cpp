// In-Order Traversal of a Binary-Tree
// Program Author : Abhisek Kumar Gupta
/*
          40
        /   \
       10     30
      / \     /  \
     5   -1  -1  28
    / \         /  \
   1   -1      15    20
  / \          /\    /\
 -1 -1        -1 -1 -1 -1
 Input : 40 10 5 1 -1 -1 -1 -1 30 -1 28 15 -1 -1 20 -1 -1
 Output : 1->5->10->40->30->15->28->20  
*/
#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int data;
        Node* left;
        Node* right;

        Node(int x){
            data = x;
            left = NULL;
            right = NULL;
        }
};
Node* build_binary_tree(){
    int data;
    cin >> data;
    if(data == -1){
        return NULL;
    }
    Node* root = new Node(data);
    root->left = build_binary_tree();
    root->right = build_binary_tree();
    return root;
}
void print_binary_tree(Node* root){
    if(root == NULL){
        return;
    }
    print_binary_tree(root->left);
    cout << root->data << "->";
    print_binary_tree(root->right);
}
int main(){
    Node* root = build_binary_tree();
    print_binary_tree(root);
    return 0;    
}


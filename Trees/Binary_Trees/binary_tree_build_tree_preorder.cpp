// Pre-Order Traversal of a Binary-Tree
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
class Node{
    public: 
        int data;
        Node *left;
        Node *right;

        Node(int x){
            data = x;
            left = NULL;
            right = NULL;
        }

};

Node* build_binary_tree(){
    int data;
    cin >> data;
    if(data == -1)
        return NULL;
    Node* root = new Node(data);
    root->left = build_binary_tree();
    root->right = build_binary_tree();
    return root;     
}

void print_binary_tree(Node* root){
    if(root == NULL)
        return;
    cout << root->data << "->";
    print_binary_tree(root->left);
    print_binary_tree(root->right);    
}

int main(){
    Node* root = build_binary_tree();
    print_binary_tree(root);
}
// Binary Tree : Sum of all Nodes
// Program Author : Abhisek Kumar Gupta
/*
            40
            /   \
        10      30
        / \     /  \
       5  -1  -1  28
      / \        /  \
    1   -1      15    20
   / \          /\    /\
   1 -1        -1 -1 -1 -1
   /\
 -1 -1
    Input : 40 10 5 1 1 -1 -1 -1 -1 -1 30 -1 28 15 -1 -1 20 -1 -1
    Output : 150  
*/

#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int data;
        Node* left;
        Node* right;

        Node(int d){
            data = d;
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

int sum_of_all_nodes(Node* root){
    if(root == NULL){
        return 0;
    }
    return root->data + sum_of_all_nodes(root->right) + sum_of_all_nodes(root->left);
}
int main(){
    Node* root = build_binary_tree();
    int sum_of_nodes = sum_of_all_nodes(root);
    cout << sum_of_nodes;
    return 0;
}
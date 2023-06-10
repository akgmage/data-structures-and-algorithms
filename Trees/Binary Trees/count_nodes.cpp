// Binary Tree : Count Number of Nodes
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
    Output : 9  
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
int count_number_of_nodes(Node* root){
    if(root == NULL)
        return 0;
    return 1 + count_number_of_nodes(root->left) + count_number_of_nodes(root->right);    
}
int main(){
    Node* root = build_binary_tree();
    int number_of_nodes = count_number_of_nodes(root);
    cout << number_of_nodes;
    return 0;
} 
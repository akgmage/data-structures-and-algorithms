// Compute Height of a Binary-Tree
// Program Author : Abhisek Kumar Gupta
/*
            40
            /   \
        10      30
        / \     /  \
       5  -1  -1  28
        / \       /  \
    1   -1      15    20
    / \          /\    /\
   1 -1        -1 -1 -1 -1
   /\
 -1 -1
    Input : 40 10 5 1 1 -1 -1 -1 -1 -1 30 -1 28 15 -1 -1 20 -1 -1
    Output : 5
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
int compute_height_of_binary_tree(Node* root){
    if(root == NULL){
        return 0;
    }
    int left_height = compute_height_of_binary_tree(root->left);
    int right_height = compute_height_of_binary_tree(root->right);
    return max(left_height, right_height) + 1;
}
int main(){
    Node* root = build_binary_tree();
    int height = compute_height_of_binary_tree(root);
    cout << "Height of Tree is " << height;
    return 0;
}

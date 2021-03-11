// Binary Tree : Diameter of tree O(n^2)
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
    Output : 7  
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
    if(data == -1)
        return NULL;
    Node* root = new Node(data);
    root->left = build_binary_tree();
    root->right = build_binary_tree();
    return root;    
}
int calculate_height(Node* root){
    if(root == NULL)
        return 0;
    int left_height = calculate_height(root->left);
    int right_height = calculate_height(root->right);
    return max(left_height, right_height) + 1;

}

int calculate_diameter_of_tree(Node* root){
    if(root == NULL)
        return 0;
    int left_height = calculate_height(root->left);
    int right_height = calculate_height(root->right);
    int option1 = left_height + right_height; // if diameter passes through root   
    int option2 = calculate_diameter_of_tree(root->left); // if diameter lies in left subtree
    int option3 = calculate_diameter_of_tree(root->right); // if diameter lies in right subtree
    return max(option1, max(option2, option3));
}


int main(){
    Node* root = build_binary_tree();
    int diameter = calculate_diameter_of_tree(root);
    cout << "Diameter of tree is : " << diameter << endl;
    return 0;
}

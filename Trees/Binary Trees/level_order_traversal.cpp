// Level order Traversal of a Binary Tree TC O(n^2)
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
    Output : 40
            10 30
            5 28
            1 15 20
            1    
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
    if(data == -1){
        return NULL;
    }
    Node* root = new Node(data);
    root->left = build_binary_tree();
    root->right = build_binary_tree();
    return root;
}
int compute_height_of_binary_tree(Node* root){
    if(root == NULL)
        return 0;
    int left_height = compute_height_of_binary_tree(root->left);
    int right_height = compute_height_of_binary_tree(root->right);
    return max(left_height, right_height) + 1;    
}
void print_kth_level(Node* root, int k){
    if(root == NULL)
        return;
    if(k == 1){
        cout << root->data << " ";
        return;
    }
    print_kth_level(root->left, k - 1);
    print_kth_level(root->right, k- 1);
    return;    
}
void level_order_traversal(Node* root){
    int height = compute_height_of_binary_tree(root);
    for(int i = 1; i <= height; i++){
        print_kth_level(root, i);
        cout << "\n";
    }    
}
int main(){
    Node* root = build_binary_tree();
    level_order_traversal(root);
    return 0;
}


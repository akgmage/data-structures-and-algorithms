// Binary Tree : Diameter of tree O(n)
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
    Output : Height   : 5
             Diameter : 7  
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
class Pair{
    public:
        int height;
        int diameter;
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
Pair compute_diameter(Node* root){
    Pair p;
    if(root == NULL){
        p.height = 0;
        p.diameter = 0;
        return p;
    }
    Pair left = compute_diameter(root->left);
    Pair right = compute_diameter(root->right);
    p.height = max(left.height, right.height) + 1;
    p.diameter = max(left.height + right.height, max(left.diameter, right.diameter));
    return p;
}
int main(){
    Node* root = build_binary_tree();
    Pair p = compute_diameter(root);
    cout << p.height << endl;
    cout << p.diameter << endl;
    return 0;
}
// Binary Tree : Replace parent with sum of child nodes
// Program Author : Abhisek Kumar Gupta
/*
            40
            /   \
        10      30
        / \     /  \
       5  -1  -1  28
      / \        /  \
    -1   -1     -1  -1
   
    Input : 40 10 5 -1 -1 -1 30 -1 28 -1 -1
    Output : Height : 3
             Yes it's Balanced

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
    Output : Height : 3
             No it's not Balanced
             
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
class Height_Balanced{
    public:
        int height;
        bool balance;
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
Height_Balanced is_height_balanced(Node* root){
    Height_Balanced p;
    if(root == NULL){
        p.height = 0;
        p.balance = true;
        return p;
    }
    Height_Balanced left = is_height_balanced(root->left);
    Height_Balanced right = is_height_balanced(root->right);
    p.height = max(left.height, right.height) + 1;
    if(abs(left.height - right.height) <= 1 && left.balance && right.balance){
        p.balance = true;
    }
    else{
        p.balance = false;
    }
    return p;
}
int main(){
    Node* root = build_binary_tree();
    if(is_height_balanced(root).balance){
        cout << "Height : " << is_height_balanced(root).height << endl;
        cout << "Yes it's Balanced" << endl;
    }
    else{
        cout << "Height : " << is_height_balanced(root).height << endl;
        cout << "No its not Balanced" << endl;
    }
}
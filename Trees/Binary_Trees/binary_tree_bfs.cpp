// Binary Tree : Breadth First Search TC : O(n)
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
    Output : 40 10 30 5 28 1 15 20 1    
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
void bfs(Node* root){
    queue<Node*> q;
    q.push(root);
    while(!q.empty()){
        Node* element = q.front();
        cout << element->data << "->";
        q.pop();
        if(element->left != NULL){
            q.push(element->left);
        }
        if(element->right != NULL){
            q.push(element->right);
        }
    }
    return;
}
int main(){
    Node* root = build_binary_tree();
    bfs(root);
    return 0;
}
// Binary Tree : Replace parent with sum of child nodes
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
    Output :    Tree before replacing parent with sum of child nodes
                40->
                10->30->
                5->28->
                1->15->20->
                1->
                Tree after replacing parent with sum of child nodes
                110->
                7->63->
                2->35->
                1->15->20->
                1->
                
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
void bfs(Node* root){
    queue<Node*> q;
    q.push(root);
    q.push(NULL);
    while(!q.empty()){
        Node* element = q.front();
        if(element == NULL){
            cout << "\n";
            q.pop();
            if(!q.empty()){
                q.push(NULL);
            }
        }
        else{
            q.pop();
            cout << element->data << "->";
            if(element->left != NULL){
                q.push(element->left);
            }
            if(element->right != NULL){
                q.push(element->right);
            }
        }
    }
}
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

int replace_parent_with_sum_of_child(Node* root){
    if(root == NULL){
        return 0;
    }
    if(root->left == NULL && root->right == NULL){
        return root->data;
    }
    int left_sum = replace_parent_with_sum_of_child(root->left);
    int right_sum = replace_parent_with_sum_of_child(root->right);
    int temp = root->data;
    root->data = left_sum + right_sum;
    return root->data + temp;
}
int main(){
    Node* root = build_binary_tree();
    bfs(root);
    replace_parent_with_sum_of_child(root);
    cout << endl;
    bfs(root);
}
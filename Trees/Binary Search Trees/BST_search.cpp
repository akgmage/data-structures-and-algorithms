// Binary Search Tree : Searching in Binary Search Tree
// Program Author : Abhisek Kumar Gupta
/*
    Input :  7 3 9 2 4 8 10 -1
    Value to be searched : 99
    Output : 
                  7
                /   \
               3     9
              / \   / \ 
             2  4  8  10
            Not present in BST
    Value to be searched : 8   
            Present in BST      
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
            cout << element->data << "->";
            q.pop();
            if(element->left != NULL){
                q.push(element->left);
            }
            if(element->right != NULL){
                q.push(element->right);
            }
        }
    }
    return;
}
Node* insert_into_binary_search_tree(Node* root, int data){
    if(root == NULL){
        return new Node(data);
    }
    if(data <= root->data){
        root->left = insert_into_binary_search_tree(root->left, data);
    }
    else{
        root->right = insert_into_binary_search_tree(root->right, data);
    }
    return root;
}
Node* build_binary_search_tree(){
    int data;
    cin >> data;
    Node* root = NULL;
    while(data != -1){
        root = insert_into_binary_search_tree(root, data);
        cin >> data;
    }
    return root;
}
bool search_in_BST(Node* root, int value_to_be_searched){
    if(root == NULL)
        return false;
    if(value_to_be_searched == root->data)
        return true;
    if(value_to_be_searched <= root->data){
        return search_in_BST(root->left, value_to_be_searched);
    }
    else{
        return search_in_BST(root->right, value_to_be_searched);
    }        
}
int main(){
    Node* root = build_binary_search_tree();
    bfs(root);
    int value_to_be_searched;
    cin >> value_to_be_searched;
    if(search_in_BST(root, value_to_be_searched)){
        cout << "Present in BST\n";
    }
    else{
        cout << "Not present in BST\n";
    }
    return 0;
}

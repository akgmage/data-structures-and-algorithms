// Binary Search Tree : Deleting from Binary Search Tree
// Program Author : Abhisek Kumar Gupta
/*
    Input :  7 3 9 2 4 8 10 -1
    Value to be deleted : 5
    Output :  Tree before deletion
                  7
                /   \
               3     9
              / \   / \ 
             2  4  8  10
    
     Inorder Traversal :  2 3 4 7 8 9 10

            Tree after deletion
                  8
                /   \
               3     9
              / \     \ 
             2  4     10
             
    Inorder Traversal after deletion :  2 3 4 8 9 10
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
}
Node* insert_into_binary_search_tree(Node* root, int data){
    if(root == NULL)
        return new Node(data);
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
Node* delete_from_BST(Node* root, int data){
    if(root == NULL)
        return NULL;
    if(data < root->data){
        root->left = delete_from_BST(root->left, data);
        return root;
    }
    else if(data == root->data){
        if(root->left == NULL && root->right == NULL){
            delete root;
            return NULL;
        }
        if(root->left == NULL && root->right != NULL){
            Node* temp = root;
            root = root->right;
            delete temp;
            return root;
        }
        if(root->left != NULL && root->right == NULL){
            Node* temp = root;
            root = root->left;
            delete temp;
            return root;
        }
        Node* replace  = root->right;
        while(replace->left != NULL){
            replace = replace->left;
        }
        root->data = replace->data;
        root->right = delete_from_BST(root->right, replace->data);
        return root;
    }
    else{
        root->right = delete_from_BST(root->right, data);
        return root;
    }    
    return root;
}
void inorder_traversal(Node* root){
    if(root == NULL){
        return;
    }
    inorder_traversal(root->left);
    cout << root->data << "->";
    inorder_traversal(root->right);
}
int main(){
    Node* root = build_binary_search_tree();
    cout << "\nInorder Traversal\n";
    inorder_traversal(root);
    cout << "\n\n";
    cout << "Printing level by level\n";
    bfs(root);
    int node_to_be_deleted;
    cin >> node_to_be_deleted;
    root = delete_from_BST(root, node_to_be_deleted);
    cout << endl;
    cout << "Printing level by level after deletion\n";
    bfs(root);
    cout << "\n";
    cout << "Inorder Traversal\n";
    inorder_traversal(root);
    cout << "\n\n";
    return 0;
}
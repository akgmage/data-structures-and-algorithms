// Binary Search Tree : Insert into Binary Search Tree
// Program Author : Abhisek Kumar Gupta
/*
    Input :  7 3 9 2 4 8 10
    Output : 
                  7
                /   \
               3     9
              / \   / \ 
             2  4  8  10
     Inorder   : 2 3 4 7 8 9 10 
     Preorder  : 7 3 2 4 9 8 10
     Postorder : 2 4 3 8 10 9 7        
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
void inorder(Node*root){
    if(root == NULL)
        return;
    inorder(root->left);
    cout << root->data << "->";
    inorder(root->right);    
}
void pre_order(Node*root){
    if(root == NULL)
        return;
    cout << root->data << "->";    
    pre_order(root->left);
    pre_order(root->right);    
}
void post_order(Node*root){
    if(root == NULL)
        return;
    post_order(root->left);
    post_order(root->right);
    cout << root->data << "->";    
}
int main(){
    Node* root = build_binary_search_tree();
    cout << endl << "Inorder Traversal";
    inorder(root);
    cout << endl << "Preorder Traversal";
    pre_order(root);
    cout << endl << "Postorder Traversal";
    post_order(root);
    cout << endl;
    bfs(root);

}

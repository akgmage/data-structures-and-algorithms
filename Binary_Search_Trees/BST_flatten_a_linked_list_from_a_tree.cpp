// Binary Search Tree : Flatten a Tree [BST to sorted linkedlist]
// Program Author : Abhisek Kumar Gupta
/*
    Input :  7 3 9 2 4 8 10 -1
    Output : 
                  7
                /   \
               3     9
              / \   / \ 
             2  4  8  10
     Inorder Traversal  : 2 3 4 7 8 9 10  
     Flattened Linkedlist : 2->3->4->7->8->9->10->
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
class Linked_List{
    public:
        Node* head;
        Node* tail;
};
Linked_List flatten_list(Node* root){
    Linked_List l;
    if(root == NULL){
        l.head = l.tail = NULL;
        return l;
    }
    if(root->left == NULL && root->right == NULL){
        l.head = l.tail = root;
        return l;
    }
    if(root->left != NULL && root->right == NULL){
        Linked_List left_linked_list = flatten_list(root->left);
        left_linked_list.tail->right = root;
        l.head = left_linked_list.head;
        l.tail = root;
        return l;
    }
    if(root->left == NULL && root->right != NULL){
        Linked_List right_linked_list = flatten_list(root->right);
        root->right = right_linked_list.head;
        l.head = root;
        l.tail = right_linked_list.tail;
        return l;
    }
    Linked_List left_linked_list = flatten_list(root->left);
    Linked_List right_linked_list = flatten_list(root->right);
    left_linked_list.tail->right = root;
    root->right = right_linked_list.head;

    l.head = left_linked_list.head;
    l.tail = right_linked_list.tail;
    return l;
}
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

int main(){
    Node* root = build_binary_search_tree();
    cout << endl << "Inorder Traversal\n";
    inorder(root);
    cout << endl;
    bfs(root);
    cout << endl;
    Linked_List l = flatten_list(root);
    Node* temp = l.head;

    while(temp != NULL){
        cout << temp->data << "->";
        temp = temp->right;
    }
return 0;
}
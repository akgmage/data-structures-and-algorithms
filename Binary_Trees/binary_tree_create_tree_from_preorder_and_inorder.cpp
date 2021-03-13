// Binary Tree : Create binary tree from preorder and inorder traversal
// Program Author : Abhisek Kumar Gupta
/*
    Input : No of elements : 8
            Inorder        : 4 8 2 5 1 6 3 7
            Preorder       : 1 2 4 8 5 3 6 7
    Output : 
                  1
                /   \
               2      3
              / \    / \           
             4   5  6   7 
            / 
           8        
*/
#include<bits/stdc++.h>
using namespace std;
const int some_number = 1004;
class Node{
    public:
        int data;
        Node* left;
        Node* right;

        Node(int x){
            data = x;
        }
};
void bfs(Node* root){
    queue<Node*> q;
    q.push(root);
    q.push(NULL);
    while (!q.empty()){
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
    return;
}
Node* create_tree_from_preorder_and_inorder(int *Inorder, int *Preorder, int start, int end){
    static int i = 0;
    if(start > end){
        return NULL;
    }
    int index = -1;
    Node* root = new Node(Preorder[i]);
    for(int j = start; j <= end; j++){
        if(Preorder[i] == Inorder[j]){
            index = j;
            break;
        }
    }
    i++;
    root->left = create_tree_from_preorder_and_inorder(Inorder, Preorder, start, index - 1);
    root->right = create_tree_from_preorder_and_inorder(Inorder, Preorder, index + 1, end);
    return root;

}
int main(){
    int In[some_number];
    int Pre[some_number];
    int no_of_elements;
    cin >> no_of_elements;
    int end = no_of_elements - 1;
    int start = 0;
    for(int i = 0; i < no_of_elements; i++)
        cin >> Pre[i];
    for(int i = 0; i < no_of_elements; i++)
        cin >> In[i];    
    Node* root = create_tree_from_preorder_and_inorder(In, Pre, start, end);
    bfs(root);
    return 0;
}
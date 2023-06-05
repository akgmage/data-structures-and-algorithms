/*
Name : MAnmay Ghosh
Github username : ManmayGhosh
Repository name : data-structures-and-algorithms
Problem :  A function that returns true if this Binary Tree is height balanced and false if it isn't in C++
Issue Number : #1368

IMP defination: 
A height balanced binary tree is a binary tree in which the height of the left subtree and right subtree of any node
does not differ by more than 1 and both the left and right subtree are also height balanced.

Explanation of the below C++ code :
1. For each node make two recursion calls – one for left subtree and the other for the right subtree. 
2. Based on the heights returned from the recursion calls, decide if the subtree whose root is the current node is height-balanced or not. 
3. If it is balanced then return the height of that subtree. Otherwise, return -1 to denote that the subtree is not height-balanced.

Base Condition
No node Hence no root node
If string contain all different characters, then minimum n-1 cuts are needed as by atleast 

-------------------------------------------------------------------------//C++ code begins here------------------------------------------------------------------------
*/

#include <bits/stdc++.h>
using namespace std;
 
// Structure of a tree node
struct Node {
    int key;
    struct Node* left;
    struct Node* right;
    //Constructor to create e node with value k and left right child pointers
    Node(int k)
    {
        key = k;
        left = right = NULL;
    }
};
 
// Function to check if tree is height balanced
int isBalanced(Node* root)
{
    //Base Condition
    if (root == NULL)
        return 0;
    int leftheight = isBalanced(root->left);
    
    // Tree not height-balanced
    if (leftheight == -1)
        return -1;
    
    int rightheight = isBalanced(root->right);
    
    // Tree not height-balanced
    if (rightheight == -1)
        return -1;
    
    // Tree not height-balanced
    if (abs(leftheight - rightheight) > 1)
        return -1;
    // Max path length either in left subtree or right subtree including node   
    else
        return max(leftheight, rightheight) + 1;
}
 
// Driver code
int main()
{
    Node* root = new Node(10);
    root->left = new Node(5);
    root->right = new Node(30);
    root->right->left = new Node(15);
    root->right->right = new Node(20);
 
    if (isBalanced(root) > 0)
        cout << "Balanced";
    else
        cout << "Not Balanced";
    return 0;
}

/*
Time Complexity: O(n) 
Because we are only one dfs call and utilizing the height returned from that to determine the height balance,
it is performing the task in linear time.

Auxiliary Space: O(n)
*/
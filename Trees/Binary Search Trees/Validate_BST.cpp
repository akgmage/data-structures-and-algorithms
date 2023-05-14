// VALIDATE BINARY SEARCH TREE --->> LEETCODE



// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left 
// subtree
//  of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// ALGORITHM-->
// Follow these steps while the current node is not null:
//    Process the current node and go to its right child if it doesn't have a left child.
//   Find the inorder predecessor of the current node—that is, the rightmost node in the left subtree—if the present node has a left child, and see if its value is smaller than the value of the current node.

// If the predecessor's right child is null, go to the current node's left child and change the predecessor's right child to point to it.
//  In order to restore the binary tree's original structure, reset the predecessor's right child to null, process the current node, and then move to its right child if it is already referring to the current node.





// C++ program to check if a given tree is BST.
#include <bits/stdc++.h>
using namespace std;



struct Node {
	// structure of a node of the tree.
	int data;
	struct Node *left, *right;

	Node(int data)
	{
		this->data = data;
		left = right = NULL;
	}
};


bool validate(Node* root,long long int min , long long int max){
    if(!root)
        return true;  // if the root is null then it is a valid BST. it means that the tree is empty or we had reached the end of tree. 
    // initializing the ans variable to false (temporarily).
	bool ans = false;    

	// checking if the root's data is in the range of min and max.
    if(root->data<max && root->data>min)
        ans = true;
    else    
        return ans; // if the root's data is not in the range of min and max then it is not a valid BST. hence returning false.
    
	// changing min and max for the left and right subtree. and checking for the left and right subtree with respesct to tree root and returning the ans.
	return ans && validate(root->left,min,root->data) &&
    validate(root->right,root->data,max);       
}


    bool isValidBST(Node* root) {
        if(!root)
            return true;

	// calling  validate function so that it can check for the left and right subtree .. while giving the range of the values of the nodes.
        return  validate(root ,-9223372036854775807,9223372036854775807 );
    }

int main()
{

	// Initializing the tree.
	struct Node* root = new Node(3);
	root->left = new Node(2);
	root->right = new Node(5);
	root->left->left = new Node(1);
	root->left->right = new Node(4);

	// calling the function to check BST.
	if (isValidBST(root))
		cout << "Is BST";
	else
		cout << "Not a BST";

	return 0;
}




// T.C.  O(N)
// S.C.  O(N) ---> for Auxillary stack
/*Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Validate BST in C++
Issue Number : #1187
Problem statement : 

Explanation of the below C++ code :

First, we define the TreeNode structure, which represents a node in the BST. It has three members: val to store the node's value, and left and right pointers to the left and right child nodes, respectively.

The isValidBSTHelper function is a recursive helper function that takes a TreeNode* as input along with the minimum and maximum values that the node's value should fall between. It performs the following checks:

If the node is nullptr, it means we have reached the end of a subtree, so we return true (since an empty subtree is considered a valid BST).
If the node's value is less than or equal to the minimum value or greater than or equal to the maximum value, it violates the BST property, so we return false.
We recursively call isValidBSTHelper for the left and right subtrees, updating the minimum and maximum values accordingly. If both subtrees return true, the current subtree is a valid BST, so we return true.
The isValidBST function is the main function that calls the isValidBSTHelper function with the root node of the BST and the minimum and maximum values (LLONG_MIN and LLONG_MAX) as initial bounds.

The insert function is used to dynamically construct the BST based on the user's input. It takes the root node and the value to be inserted as parameters. If the root node is nullptr, it means the tree is empty, so a new node is created with the given value and returned. Otherwise, based on the value being less than or greater than the root node's value, the function is recursively called on the left or right subtree, respectively. The function then updates the left or right child pointer of the root node accordingly.

The deleteTree function is a recursive function that deallocates the memory allocated for the BST nodes. It takes the root node as input and performs a post-order traversal to delete the nodes. First, it recursively calls deleteTree for the left and right subtrees, and then it deletes the current node.

In the main function, we start by declaring the root node as nullptr and a variable value to store the user's input. We prompt the user to enter values to construct the BST, and the input loop continues until the user enters -1. Inside the loop, we call the insert function to insert the entered value into the BST.

After constructing the BST, we call the isValidBST function to check if the BST is valid. If it is, we print a message indicating that the BST is valid; otherwise, we print a message indicating that it's not valid.

Finally, we clean up the memory allocated for the BST by calling the deleteTree function, passing the root node as the parameter.

*/

-------------------------------------------------------------------------//C++ code begins here-------------------------------------------------------------

#include <iostream>
#include <climits>

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

bool isValidBSTHelper(TreeNode* node, long long minVal, long long maxVal) {
    if (node == nullptr)
        return true;
    
    if (node->val <= minVal || node->val >= maxVal)
        return false;
    
    return isValidBSTHelper(node->left, minVal, node->val) &&
           isValidBSTHelper(node->right, node->val, maxVal);
}

bool isValidBST(TreeNode* root) {
    return isValidBSTHelper(root, LLONG_MIN, LLONG_MAX);
}

TreeNode* insert(TreeNode* root, int value) {
    if (root == nullptr)
        return new TreeNode(value);
    
    if (value < root->val)
        root->left = insert(root->left, value);
    else
        root->right = insert(root->right, value);
    
    return root;
}

void deleteTree(TreeNode* root) {
    if (root == nullptr)
        return;
    
    deleteTree(root->left);
    deleteTree(root->right);
    
    delete root;
}

int main() {
    TreeNode* root = nullptr;
    int value;

    std::cout << "Enter values to construct the BST (enter -1 to stop):" << std::endl;

    while (true) {
        std::cin >> value;
        
        if (value == -1)
            break;

        root = insert(root, value);
    }

    // Check if the BST is valid
    if (isValidBST(root))
        std::cout << "The BST is valid." << std::endl;
    else
        std::cout << "The BST is not valid." << std::endl;

    // Clean up memory
    deleteTree(root);

    return 0;
}

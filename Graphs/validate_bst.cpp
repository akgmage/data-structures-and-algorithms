/*
	Write a function that takes in a potentially invalid Binary Search Tree (BST) and returns a boolean representing
	whether the BST is valid.

	Explanation:

	This code defines a Binary Search Tree (BST) struct with an integer value and left and right nodes that can point to other
	BST nodes. The struct also has a method called ValidateBst() that returns a boolean indicating whether the tree is a valid
	BST or not.

	The BST struct has another method called validateBST() that is used by ValidateBst() to check whether the tree is a valid
	BST or not. The validateBST() method takes in two arguments, min and max, which represent the minimum and maximum values
	that the current node's value can take in order to be a valid BST.

	The validateBST() method first checks whether the current node's value is within the valid range determined by the min and
	max arguments. If not, the method returns false, indicating that the tree is not a valid BST.

	If the current node's value is within the valid range, the method then recursively calls itself on the left and right
	child nodes to check whether their values are within their valid ranges. The valid range for the left child node is defined by the minimum value and the parent node's value, while the valid range for the right child node is defined by the parent node's value and the maximum value.

	If all of the nodes in the tree satisfy the BST property, the method returns true, indicating that the tree is a valid BST.

	O(n) time | O(d) space - where n is the number of nodes in the BST and d is the depth (height) of the BST
*/
#include <iostream>
#include <limits>

struct TreeNode {
    int value;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int x) : value(x), left(nullptr), right(nullptr) {}
};

// Function to check if the BST is valid
bool isValidBST(TreeNode* root) {
    return isValidBSTHelper(root, std::numeric_limits<long long>::min(), std::numeric_limits<long long>::max());
}

// Recursive helper function to check if the BST is valid
bool isValidBSTHelper(TreeNode* node, long long minVal, long long maxVal) {
    // Base case: if the current node's value is outside the allowed range, then the tree is invalid
    if (!node || node->value <= minVal || node->value >= maxVal) {
        return false;
    }

    // Recursively check the left subtree, making sure all values are less than the current node's value
    if (!isValidBSTHelper(node->left, minVal, node->value)) {
        return false;
    }

    // Recursively check the right subtree, making sure all values are greater than or equal to the current node's value
    if (!isValidBSTHelper(node->right, node->value, maxVal)) {
        return false;
    }

    // If we reach this point, then the tree is valid
    return true;
}

int main() {
    TreeNode* root = new TreeNode(10);
    root->left = new TreeNode(5);
    root->right = new TreeNode(15);
    root->left->left = new TreeNode(2);
    root->left->right = new TreeNode(7);

    if (isValidBST(root)) {
        std::cout << "The BST is valid." << std::endl;
    } else {
        std::cout << "The BST is not valid." << std::endl;
    }

    // Clean up memory
    delete root->left->left;
    delete root->left->right;
    delete root->left;
    delete root->right;
    delete root;

    return 0;
}

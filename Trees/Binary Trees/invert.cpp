// Invert Binary tree
#include <iostream>

class BinaryTreeNode {
public:
    int data;
    BinaryTreeNode* left;
    BinaryTreeNode* right;

    BinaryTreeNode(int val) : data(val), left(nullptr), right(nullptr) {}
};

BinaryTreeNode* invertTree(BinaryTreeNode* root) {
    if (root != nullptr) {
        root->left = invertTree(root->right);
        root->right = invertTree(root->left);
    }
    return root;
}

BinaryTreeNode* invertTree2(BinaryTreeNode* root) {
    if (root != nullptr) {
        // swap the pointers in this node
        BinaryTreeNode* temp = root->left;
        root->left = root->right;
        root->right = temp;

        invertTree2(root->left);
        invertTree2(root->right);
    }
    return root;
}

int main() {
    // Example usage:
    // Construct a binary tree
    BinaryTreeNode* root = new BinaryTreeNode(1);
    root->left = new BinaryTreeNode(2);
    root->right = new BinaryTreeNode(3);
    root->left->left = new BinaryTreeNode(4);
    root->left->right = new BinaryTreeNode(5);

    // Invert the binary tree using the first approach
    BinaryTreeNode* invertedRoot = invertTree(root);

    // Invert the binary tree using the second approach
    BinaryTreeNode* invertedRoot2 = invertTree2(root);

    // Additional code for printing or further usage...

    return 0;
}

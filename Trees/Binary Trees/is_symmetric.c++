#include <iostream>

using namespace std;

// This is an input class. Do not edit.
class BinaryTree {
public:
    int Value;
    BinaryTree* Left;
    BinaryTree* Right;
};

// SymmetricalTree checks if a binary tree is symmetrical.
bool SymmetricalTree(BinaryTree* tree) {
    // Call the helper function to check if the left and right subtrees are mirrored.
    return treesAreMirrored(tree->Left, tree->Right);
}

// treesAreMirrored checks if two binary trees are mirrored.
bool treesAreMirrored(BinaryTree* left, BinaryTree* right) {
    // Base case: If both left and right trees are non-null and have the same value,
    // recursively check if their subtrees are mirrored.
    if (left != nullptr && right != nullptr && left->Value == right->Value) {
        return treesAreMirrored(left->Left, right->Right) && treesAreMirrored(left->Right, right->Left);
    }

    // If either left or right tree is null or their values are not equal, they are not mirrored.
    // Also, if both left and right trees are null, they are considered mirrored.
    return left == right;
}

int main() {
    // Create a binary tree for testing
    BinaryTree* tree = new BinaryTree();
    tree->Value = 1;
    tree->Left = new BinaryTree();
    tree->Left->Value = 2;
    tree->Right = new BinaryTree();
    tree->Right->Value = 2;
    tree->Left->Left = new BinaryTree();
    tree->Left->Left->Value = 3;
    tree->Right->Right = new BinaryTree();
    tree->Right->Right->Value = 3;

    // Check if the tree is symmetrical
    bool isSymmetrical = SymmetricalTree(tree);

    // Output the result
    if (isSymmetrical) {
        cout << "The binary tree is symmetrical." << endl;
    } else {
        cout << "The binary tree is not symmetrical." << endl;
    }

    // Clean up the allocated memory
    delete tree->Left->Left;
    delete tree->Right->Right;
    delete tree->Left;
    delete tree->Right;
    delete tree;

    return 0;
}

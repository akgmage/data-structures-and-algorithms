/*
  Write a function that takes in a Binary Tree and returns if that tree is symmetrical. A tree is symmetrical 
  if the left and right subtrees are mirror images of each other.

    Explanation:

    1. The code defines a class `BinaryTree` representing a binary tree node. It has an `int` value and pointers 
       to its left and right children.
    2. The `SymmetricalTree` function is the main entry point. It calls the helper function `treesAreMirrored` 
       to check if the left and right subtrees are mirrored.
    3. The `treesAreMirrored` function checks if two binary trees are mirrored. It uses recursion to compare 
       corresponding nodes in the left and right subtrees.
    4. In the `treesAreMirrored` function, the base case checks if both the left and right trees are non-null 
       and have the same value. If so, it recursively checks if their subtrees are mirrored.
    5. If either the left or right tree is null or their values are not equal, they are not mirrored. 
       If both the left and right trees are null, they are considered mirrored.
    6. In the `main` function, a binary tree is created for testing purposes.
    7. The `SymmetricalTree` function is called to check if the binary tree is symmetrical.
    8. The result is printed to the console.
    9. Memory cleanup is performed by deleting the dynamically allocated nodes.

    The time and space complexity of the given code snippet can be analyzed as follows:

    1. Time Complexity:
    - The `SymmetricalTree` function calls the `treesAreMirrored` function, which performs a recursive traversal of the binary tree.
    - In the worst case, the recursion visits each node once, so the time complexity is O(N), where N is the number of nodes in the tree.

    2. Space Complexity:
   - The space complexity is determined by the maximum depth of the recursion stack.
   - In the worst case, the binary tree is linear, resulting in a recursion depth of N, where N is the number of nodes in the tree.
   - Therefore, the space complexity is O(N) due to the recursion stack usage.

    It's important to note that the space complexity can be optimized by using an iterative approach instead of recursion. By using an iterative algorithm that leverages a stack or queue to perform a level-order traversal, we can achieve a space complexity of O(W), where W is the maximum width (number of nodes at the same level) of the binary tree.

*/
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
bool SymmetricalTreeRecursive(BinaryTree* tree) {
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

// Approach 2: Iterative Approach using Stack
/*
    In this iterative approach, we use two stacks (stackLeft and stackRight) to perform a mirror traversal of the 
    left and right subtrees. The process is similar to the original code snippet but implemented iteratively 
    using a while loop and stacks. The stacks are initialized with the left and right children of the root node, 
    and in each iteration, we compare the corresponding nodes from both stacks and check for asymmetry. 
    The children of the left and right nodes are pushed onto their respective stacks in reverse order to 
    maintain the mirror traversal. The loop continues until both stacks are empty or an asymmetry is detected. 
    Finally, the function returns whether the tree is symmetric or not.

    The time complexity of this algorithm is O(n), where n is the number of nodes in the binary tree, as 
	it traverses each node once. The space complexity is O(max(d, h)), where d is the maximum width of 
	the tree (number of nodes at the widest level) and h is the height of the tree. The space complexity 
	depends on the maximum number of nodes stored in the stacks during the traversal.


*/
struct BinaryTree {
    int value;
    BinaryTree* left;
    BinaryTree* right;
};

bool SymmetricalTreeIterative(BinaryTree* tree) {
    std::stack<BinaryTree*> stackLeft;
    std::stack<BinaryTree*> stackRight;
    stackLeft.push(tree->left);   // Initialize stackLeft with the left child of the root node
    stackRight.push(tree->right); // Initialize stackRight with the right child of the root node

    // Perform mirror traversal of the left and right subtrees
    while (!stackLeft.empty()) {
        BinaryTree* left = stackLeft.top();
        BinaryTree* right = stackRight.top();
        stackLeft.pop();
        stackRight.pop();

        if (left == nullptr && right == nullptr) {
            continue; // Both left and right subtrees are symmetric, continue to the next iteration
        }

        if (left == nullptr || right == nullptr || left->value != right->value) {
            return false; // Asymmetry detected, tree is not symmetric
        }

        // Push the children of left and right onto the respective stacks in reverse order
        stackLeft.push(left->left);
        stackLeft.push(left->right);
        stackRight.push(right->right);
        stackRight.push(right->left);
    }

    return true; // Tree is symmetric
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

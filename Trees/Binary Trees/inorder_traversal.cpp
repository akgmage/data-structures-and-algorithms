// In-Order Traversal of a Binary-Tree
// Program Author : Abhisek Kumar Gupta
/*
          40
        /   \
       10     30
      / \     /  \
     5   -1  -1  28
    / \         /  \
   1   -1      15    20
  / \          /\    /\
 -1 -1        -1 -1 -1 -1
 Input : 40 10 5 1 -1 -1 -1 -1 30 -1 28 15 -1 -1 20 -1 -1
 Output : 1->5->10->40->30->15->28->20  
*/
#include <iostream>
#include <vector>
#include <stack>

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    std::vector<int> inorderTraversal(TreeNode* root) {
        // Vector to store the in-order traversal result
        std::vector<int> result;

        // Stack to simulate the recursive call stack
        std::stack<TreeNode*> stack;

        // Current node starts from the root
        TreeNode* current = root;

        // Continue traversal until the current node is null and the stack is empty
        while (current != nullptr || !stack.empty()) {
            // Traverse all the way to the leftmost node, pushing each node onto the stack
            while (current != nullptr) {
                stack.push(current);
                current = current->left;
            }

            // Pop the top node from the stack (current leftmost node)
            current = stack.top();
            stack.pop();

            // Add the value of the current node to the result vector
            result.push_back(current->val);

            // Move to the right subtree of the current node
            current = current->right;
        }

        // Return the final in-order traversal result
        return result;
    }
};

// Example usage
int main() {
    // Create a sample binary tree
    TreeNode* root = new TreeNode(1);
    root->right = new TreeNode(2);
    root->right->left = new TreeNode(3);

    // Perform in-order traversal
    Solution solution;
    std::vector<int> result = solution.inorderTraversal(root);

    // Print the result
    for (int val : result) {
        std::cout << val << " ";
    }

    // Output: 1 3 2
    return 0;
}


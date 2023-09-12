#include <iostream>
#include <algorithm> // For max function

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    int maxPathSum(TreeNode* root) {
        int maxSum = INT_MIN; // Initialize with the minimum possible value
        findMaxPathSum(root, maxSum);
        return maxSum;
    }

private:
    int findMaxPathSum(TreeNode* node, int& maxSum) {
        if (!node) {
            return 0;
        }
        
        // Calculate the maximum path sum for the left and right subtrees
        int leftMax = max(0, findMaxPathSum(node->left, maxSum));
        int rightMax = max(0, findMaxPathSum(node->right, maxSum));
        
        // Calculate the maximum path sum that includes the current node
        int currentMax = node->val + leftMax + rightMax;
        
        // Update the overall maximum path sum
        maxSum = max(maxSum, currentMax);
        
        // Return the maximum path sum that can be extended from this node
        return node->val + max(leftMax, rightMax);
    }
};

int main() {
    // Create a sample binary tree
    TreeNode* root = new TreeNode(10);
    root->left = new TreeNode(2);
    root->right = new TreeNode(10);
    root->left->left = new TreeNode(20);
    root->left->right = new TreeNode(1);
    root->right->right = new TreeNode(-25);
    root->right->right->left = new TreeNode(3);
    root->right->right->right = new TreeNode(4);

    Solution solution;
    int maxSum = solution.maxPathSum(root);

    cout << "Maximum Path Sum: " << maxSum << endl;

    return 0;
}

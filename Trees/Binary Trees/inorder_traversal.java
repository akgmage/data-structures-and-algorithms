
/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // List to store the in-order traversal result
        List<Integer> result = new ArrayList<>();

        // Stack to simulate the recursive call stack
        Stack<TreeNode> stack = new Stack<>();

        // Current node starts from the root
        TreeNode current = root;

        // Continue traversal until current node is null and stack is empty
        while (current != null || !stack.isEmpty()) {
            // Traverse all the way to the leftmost node, pushing each node onto the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop the top node from the stack (current leftmost node)
            current = stack.pop();

            // Add the value of the current node to the result list
            result.add(current.val);

            // Move to the right subtree of the current node
            current = current.right;
        }

        // Return the final in-order traversal result
        return result;
    }
}

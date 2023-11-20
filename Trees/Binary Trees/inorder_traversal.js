class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = this.right = null;
  }
}

class Solution {
  inorderTraversal(root) {
    const result = [];
    const stack = [];
    let current = root;

    while (current || stack.length > 0) {
      // Traverse all the way to the leftmost node, pushing each node onto the stack
      while (current) {
        stack.push(current);
        current = current.left;
      }

      // Pop the top node from the stack (current leftmost node)
      current = stack.pop();

      // Add the value of the current node to the result array
      result.push(current.val);

      // Move to the right subtree of the current node
      current = current.right;
    }

    return result;
  }
}

// Example usage
const root = new TreeNode(1);
root.right = new TreeNode(2);
root.right.left = new TreeNode(3);

const solution = new Solution();
const result = solution.inorderTraversal(root);

console.log(result); // Output: [1, 3, 2]

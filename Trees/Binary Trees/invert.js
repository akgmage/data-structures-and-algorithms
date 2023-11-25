class BinaryTreeNode {
  constructor(data) {
    this.data = data;
    this.left = this.right = null;
  }
}

class BinaryTreeInverter {
  // Time Complexity: O(n). Space Complexity: O(n).
  // Approach: The inverse of an empty tree is an empty tree
  // The inverse of a tree with root r, and subtrees right and left is a tree with
  // root, whose right subtree is the inverse of left and whoose left subtree
  // is the inverse of right
  invertTree(root) {
    if (root !== null) {
      root.left = this.invertTree(root.right);
      root.right = this.invertTree(root.left);
    }
    return root;
  }

  // Time Complexity: O(n). Space Complexity: O(1).
  // Method2: swap pointers
  invertTree2(root) {
    if (root !== null) {
      // swap the pointers in this node
      let temp = root.left;
      root.left = root.right;
      root.right = temp;

      this.invertTree2(root.left);
      this.invertTree2(root.right);
    }
    return root;
  }

  // Additional methods or code as needed...

  // Example usage:
  static main() {
    // Construct a binary tree
    let root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);

    let inverter = new BinaryTreeInverter();

    // Invert the binary tree using the first approach
    let invertedRoot = inverter.invertTree(root);

    // Invert the binary tree using the second approach
    let invertedRoot2 = inverter.invertTree2(root);

    // Additional code for printing or further usage...
  }
}

// Example usage:
BinaryTreeInverter.main();

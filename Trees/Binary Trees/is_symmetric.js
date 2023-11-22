/*
  Write a function that takes in a Binary Tree and returns if that tree is symmetrical. A tree is symmetrical 
  if the left and right subtrees are mirror images of each other.
*/
class BinaryTree {
  constructor(value, left = null, right = null) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}

function isSymmetricalTreeIterative(tree) {
  const stackLeft = (tree && [tree.left]) || []; // Initialize stackLeft with the left child of the root node
  const stackRight = (tree && [tree.right]) || []; // Initialize stackRight with the right child of the root node

  // Perform mirror traversal of the left and right subtrees
  while (stackLeft.length > 0) {
    const left = stackLeft.pop() || null; // Pop the top node from stackLeft
    const right = stackRight.pop() || null; // Pop the top node from stackRight

    if (!left && !right) {
      continue; // Both left and right subtrees are symmetric, continue to the next iteration
    }

    if (!left || !right || left.value !== right.value) {
      return false; // Asymmetry detected, tree is not symmetric
    }

    // Push the children of left and right onto the respective stacks in reverse order
    if (left) {
      stackLeft.push(left.left, left.right);
    }
    if (right) {
      stackRight.push(right.right, right.left);
    }
  }

  return true; // Tree is symmetric
}

// Example usage:
// Construct a symmetric tree
const symmetricTree = new BinaryTree(
  1,
  new BinaryTree(2, new BinaryTree(3), new BinaryTree(4)),
  new BinaryTree(2, new BinaryTree(4), new BinaryTree(3))
);

console.log(isSymmetricalTreeIterative(symmetricTree)); // Output: true

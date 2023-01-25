//! O(n) time | O(n) space | worst approach

function findKthLargestValueInBst(tree, k) {
  const sortedNodeValues = [];
  inOrderTraverse(tree, sortedNodeValues);
}

function inOrderTraverse(node, sortedNodeValues) {
    if(!node) return;

    inOrderTraverse(node.left, sortedNodeValues);
    sortedNodeValues.push(node.value);
    inOrderTraverse(node.right, sortedNodeValues);
}
class BST {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
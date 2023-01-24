//! o(n^2) time | O(n) space

function allKindsOfNodeDepths(root) {
    if(!root) return 0;
    return allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right) + nodeDepths(root);
}

function nodeDepths(root, depth = 0) {
    if(!root) return 0;
    return depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1);
}
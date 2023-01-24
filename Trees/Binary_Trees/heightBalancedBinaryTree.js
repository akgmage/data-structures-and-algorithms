class Tree {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class TreeInfo {
    constructor(isBalanced, height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

//! O(n) time | O(h) space
function heightBalancedBinaryTree(tree) {
    const treeInfo = getTreeInfo(tree);
    return treeInfo.isBalanced;
}

function getTreeInfo(tree) {
    if(!tree) return new TreeInfo(true, -1);

    const leftSubtreeInfo = getLeftSubtreeInfo(tree.left);
    const rightSubtreeInfo = getLeftSubtreeInfo(tree.right);

    const isBalanced = 
            leftSubtreeInfo.isBalanced &&
            rightSubtreeInfo.isBalanced &&
            Math.abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1;

    const height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;

    return new TreeInfo(isBalanced, height);
}
// ! https://www.algoexpert.io/questions/Flatten%20Binary%20Tree


class BinaryTree {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

//! O(n) time | O(d) space d - depth of binary tree
function flattenBinaryTree(root) {
    const [leftMost, _] = flattenTree(root);
    return leftMost;
}

function flattenTree(node) {
    let leftMost, rightMost;
    if(!node.left) leftMost = node;
    else {
        const [leftSubtreeLeftMost, leftSubtreeRightMost] = flattenTree(node.left);
        connectNodes(leftSubtreeRightMost, node);
        leftMost = leftSubtreeLeftMost;
    }
    if(!node.right) rightMost = node;
    else {
        const [rightSubtreeLeftMost, rightSubtreeRightMost] = flattenTree(node.right);
        connectNodes(node, rightSubtreeLeftMost);
        rightMost = rightSubtreeRightMost;
    }
    return [leftMost, rightMost];
}

function connectNodes(left, right) {
    left.right = right;
    right.left = left;
}

//! O(n) time | O(n) space
function flattenBinaryTree(root) {
    const inOrderNodes = getNodesInorder(root, []);
    for(let i = 0; i < inOrderNodes.length - 1; i++) {
        const leftNode = inOrderNodes[i];
        const rightNode = inOrderNodes[i + 1];
        leftNode.right = rightNode;
        rightNode.left = leftNode;
    }
    return inOrderNodes[0];
}

function inOrderNodes(tree, array) {
    if(!tree) return;
    inOrderNodes(tree.left, array);
    array.push(tree);
    inOrderNodes(tree.right, array);
    return array;
}


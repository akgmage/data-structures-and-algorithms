class BinaryTree {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

//! O(n) time | O(1) space

function findSuccessor(tree, node) {

    if(node.right) return getLeftmostChild(node.right);

    return getRightmostParent(node);
}

function getLeftmostChild(node) {
    let currentNode = node;

    while(currentNode.left) {
        currentNode = currentNode.left;
    }
    return currentNode;
}

function getRightmostParent(node) {
    const currentNode = node;

    while(currentNode.parent && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent;
    }
    return currentNode.parent;
}


//! O(n) time | O(h) space
function findSuccessor(tree, node) {

    const inOrderTraversalOrder = getInorderTraversalOrder(tree);

    for(let idx = 0; idx < inOrderTraversalOrder.length; idx++) {
        const currentNode = inOrderTraversalOrder[idx];

        if(currentNode != node) continue;

        if(idx == inOrderTraversalOrder.length - 1) return null;

        return inOrderTraversalOrder[idx + 1];
    }


}

function getInorderTraversalOrder(node, order = []) {

    if(!node) return order;

    getInorderTraversalOrder(node.left, order);
    order.push(node);
    getInorderTraversalOrder(node.right, order);
    
    return order;
}
//! O(n) time | O(1) space

function iterativeInOrderTraversal(tree, callback) {
    let previousNode = null;
    let currentNode = tree;

    while(currentNode) {
        let nextNode;
        if(!previousNode || previousNode == currentNode.parent) {
            if(currentNode.left) {
                nextNode = currentNode.left;
            } else {
                callback(currentNode);
                nextNode = currentNode.right ? currentNode.right : currentNode.parent;
            }
        } else if(previousNode == currentNode.left) {
            callback(currentNode);
            nextNode = currentNode.right ? currentNode.right : currentNode.parent;
        } else {
            nextNode = currentNode.parent;
        }
        previousNode = currentNode;
        currentNode = nextNode;
    }
}
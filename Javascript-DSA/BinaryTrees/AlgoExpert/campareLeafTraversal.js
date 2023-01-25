//! https://www.algoexpert.io/questions/Compare%20Leaf%20Traversal

//! Google on-site

//! O(n + m) time | O(max(h1, h2)) space

function compareLeafTraversal(tree1, tree2) {
    const [tree1LeafNodesLinkedList, _1] = connectNodes(tree1);
    const [tree2LeafNodesLinkedList, _2] = connectNodes(tree2);

    let list1CurrentNode = tree1LeafNodesLinkedList;
    let list2CurrentNode = tree2LeafNodesLinkedList;

    while(list1CurrentNode && list1CurrentNode) {
        if(list1CurrentNode.value != list2CurrentNode.value) return false;

        list1CurrentNode = list1CurrentNode.right;
        list2CurrentNode = list2CurrentNode.right;
    }
    return !list1CurrentNode && !list2CurrentNode;
}

function connectNodes(currentNode, head = null, previousNode = null) {
    if(!currentNode) return [head, previousNode];

    if(isLeafNode(currentNode)) {
        if(previousNode == null) {
            head = currentNode;
        } else {
            previousNode.right = currentNode;
        }
        previousNode = currentNode;
    }
     
    const [leftHead, leftPreviousNode] = connectNodes(currentNode.left, head, previousNode);
    return connectNodes(currentNode.right, leftHead, leftPreviousNode);
}

function isLeafNode(node) {
    return !node.left && !node.right;
}
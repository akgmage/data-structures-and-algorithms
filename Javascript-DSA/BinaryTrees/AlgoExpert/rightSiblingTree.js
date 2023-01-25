class BinaryTree {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

//! O(n) time | O(d) space where d is depth.
function rightSiblingTree(root) {
    mutate(root, null, null);
    return root;
}

function mutate(node, parent, isLeftChild) {
    if(!node) return;

    const left = node.left;
    const right = node.right;

    mutate(left, parent, true);

    if(!parent) node.right = null;
    else if(isLeftChild) node.right = parent.right;
    else {
        if(!parent.right) node.right = null;
        else node.right = parent.right.left;
    }

    mutate(right, parent, false);
}


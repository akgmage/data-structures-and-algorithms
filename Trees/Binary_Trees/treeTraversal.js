//!12/02/2022
class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function preOrder(root) {
    if(root == null) return;
    console.log(root.data);
    preOrder(root.left);
    preOrder(root.right);
}

function inOrder(root) {
    if (root == null) return;
    inOrder(root.left);
    console.log(root.data);
    inOrder(root.right);
}

function postOrder(root) {
    if(root == null) return;
    postOrder(root.left);
    postOrder(root.right);
    console.log(root.data);
}

const root = new Node(10);
root.left = new Node(20);
root.right = new Node(30);
root.left.left = new Node(40);
root.left.root = new Node(50);
root.right.right = new Node(60);
root.right.right.right = new Node(70);
preOrder(root);
console.log(">>>>>>>>>");
inOrder(root);
console.log(">>>>>>>>>");
postOrder(root)
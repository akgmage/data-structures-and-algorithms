//! 14/02/2022

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

let sum_of_nodes = 0;
function greatestSumTree(root) {
    if(root == null) return;
    greatestSumTree(root.right);
    sum_of_nodes += root.data;
    root.data = sum_of_nodes;
    greatestSumTree(root.left);

}

const root = new Node(10);
root.left = new Node(20);
root.right = new Node(30);

root.left.left = new Node(40);
root.left.right = new Node(50);

root.right.right = new Node(60);
root.right.right.right = new Node(70);

preOrder(root);
console.log("-->");
greatestSumTree(root);
console.log("-->");
preOrder(root);

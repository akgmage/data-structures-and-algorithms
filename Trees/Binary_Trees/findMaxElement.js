//!12/02/2022
class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


function findMaxElement(root) {
    if(root == null) return Number.MIN_SAFE_INTEGER;

    let leftMaxElement = findMaxElement(root.left);
    let rightMaxElement = findMaxElement(root.right);

    return Math.max(leftMaxElement, rightMaxElement, root.data); 
}

const root = new Node(10);
root.left = new Node(20);
root.right = new Node(30);
root.left.left = new Node(40);
root.left.root = new Node(50);
root.right.right = new Node(60);
root.right.right.right = new Node(70);

console.log(findMaxElement(root));

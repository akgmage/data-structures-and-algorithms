//!12/02/2022
class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


function height(root) {
    // if(root.left == null && root.right == null) return 0;

    if(root == null) return -1;

    let leftHeight = height(root.left);
    let rightHeight = height(root.right);
    return Math.max(leftHeight, rightHeight) + 1; 
}


const root = new Node(10);
root.left = new Node(20);
root.right = new Node(30);
root.left.left = new Node(40);
root.left.root = new Node(50);
root.right.right = new Node(60);
root.right.right.right = new Node(70);

console.log(height(root));

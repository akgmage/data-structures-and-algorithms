//!12/02/2022
class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

function findPath(root) {
        
    let leftPath = findLeftPath(root);
    let rightPath = findRightPath(root);

    let result = [];

    result.push(leftPath);
    result.push(rightPath);

    return result;

    }

function findLeftPath(root) {

 findSum(root, 0);

}

function findRightPath(root) {

if(root.left == null && root.right == null) return root.data;
return root.data + findRightPath(root.right);

}

function findSum(root, sum ) {
    if(root.left == null && root.right == null) return;

}



const root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);
root.left.left.left = new Node(8);
root.left.left.right = new Node(9);
root.right.left = new Node(6);
root.right.right = new Node(7);




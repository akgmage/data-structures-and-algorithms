//! 15/02/2022

class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

let preorderIndex = 0;
function search(inorder, l, r, data) {
    for(let i = l; i <= r; i++) {
        if(inorder[i] == data) return i;
    }
}
function buildTree(preorder, inorder, l, r) {
    if(l > r) return null;
    let newNode = new Node(preorder[preorderIndex]);
    preorderIndex++;
    let inorderIndex = search(inorder, l, r, newNode.data);
    newNode.left = buildTree(preorder, inorder, l, inorderIndex-1);
    newNode.right = buildTree(preorder, inorder, inorderIndex+1, r);
    return newNode;
}


function findPath(root, target, array) {
    if(root == null) return false;
    array.push(root.data);
    if(root.data == target) return true;
    if(findPath(root.left, target, array) || findPath(root.right, target, array)) 
    return true;

    array.pop();
    return false;

}

let pre = [3,9,20,15,7];
let ino = [9,3,15,20,7];

let treeNode = buildTree(pre, ino, 0, pre.length-1);
// levelOrderLevelWise(treenode);

let array = [];
findPath(treeNode, 15, array);
console.log(array);

const root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);
root.left.left.left = new Node(8);
root.left.left.right = new Node(9);
root.right.left = new Node(6);
root.right.right = new Node(7);

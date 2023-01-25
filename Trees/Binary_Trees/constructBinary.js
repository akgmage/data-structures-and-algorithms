class Queue {
    constructor() {
        this.data = [];
        this.rear = 0;
        this.front = 0;
    }

    length() {
        return this.rear - this.front;
    }

    isEmpty() {
        return this.length() == 0;
    }

    enqueue(element) {
        this.data[this.rear] = element;
        this.rear++;
    }

    dequeue() {
        if(!this.isEmpty()) {
            let temp = this.data[this.front];
            this.front++;
            return temp;
        } else {
            return undefined;
        }
    }
}

class node {
    constructor(d) {
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

function levelOrderLevelWise(root) {
    let qu = new Queue();
    let null_node = new node(null);
    qu.enqueue(root);
    qu.enqueue(null_node);
    let result = "";
    while(!qu.isEmpty()) {
        let curr = qu.dequeue();
        if(curr.data == null) {
            // this is the end of the last level; 
            if(!qu.isEmpty()) {
                qu.enqueue(new node(null));
                result += "\n";
            }
        } else {
            result += (curr.data + " ");
        }
        if(curr.left != null) {
            qu.enqueue(curr.left);
        }
        if(curr.right != null) {
            qu.enqueue(curr.right);
        }
    }
    console.log(result);
}

//! 15/02/2022

let preorderIndex = 0;
function search(inorder, l, r, data) {
    for(let i = l; i <= r; i++) {
        if(inorder[i] == data) return i;
    }
}

function buildTree(preorder, inorder, l, r) {
    if(l > r) return null;
    let newNode = new node(preorder[preorderIndex]);
    preorderIndex++;
    let inorderIndex = search(inorder, l, r, newNode.data);
    newNode.left = buildTree(preorder, inorder, l, inorderIndex-1);
    newNode.right = buildTree(preorder, inorder, inorderIndex+1, r);
    return newNode;
}

let pre = [3,9,20,15,7];
let ino = [9,3,15,20,7];

let treenode = buildTree(pre, ino, 0, pre.length-1);
levelOrderLevelWise(treenode);

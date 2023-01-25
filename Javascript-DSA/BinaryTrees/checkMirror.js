//!12/02/2022

class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


function isMirror(a, b) {
    if(a == null && b == null) return true;
    if(a == null || b == null) return false;

    
    return a.data == b.data && a.left == b.left && a.right == b.left;

}

const root = new Node(10);
root.left = new Node(20);
root.right = new Node(30);
root.left.left = new Node(40);
root.left.root = new Node(50);
root.right.right = new Node(60);
root.right.right.right = new Node(70);

console.log(isMirror(root, root));
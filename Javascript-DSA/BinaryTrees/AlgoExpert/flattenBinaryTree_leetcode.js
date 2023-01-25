//! https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

//! RIGHT ROOT LEFT
//! O(n) time | O(n) space

//! REVERSE POST ORDER
let previousNode = null;
function flatten(node) {
    if(!node) return;
    
    flatten(node.right);
    flatten(node.left);
 
    node.right = previousNode;
    node.left = null;
    previousNode = node;
} 

//! O(n) time O(1) space
function flatten(root) {
    let currentNode = root;
    let prev = null;
    while(currentNode) {
        if(currentNode.left) {
            prev = currentNode.left;
            while(prev.right) {
                prev = prev.right;
            }
            prev.right = currentNode.right;
            currentNode.right = currentNode.left;
            currentNode.left = null;
        }
        currentNode = currentNode.right;
    }
};




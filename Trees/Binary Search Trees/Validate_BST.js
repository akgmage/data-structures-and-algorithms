////// Explanation:
// To validate a Binary Search Tree (BST), we need to ensure that the values of nodes in the left subtree of any node are less than the value of the node, and the values of nodes in the right subtree are greater than the value of the node. 
// Additionally, the left and right subtrees themselves must also be valid BSTs.

////// Code:
class Node {
     constructor(data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }
 
 function isBST(root) {
     let prev = null;
 
     function inorderTraversal(node) {

        // Base case
         if (node === null) {
             return true;
         }
         
         // If left subtree is not BST return false
         if (!inorderTraversal(node.left)) {
             return false;
         }
 
        // If current node is greater than parent node return false
         if (prev !== null && node.data <= prev.data) {
             return false;
         }
 
         prev = node;
         return inorderTraversal(node.right);
     }
 
     return inorderTraversal(root);
 }
 
 // Create the tree
 const root = new Node(100);
 root.left = new Node(-2);
 root.right = new Node(3);
 root.left.left = new Node(-4);
 root.left.right = new Node(-1);
 root.right.left = new Node(2);
 root.right.right = new Node(7);
 
 // Function call
 if (isBST(root)) {
     console.log("Is Valid BST");
 } else {
     console.log("Not a Valid BST");
 }
 

////// Complexity:
// Time  Complexity: O(n) where n is number of nodes
// Space Complexity: O(1)
/*
	Write a function that takes in a potentially invalid Binary Search Tree (BST)
  	and returns a boolean representing whether the BST is valid.
  	Sample Input :
   	     10
       /     \
      5      15
    /   \   /   \
   2     5 13   22
 /           \
1            14
	Output : True

	Explanation:
	This code defines a Binary Search Tree (BST) struct with an integer value and left and right nodes that can 
	point to other BST nodes. The struct also has a method called ValidateBst() that returns a boolean indicating 
	whether the tree is a valid BST or not.

	The BST struct has another method called validateBST() that is used by ValidateBst() to check whether the tree
	is a valid BST or not. The validateBST() method takes in two arguments, min and max, which represent the minimum 
	and maximum values that the current node's value can take in order to be a valid BST.

	The validateBST() method first checks whether the current node's value is within the valid range determined 
	by the min and max arguments. If not, the method returns false, indicating that the tree is not a valid BST.

	If the current node's value is within the valid range, the method then recursively calls itself on the left 
	and right child nodes to check whether their values are within their valid ranges. The valid range for the 
	left child node is defined by the minimum value and the parent node's value, while the valid range for the 
	right child node is defined by the parent node's value and the maximum value.

	If all of the nodes in the tree satisfy the BST property, the method returns true, indicating that the tree 
	is a valid BST.

	O(n) time | O(d) space - where n is the number of nodes in the BST and d is the depth (height) of the BST

*/
class Node {
     constructor(data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }
 
// isBst is a method of BST that checks if the binary search tree is valid 
function isBST(root) {
     let prev = null;
 
     function inorderTraversal(node) {

        // Base case
         if (node === null) {
             return true;
         }
         
         // recursively check the left subtree, making sure all values are less than the current node's value
         if (!inorderTraversal(node.left)) {
             return false;
         }
 
        // if the current node's value is outside the allowed range, then the tree is invalid
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

/**
 The Node class represents a single node in the BST. It has three properties: value to store the node's value, left to store the reference to the left child node, and right to store the reference to the right child node.
 */
 class Node {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  
  /**
    the BST class represents the Binary Search Tree. It has one property: root to store the reference to the root node of the tree. 
    */
  class BST {
    constructor() {
      this.root = null;
    }
  
    /**
    insert(value): This function inserts a new node with the given value into the BST. It uses the insertNode helper function for recursive insertion. The time complexity is O(log n) on average (O(n) in the worst case if the tree is heavily unbalanced), and the space complexity is O(1).    
     * @param {number} value - The value to be inserted
     */
    insert(value) {
      const newNode = new Node(value);
  
      if (this.root === null) {
        this.root = newNode;
      } else {
        this.insertNode(this.root, newNode);
      }
    }
  
    /**
    The insertNode(node, newNode) function is a helper function used by the insert(value) method in the BST class. It recursively inserts a new node (newNode).
    
    Here's a breakdown of how the insertNode function works:

    *   It compares the value of the newNode with the value of the node to determine whether to go left or right in the BST.
    *   If the value of newNode is less than the value of node, it checks if the left child of node is null. If it is, the newNode becomes the  left child; otherwise, the function recursively calls itself with the left child node of node.
    *   If the value of newNode is greater than or equal to the value of node, it checks if the right child of node is null. If it is, the newNode becomes the right child; otherwise, the function recursively calls itself with the right child node of node.
    *   This process continues until a suitable position is found for the newNode in the BST.

    The time complexity of the insertNode function depends on the structure of the BST. In the average case, when the tree is balanced, the time complexity is O(log n), where n is the number of nodes in the tree. This is because at each level of the tree, the function divides the remaining nodes to be searched by half. However, in the worst case scenario, when the tree is heavily unbalanced (e.g., resembles a linked list), the time complexity becomes O(n), where n is the number of nodes in the tree. This happens when all nodes are in a straight line from the root.

    The space complexity of the insertNode function is O(log n) in the average case and O(n) in the worst case. This is due to the recursive calls that consume memory on the call stack. In the average case, the maximum number of recursive calls is limited by the height of the balanced tree, which is logarithmic to the number of nodes. In the worst case, where the tree is unbalanced, the maximum number of recursive calls is equal to the number of nodes in the tree.
    
    * @param {Node} node - The current node being traversed
     * @param {Node} newNode - The new node to be inserted
     */
    insertNode(node, newNode) {
      if (newNode.value < node.value) {
        if (node.left === null) {
          node.left = newNode;
        } else {
          this.insertNode(node.left, newNode);
        }
      } else {
        if (node.right === null) {
          node.right = newNode;
        } else {
          this.insertNode(node.right, newNode);
        }
      }
    }
  
    /**
    findKthLargest(k): This function finds the Kth largest value in the BST. It first performs an in-order traversal of the tree to retrieve a sorted array of values. If K is larger than the number of nodes in the tree, it returns null. Otherwise, it returns the Kth largest value from the sorted array. The time complexity of this function is O(n), where n is the number of nodes in the tree. The space complexity is O(n) since it stores all the values in the array during the traversal.     
     * @param {number} k - The Kth largest value to find
     * @returns {number|null} - The Kth largest value, or null if it doesn't exist
     */
    findKthLargest(k) {
      if (k <= 0) {
        throw new Error('k should be a positive integer');
      }
  
      const sortedValues = [];
      this.inOrderTraversal(this.root, sortedValues);
  
      if (k > sortedValues.length) {
        return null;
      }
  
      return sortedValues[sortedValues.length - k];
    }
  
    /**
    inOrderTraversal(node, values): This is a helper function that performs an in-order traversal of the BST and stores the sorted values in the given array. It recursively visits the left subtree, then the current node, and finally the right subtree. The time complexity of this function is O(n), where n is the number of nodes in the tree, as it needs to visit each node exactly once. The space complexity is O(n) since it uses the array to store the values.
     * @param {Node} node - The current node being traversed
     * @param {Array} values - The array to store the sorted values
     */
    inOrderTraversal(node, values) {
      if (node !== null) {
        this.inOrderTraversal(node.left, values);
        values.push(node.value);
        this.inOrderTraversal(node.right, values);
      }
    }
  }
  // Sample input and imlplementation
  /**
        5
      /   \
     3     7
    / \   / \
   2   4 6   8

    Now, let's find the 3rd largest value in the BST.

    The sorted order of the tree is [2, 3, 4, 5, 6, 7, 8].

    The 3rd largest value is 6.

    Here's the updated tree with the 3rd largest value marked:
        5
      /   \
     3     7
    / \   / \
   2   4 6*  8
 
   As you can see, the 3rd largest value, 6, is marked with an asterisk (*).

   */
  // Create a new instance of BST
const bst = new BST();

// Insert nodes into the BST
bst.insert(5);
bst.insert(3);
bst.insert(7);
bst.insert(2);
bst.insert(4);
bst.insert(6);
bst.insert(8);

// Find the 3rd largest value
const kthLargest = bst.findKthLargest(3);
console.log(kthLargest); // Output: 6
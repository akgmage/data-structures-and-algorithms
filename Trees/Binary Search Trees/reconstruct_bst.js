/** Reconstruct BST
	The pre-order traversal of a Binary Tree is a traversal technique that starts at the tree's root 
        node and visits nodes in the following order:
		Current Node
		Left Subtree
		Right Subtree

  	Given a non-empty array of integers representing the pre-order traversal of a Binary Search Tree 
        (BST), write a function that creates the relevant BST and returns its root node.

        The input array will contain the values of BST nodes in the order in which these nodes would be 
        visited with a pre-order traversal.
	Sample Input: [10, 4, 2, 1, 5, 17, 19, 18]
	Sample Output:
	      10
      /    \
     4      17
   /   \      \
  2     5     19
 /           /
1           18         
*/
/**
 * Class representing a node in the Binary Search Tree (BST).
 */
 class TreeNode {
    /**
     * Create a new TreeNode.
     * @param {*} value - The value to be stored in the node.
     */
    constructor(value) {
      this.val = value;
      this.left = null;
      this.right = null;
    }
  }
  
  /**
   * Reconstructs a Binary Search Tree (BST) from its pre-order traversal.
   * @param {number[]} preorder - The pre-order traversal array of the BST.
   * @return {TreeNode} - The root node of the reconstructed BST.
   */
  function constructBST(preorder) {
    // Base case: if the array is empty, return null
    if (preorder.length === 0) {
      return null;
    }
  
    // The first element in the pre-order array is the root value
    const rootValue = preorder[0];
    const rootNode = new TreeNode(rootValue);
  
    // Find the index where the elements are greater than the root value
    let i = 1;
    while (i < preorder.length && preorder[i] < rootValue) {
      i++;
    }
  
    // Split the remaining elements into left and right subtrees
    const leftSubtree = preorder.slice(1, i);
    const rightSubtree = preorder.slice(i);
  
    // Recursively construct the left and right subtrees
    rootNode.left = constructBST(leftSubtree);
    rootNode.right = constructBST(rightSubtree);
  
    return rootNode;
  }
  
  // Example usage
  const preorder = [10, 4, 2, 1, 5, 17, 19, 18];
  const root = constructBST(preorder);
  
  /**
   * Prints the values of the BST in ascending order using an in-order traversal.
   * @param {TreeNode} node - The root node of the BST.
   */
  function printInOrder(node) {
    if (node === null) {
      return;
    }
  
    printInOrder(node.left);
    console.log(node.val);
    printInOrder(node.right);
  }
  
  // Print the values of the reconstructed BST in ascending order
  printInOrder(root);

/** 
 * The time complexity of the constructBST function can be analyzed as follows:

In each recursive call, we split the pre-order traversal array into two parts based on the root value. This operation takes O(N) time, where N is the number of elements in the array.
Since the function is called recursively for the left and right subtrees, the total time complexity can be expressed as a summation of the work done in each recursive call.
In the worst case, the pre-order traversal array is completely unbalanced, resulting in a linear chain of nodes. In this case, the function will make N recursive calls, each taking O(N) time.
Therefore, the overall time complexity of the constructBST function is O(N^2) in the worst case.
However, in the average case, when the BST is balanced, the time complexity can be approximated as O(NlogN).
 */

/**
 * In each recursive call, the function creates new arrays for the left and right subtrees using the slice method. The space required for these arrays is proportional to the size of the pre-order traversal array.
In the worst case, when the BST is completely unbalanced, the size of the arrays will be O(N), where N is the number of elements in the pre-order traversal array.
Therefore, the overall space complexity of the `constructBST function is O(N) in the worst case.
 */
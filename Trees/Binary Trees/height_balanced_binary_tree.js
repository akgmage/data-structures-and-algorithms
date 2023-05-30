/*
	You're given the root node of a Binary Tree. Write a function that returns true
	if this Binary Tree is height balanced and false if it isn't.

	Explanation:

	The provided code is for checking whether a binary tree is height-balanced or not. Here's how it works:

	- The code defines a `BinaryTree` struct representing a node in a binary tree. Each node has a value and
	pointers to its left and right child nodes.

	- The code also defines a `TreeeInfo` struct to store information about a binary tree. It includes a boolean
	field `isBalanced` indicating whether the tree is balanced or not, and an integer field `height` representing
	the height of the tree.

	- The `HeightBalancedBinaryTree` function is the main function that checks if a binary tree is height-balanced.
	It takes the root of the tree as input and returns a boolean value indicating the balance status.

	- The `getTreeInfo` function is a helper function that recursively calculates the information of a binary tree.
	It takes a binary tree node as input and returns the `TreeeInfo` struct containing the balance status and height
	of the tree.

	- In the `getTreeInfo` function, there are two base cases:
	- If the current tree node is `nil`, it is considered balanced with height -1.
	- If the current tree node is not `nil`, the function recursively calculates the tree information of its
	left and right subtrees.

	- After getting the information of the left and right subtrees, the code checks if both subtrees are balanced
	(`isBalanced` field is `true`) and their height difference is at most 1. If so, the current tree is considered
	balanced.

	- The height of the current tree is calculated by taking the maximum height of the left and right subtrees and
	adding 1.

	- Finally, the `max` function is used to get the maximum of two integers, and the `abs` function is used to get
	the absolute value of an integer.

	To determine whether a binary tree is height-balanced, you can call the `HeightBalancedBinaryTree` function with
	the root of the tree. It will return `true` if the tree is balanced and `false` otherwise.

	The time complexity of the `HeightBalancedBinaryTree` function is O(N), where N is the number of nodes in the
	binary tree. This is because the function needs to traverse each node of the tree once to calculate the tree
	information.

	The space complexity of the `HeightBalancedBinaryTree` function is O(H), where H is the height of the binary tree.
	This is because the recursive calls to the `getTreeInfo` function will utilize the call stack, and the maximum
	depth of the recursive calls is equal to the height of the tree. Additionally, the space complexity of the
	`getTreeInfo` function itself is O(1) as it uses a constant amount of space for the `TreeeInfo` struct.

	Overall, the space complexity is determined by the height of the binary tree, and the time complexity is
	determined by the number of nodes in the binary tree.

*/
// Node class represents a node in a binary tree
class BinaryTree {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

// TreeInfo class represents the information of a binary tree, including its balance status and height
class TreeInfo {
  constructor(isBalanced, height) {
    this.isBalanced = isBalanced;
    this.height = height;
  }
}

// heightBalancedBinaryTree checks if a binary tree is height-balanced
function heightBalancedBinaryTree(tree) {
  // Retrieve the tree information using the helper function
  const treeInfo = getTreeInfo(tree);

  // Return the balance status of the tree
  return treeInfo.isBalanced;
}

// getTreeInfo retrieves the information of a binary tree, including its balance status and height
function getTreeInfo(tree) {
  // Base case: If the tree is null, it is considered balanced with height -1
  if (tree === null) {
    return new TreeInfo(true, -1);
  }

  // Recursively calculate the tree information of the left and right subtrees
  const leftSubtreeInfo = getTreeInfo(tree.left);
  const rightSubtreeInfo = getTreeInfo(tree.right);

  // Check if both left and right subtrees are balanced and their height difference is at most 1
  const isBalanced =
    leftSubtreeInfo.isBalanced &&
    rightSubtreeInfo.isBalanced &&
    Math.abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1;

  // Calculate the height of the current tree by taking the maximum height of the left and right subtrees plus 1
  const height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;

  // Create and return the tree information
  return new TreeInfo(isBalanced, height);
}

// Helper function to create a binary tree
function createBinaryTree(value) {
  return new BinaryTree(value);
}

// Main function
function main() {
  // Create a sample binary tree
  //          1
  //        /   \
  //       2     3
  //      / \   /
  //     4   5 6
  const node1 = createBinaryTree(1);
  const node2 = createBinaryTree(2);
  const node3 = createBinaryTree(3);
  const node4 = createBinaryTree(4);
  const node5 = createBinaryTree(5);
  const node6 = createBinaryTree(6);

  node1.left = node2;
  node1.right = node3;
  node2.left = node4;
  node2.right = node5;
  node3.left = node6;

  // Check if the binary tree is height-balanced
  const isBalanced = heightBalancedBinaryTree(node1);

  // Print the result
  if (isBalanced) {
    console.log("The binary tree is height-balanced.");
  } else {
    console.log("The binary tree is not height-balanced.");
  }
}

// Call the main function
main();

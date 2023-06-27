/*
  Write a function that takes in a Binary Search Tree (BST) and a target integer
  value and returns the closest value to that target value contained in the BST.

Sample Input : 12

  		 10
       /     \
      5      15
    /   \   /   \
   2     5 13   22
 /           \
1            14
Output : 13

    Explanation:
    
    The code defines a BST (Binary Search Tree) class with member functions to find the closest value to a given target value. 
    The findClosestValue function is the public interface that initializes the closest value with the root value and calls 
    the helper function. The findClosestValueHelper function recursively traverses the tree, updating the closest value based 
    on the absolute difference between the target and the current node value. It then continues the search in the appropriate 
    subtree based on the comparison with the target value. The absDiff function calculates the absolute difference between two 
    integers.

	Time and Space complexity:

	Average: O(log(n)) time | O(1) space - where n is the number of nodes in the BST
	Worst: O(n) time | O(1) space - where n is the number of nodes in the BST
*/
class BST {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  findClosestValue(target) {
    // Call the helper function with the initial closest value as the root value
    return this._findClosestValueHelper(target, this.value);
  }

  _findClosestValueHelper(target, closest) {
    // Compare the absolute difference between the target and the current closest value
    // with the absolute difference between the target and the current node value
    if (Math.abs(target - closest) > Math.abs(target - this.value)) {
      closest = this.value;
    }

    // Look for the target in the left subtree if the target is smaller than the current node value
    if (target < this.value && this.left) {
      return this.left._findClosestValueHelper(target, closest);
    }
    // Look for the target in the right subtree if the target is greater than the current node value
    else if (target > this.value && this.right) {
      return this.right._findClosestValueHelper(target, closest);
    }

    return closest;
  }
}

// Create a BST instance
const bst = new BST(10);
bst.left = new BST(5);
bst.right = new BST(15);
bst.left.left = new BST(2);
bst.left.right = new BST(5);
bst.right.left = new BST(13);
bst.right.right = new BST(22);
bst.left.left.left = new BST(1);
bst.right.left.right = new BST(14);

// Find the closest value to the target
const target = 12;
const closestValue = bst.findClosestValue(target);

// Print the result
console.log(`The closest value to ${target} is ${closestValue}`);

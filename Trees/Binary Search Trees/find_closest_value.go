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
package main

type BST struct {
	Value int

	Left  *BST
	Right *BST
}

func (tree *BST) FindClosestValue(target int) int {
	// call helper function
    return tree.findClosestValue(target, tree.Value)
}

func (tree *BST) findClosestValue(target, closest int) int {
    if absDiff(target, closest) > absDiff(target, tree.Value) {
        closest = tree.Value
    }
	// look for target in left sub tree
    if target < tree.Value && tree.Left != nil {
        return tree.Left.findClosestValue(target, closest)
    } else if target > tree.Value && tree.Right != nil {
		// // look for target in right sub tree
        return tree.Right.findClosestValue(target, closest)
    }
    return closest
}

func absDiff(a, b int) int {
    if a > b {
        return a - b
    }
    return b - a
}

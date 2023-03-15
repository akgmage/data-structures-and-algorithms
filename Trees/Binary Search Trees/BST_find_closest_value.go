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
	// Write your code here.
    return tree.findClosestValue(target, tree.Value)
}

func (tree *BST) findClosestValue(target, closest int) int {
    if absDiff(target, closest) > absDiff(target, tree.Value) {
        closest = tree.Value
    }
    if target < tree.Value && tree.Left != nil {
        return tree.Left.findClosestValue(target, closest)
    } else if target > tree.Value && tree.Right != nil {
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

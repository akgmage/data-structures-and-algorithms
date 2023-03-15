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

/*
	Explanation:

	This code snippet implements a solution for finding the youngest common ancestor of two descendants in an ancestral tree.

	- `type AncestralTree struct` defines the structure of a node in the ancestral tree, which contains a name and a
	reference to its ancestor node.

	- `func GetYoungestCommonAncestor` is the main function that takes three parameters: `topAncestor` (the topmost ancestor
		in the tree), `descendantOne` (the first descendant), and `descendantTwo` (the second descendant). It calculates the depths of the two descendants from the top ancestor and then calls the `backTrackAncestralTree` function with the appropriate parameters.

	- `func getDescendantDepth` calculates the depth of a descendant node from the top ancestor. It iteratively increments the
	depth and traverses through the ancestors until reaching the top ancestor.

	- `func backTrackAncestralTree` is a helper function that backtracks the ancestral tree starting from the lowest descendant
	until the depths of both descendants are equal. It first adjusts the position of the lowest descendant based on the depth difference between the two descendants. Then, it moves both descendants up the tree in tandem until they reach the same ancestor node, which is the youngest common ancestor.

	The code assumes that the `topAncestor` provided is a valid ancestor of both `descendantOne` and `descendantTwo`.
	The `GetYoungestCommonAncestor` function returns the youngest common ancestor found in the ancestral tree.

	To use this code, you need to create instances of the `AncestralTree` struct representing the ancestral tree and its nodes.
	You can then call the `GetYoungestCommonAncestor` function with the appropriate parameters to find the youngest common
	ancestor of two descendants.
*/
package main

type AncestralTree struct {
	Name     string
	Ancestor *AncestralTree
}

func GetYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo *AncestralTree) *AncestralTree {
	depthOne := getDescendantDepth(descendantOne, topAncestor)
	depthTwo := getDescendantDepth(descendantTwo, topAncestor)
	if depthOne > depthTwo {
		return backTrackAncestralTree(descendantOne, descendantTwo, depthOne-depthTwo)
	}
	return backTrackAncestralTree(descendantTwo, descendantOne, depthTwo-depthOne)
}

func getDescendantDepth(descendant, topAncestor *AncestralTree) int {
	depth := 0
	for descendant != topAncestor {
		depth++
		descendant = descendant.Ancestor
	}
	return depth
}

func backTrackAncestralTree(lowestDescendant, higherDescendant *AncestralTree, diff int) *AncestralTree {
	for diff > 0 {
		lowestDescendant = lowestDescendant.Ancestor
		diff--
	}
	for lowestDescendant != higherDescendant {
		lowestDescendant = lowestDescendant.Ancestor
		higherDescendant = higherDescendant.Ancestor
	}
	return lowestDescendant
}
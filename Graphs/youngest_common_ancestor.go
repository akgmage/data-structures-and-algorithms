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
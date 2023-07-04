/*

  	Write a function that returns the youngest common ancestor to the two descendants.

	Sample Input:
	Top ancestor: node A
	descendantOne: node e
	descandantTwo: node I

	Output: node B
          A
       /     \
      B       C
    /   \   /   \
   D     E F     G
 /   \
H     I
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

	O(d) time | O(1) space - where d is the depth (height) of the ancestral tree
*/
package main

import "fmt"

type AncestralTree struct {
	Name     string
	Ancestor *AncestralTree
}

// GetYoungestCommonAncestor finds the youngest common ancestor of two descendants in an ancestral tree.
func GetYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo *AncestralTree) *AncestralTree {
	// Calculate the depths of the two descendants from the top ancestor
	depthOne := getDescendantDepth(descendantOne, topAncestor)
	depthTwo := getDescendantDepth(descendantTwo, topAncestor)

	if depthOne > depthTwo {
		// If depthOne is greater, backtrack the ancestral tree from descendantOne to align the depths
		return backTrackAncestralTree(descendantOne, descendantTwo, depthOne-depthTwo)
	}

	// If depthTwo is greater or both depths are equal, backtrack the ancestral tree from descendantTwo
	// to align the depths
	return backTrackAncestralTree(descendantTwo, descendantOne, depthTwo-depthOne)
}

// getDescendantDepth calculates the depth of a descendant node from the top ancestor.
func getDescendantDepth(descendant, topAncestor *AncestralTree) int {
	depth := 0
	for descendant != topAncestor {
		depth++
		descendant = descendant.Ancestor
	}
	return depth
}

// backTrackAncestralTree backtracks the ancestral tree to find the youngest common ancestor.
func backTrackAncestralTree(lowestDescendant, higherDescendant *AncestralTree, diff int) *AncestralTree {
	// Adjust the position of the lowest descendant based on the depth difference
	for diff > 0 {
		lowestDescendant = lowestDescendant.Ancestor
		diff--
	}

	// Move both descendants up the tree until they reach the same ancestor node
	for lowestDescendant != higherDescendant {
		lowestDescendant = lowestDescendant.Ancestor
		higherDescendant = higherDescendant.Ancestor
	}

	return lowestDescendant
}


func main() {
	// Create the ancestral tree
	topAncestor := &AncestralTree{Name: "A"}
	B := &AncestralTree{Name: "B", Ancestor: topAncestor}
	C := &AncestralTree{Name: "C", Ancestor: topAncestor}
	D := &AncestralTree{Name: "D", Ancestor: B}
	F := &AncestralTree{Name: "F", Ancestor: C}
	I := &AncestralTree{Name: "I", Ancestor: D}

	descendantOne := F
	descendantTwo := I
	yca := GetYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo)

	fmt.Printf("The youngest common ancestor of %s and %s is %s.\n", descendantOne.Name, descendantTwo.Name, yca.Name)
}
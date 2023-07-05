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
class AncestralTree {
  constructor(name) {
    this.name = name;
    this.ancestor = null;
  }
}

// Function to calculate the depth of a descendant from the top ancestor
function getDescendantDepth(descendant, topAncestor) {
  let depth = 0;
  while (descendant !== topAncestor) {
    depth += 1;
    descendant = descendant.ancestor;
  }
  return depth;
}

// Function to backtrack and find the youngest common ancestor
function backTrackAncestralTree(lowestDescendant, higherDescendant, diff) {
  while (diff > 0) {
    lowestDescendant = lowestDescendant.ancestor;
    diff -= 1;
  }
  while (lowestDescendant !== higherDescendant) {
    lowestDescendant = lowestDescendant.ancestor;
    higherDescendant = higherDescendant.ancestor;
  }
  return lowestDescendant;
}

// Function to find the youngest common ancestor of two descendants
function getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo) {
  const depthOne = getDescendantDepth(descendantOne, topAncestor);
  const depthTwo = getDescendantDepth(descendantTwo, topAncestor);

  if (depthOne > depthTwo) {
    return backTrackAncestralTree(
      descendantOne,
      descendantTwo,
      depthOne - depthTwo
    );
  }
  return backTrackAncestralTree(
    descendantTwo,
    descendantOne,
    depthTwo - depthOne
  );
}

// Create the ancestral tree
const topAncestor = new AncestralTree("A");
const B = new AncestralTree("B");
const C = new AncestralTree("C");
const D = new AncestralTree("D");
const E = new AncestralTree("E");
const F = new AncestralTree("F");
const G = new AncestralTree("G");
const H = new AncestralTree("H");
const I = new AncestralTree("I");

// Set up the ancestral relationships

//          A
//        /   \
//       B     C
//      / \   / \
//     D   E F   G
//    /
//   H
//  /
// I

topAncestor.ancestor = null;
B.ancestor = topAncestor;
C.ancestor = topAncestor;
D.ancestor = B;
E.ancestor = B;
F.ancestor = C;
G.ancestor = C;
H.ancestor = D;
I.ancestor = H;

// Find the youngest common ancestor of two descendants
const descendantOne = F;
const descendantTwo = I;
const yca = getYoungestCommonAncestor(
  topAncestor,
  descendantOne,
  descendantTwo
);

console.log(
  "The youngest common ancestor of",
  descendantOne.name,
  "and",
  descendantTwo.name,
  "is",
  yca.name
);

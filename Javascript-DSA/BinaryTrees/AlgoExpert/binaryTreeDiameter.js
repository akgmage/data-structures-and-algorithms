class BinaryTree {
	constructor(value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

class TreeInfo {
	constructor(diameter, height) {
		this.diameter = diameter;
		this.height = height;
	}
}

//! O(n) time | O(h) space
function binaryTreeDiameter(tree) {
	return getTreeInfo(tree).diameter;
}

function getTreeInfo(tree) {

	if(!tree) return new TreeInfo(0, 0);

	const leftTreeInfo = getTreeInfo(tree.left);
	const rightTreeInfo = getTreeInfo(tree.right);

	const longestPathThroughRoot = leftTreeInfo.height + rightSubTree.height;
	const maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);

	const currentDiameter = Math.max(maxDiameterSoFar, longestPathThroughRoot);
	const currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

	return new TreeInfo(currentDiameter, currentHeight);
}


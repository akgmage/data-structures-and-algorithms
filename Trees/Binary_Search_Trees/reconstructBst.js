//! aka pre-order to BST

//! O(n) time | O(n) space

class BST {
    constructor(value, left = null, right = null) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class TreeInfo {
    constructor(rootIdx) {
        this.rootIdx = rootIdx;
    }
}

function reconstructBst(preOrderTraversalValues) {
    const treeInfo = new TreeInfo(0);
    return reconstructBstFromRange(-Infinity, Infinity, preOrderTraversalValues, treeInfo);
}

function reconstructBstFromRange(lowerBound, upperBound, preOrderTraversalValues, currentSubtreeInfo) {
    if(currentSubtreeInfo.rootIdx == preOrderTraversalValues.length) return null;

    const rootValue = preOrderTraversalValues[currentSubtreeInfo.rootIdx];
    if(rootValue < lowerBound || rootValue >= upperBound) return null;

    currentSubtreeInfo.rootIdx++;

    const leftSubtree = reconstructBstFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubtreeInfo);
    const rightSubtree = reconstructBstFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubtreeInfo);

    return new BST(rootValue, leftSubtree, rightSubtree);
}


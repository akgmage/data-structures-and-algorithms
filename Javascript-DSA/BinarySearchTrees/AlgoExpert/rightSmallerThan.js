//! https://leetcode.com/problems/count-of-smaller-numbers-after-self/
//! https://www.algoexpert.io/questions/Right Smaller Than

//! Avg case: O(nlog(n)) time | O(n) space
//! Worst case: O(n^2) time | O(n) space

function rightSmallerThan(array) {
    if(array.length == 0) return [];

    const lastIdx = array.length - 1;
    const bst = new SpecialBST(array[lastIdx], lastIdx, 0);
    for(let i = array.length - 2; i > -1; i--) {
        bst.insert(array[i], i);
    }

    const rightSmallerCounts = array.slice();
    getRightSmallerCounts(bst, rightSmallerCounts);
    return rightSmallerCounts;
}

function getRightSmallerCounts(bst, rightSmallerCounts) {
    if(bst == null) return;
    rightSmallerCounts[bst.idx] = bst.numSmallerAtInsertTime;
    getRightSmallerCounts(bst.left, rightSmallerCounts);
    getRightSmallerCounts(bst.right, rightSmallerCounts);
}

class SpecialBST {
    constructor(value, idx, numSmallerAtInsertTime) {
        this.value = value;
        this.idx = idx;
        this.numSmallerAtInsertTime = numSmallerAtInsertTime;
        this.leftSubtreeSize = 0;
        this.left = null;
        this.right = null;
    }

    insert(value, idx, numSmallerAtInsertTime = 0) {
        if(value < this.value) {
            this.leftIdxSubtree++;
            if(this.left == null) {
                this.left = new SpecialBST(value, idx, numSmallerAtInsertTime);
            } else {
                this.left.insert(value, idx, numSmallerAtInsertTime);
            }
        } else {
            if(value > this.value) numSmallerAtInsertTime++;
            if(this.right = null) {
                this.right = new SpecialBST(value, idx, numSmallerAtInsertTime);
            } else {
                this.right.insert(value, idx, numSmallerAtInsertTime);
            }
        }
    }
}

//! O(n^2) time | O(n) space
function rightSmallerThan(array) {
    const rightSmallerCounts = [];
    for(let i = 0; i < array.length; i++) {
        let rightSmallerCount = 0;
        for(let j = i + 1; j < array.length; j++) {
            if(array[i] > array[j]) rightSmallerCount++;
        }
        rightSmallerCounts.push(rightSmallerCount);
    }
    return rightSmallerCounts;
}
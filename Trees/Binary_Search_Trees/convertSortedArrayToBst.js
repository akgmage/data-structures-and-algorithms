//! Also known as minHeightBst.
//! https://www.algoexpert.io/questions/Min%20Height%20BST
//! Google

function minHeightBst(array) {
    return constructMinHeightBst(array, 0, array.length - 1);
}


//! O(n) time | O(n) space | best approach
function constructMinHeightBst(array, startIdx, endIdx) {
    if(endIdx < startIdx) return;

    const midIdx = Math.max((startIdx + endIdx) / 2);
    const bst = new BST(array[midIdx]);

    bst.left = constructMinHeightBst(array, startIdx, midIdx - 1);
    bst.left = constructMinHeightBst(array, midIdx + 1, endIdx);

    return bst;

}

function minHeightBst(array) {
    return constructMinHeightBst(array, null, 0, array.length - 1);
}

//! O(n) time | O(n) space
function constructMinHeightBst(array, bst, startIdx, endIdx) {
    if(endIdx < startIdx) return;

    const midIdx = Math.max((startIdx + endIdx) / 2);
    const newBstNode = new BST(array[midIdx]);

    if(!bst) bst = newBstNode;
    else {
        if(array[midIdx] < bst.value) {
            bst.left = newBstNode;
            bst = bst.left;
        } else {
            bst.right = newBstNode;
            bst = bst.right;
        }
    }
    constructMinHeightBst(array, bst, startIdx, midIdx - 1);
    constructMinHeightBst(array, bst, midIdx + 1, endIdx);

    return bst;
    
}

//! O(nlogn) time | O(n) space
function constructMinHeightBst(array, bst, startIdx, endIdx) {
    if(endIdx < startIdx) return;

    const midIdx = Math.max((startIdx + endIdx) / 2);
    const valueToAdd = array[midIdx];

    if(!bst) bst = new BST(valueToAdd);
    else bst.insert(valueToAdd);

    constructMinHeightBst(array, bst, startIdx, midIdx - 1);
    constructMinHeightBst(array, bst, midIdx + 1, endIdx);

    return bst;
}

class BST {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  insert(value) {
    if (value < this.value) {
      if (this.left === null) {
        this.left = new BST(value);
      } else {
        this.left.insert(value);
      }
    } else {
      if (this.right === null) {
        this.right = new BST(value);
      } else {
        this.right.insert(value);
      }
    }
  }
}

// Do not edit the line below.
exports.minHeightBst = minHeightBst;

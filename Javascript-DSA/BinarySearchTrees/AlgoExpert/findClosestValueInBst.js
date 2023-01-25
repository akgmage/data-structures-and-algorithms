
function findClosestValueInBst(tree, target) {
  return findClosestValueInBstHelper(tree, target, tree.value);
}

//! worst case O(n)time | O(1) space
//! Avg case O(nlogn) time | O(1) space
function findClosestValueInBstHelper(tree, target, closest) {

  let currentNode = tree;

  while(currentNode) {
    if(Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
        closest = currentNode.value;
    }

    if(target < currentNode.value) {
      currentNode = currentNode.left;
    } else if(target > currentNode.value) {
      currentNode = currentNode.right;
    } else {
       break;
    }
    return closest;
  }
}

//! worst case O(n)time | O(n) space
//! Avg case O(nlogn) time | O(logn) space
function findClosestValueInBstHelper(tree, target, closest) {
  if(!tree) return closest;
  
  if(Math.abs(target - closest) > Math.abs(target - tree.value)) {
    closest = tree.value;
  }

  if(target < tree.value) {
    return findClosestValueInBstHelper(tree.left, target, closest);
  } else if(target > tree.value) {
    return findClosestValueInBstHelper(tree.right, target, closest);
  }
  return closest;

}
class BST {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

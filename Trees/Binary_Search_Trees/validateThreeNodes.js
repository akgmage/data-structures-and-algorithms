
//! O(h) time | (h) space 
function validateThreeNodes(nodeOne, nodeTwo, nodeThree) {

    if(isDescedant(nodeTwo, nodeOne)) return isDescedant(nodeTwo, nodeThree);

    if(isDescedant(nodeTwo, nodeThree)) return isDescedant(nodeOne, nodeTwo);

    return false; 
}

function isDescedant(node, target) {
    if(!node) return false;

    if(node == target) return true;

    return target.value < node.value ? isDescedant(node.left, target) : isDescedant(node.right, target);
}
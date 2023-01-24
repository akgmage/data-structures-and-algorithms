//! 15/02/2022

function isBST(root) {
    if(root == null) {
        return {max: Number.MIN_SAFE_INTEGER, min: Number.MAX_SAFE_INTEGER, isBst: true}
    }
    
    let left = isBST(root.left);
    let right = isBST(root.right);
    if(left.isBst == true && right.isBst == true && root.data > left.max && root.data < right.min) {
        return {
            max: Math.max(left.max, right.max, root.data),
            min: Math.min(left.min, right.min, root.data),
            isBst: true
        }
    } else {
        return {
            max: Math.max(left.max, right.max, root.data),
            min: Math.min(left.min, right.min, root.data),
            isBst: false
        }
    }
}
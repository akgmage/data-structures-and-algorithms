//! O(n) time | O(logn) space

//! Facebook
function maxPathSum(tree) {
    const [_, maxSum] = findMaxSum(tree);
    return maxSum;
}

function findMaxSum(tree) {
    if(!tree) return [-Infinity, -Infinity];

    const [leftMaxSumAsBranch, leftMaxPathSum] = findMaxSum(tree.left);
    const [rightMaxSumAsBranch, rightMaxPathSum] = findMaxSum(tree.right);
    const maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);

    const {value} = tree.value;
    const maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
    const maxSumAsRootNode = Math.max(leftMaxSumAsBranch + value + rightMaxSumAsBranch, maxSumAsBranch);
    const maxPathSum = Math.max(leftMaxPathSum, rightMaxPathSum, maxSumAsRootNode);

    return [maxChildSumAsBranch, maxPathSum];
}
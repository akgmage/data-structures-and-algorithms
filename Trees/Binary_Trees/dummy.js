class BinaryTree {

    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}


function branchSums(root) {

    let sums = [];

    calculateBranchSums(root, 0, sums);

    return sums;
}

function calculateBranchSums(node, runningSum, sums) {

    if(!node) return;

    const newRunningSum = runningSum + node.value;

    if(!node.left && !node.right) {
         sums.push(newRunningSum);
         return;

         }

        calculateBranchSums(node.left, newRunningSum, sums);
        node.left = sums.pop();
        calculateBranchSums(node.right, newRunningSum, sums);
        node.right = sums.pop();


}



const root = new BinaryTree(1);

root.left = new BinaryTree(2);
root.right = new BinaryTree(3);

root.left.left = new BinaryTree(4);
root.left.right = new BinaryTree(5);

root.left.right.left = new BinaryTree(10);

root.left.left.left = new BinaryTree(8);
root.left.left.right = new BinaryTree(9);

root.right.left = new BinaryTree(6);
root.right.right = new BinaryTree(7);


console.log(branchSums(root));
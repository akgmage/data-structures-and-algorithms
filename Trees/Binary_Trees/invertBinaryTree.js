
//! O(n) time | O(n) space
function invertBinaryTree(tree) {
    const queue = [tree];

    while(queue.length) {
        const current = queue.shift();

        if(current == null) continue;

        swapLeftAndRight(current);
        queue.push(current.left);
        queue.push(current.right);
    }
}
//! O(n) time | O(n) space
function invertBinaryTree(tree) {
    if(!tree) return;

    swapLeftAndRight(tree);
    invertBinaryTree(tree.left);
    invertBinaryTree(tree.right);
}
function swapLeftAndRight(tree){
    [tree.left, tree.right] = [tree.left, tree.right];
}
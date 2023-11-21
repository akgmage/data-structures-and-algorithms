/*
  Write a function that takes in a Binary Tree and returns if that tree is symmetrical. A tree is symmetrical 
  if the left and right subtrees are mirror images of each other.
*/
import java.util.Stack;

public class BinaryTree {
    // Assume that BinaryTree has properties: left, right, and value.

    public boolean isSymmetricalTreeIterative(BinaryTree tree) {
        Stack<BinaryTree> stackLeft = new Stack<>();
        Stack<BinaryTree> stackRight = new Stack<>();

        // Initialize stackLeft with the left child of the root node
        // Initialize stackRight with the right child of the root node
        stackLeft.push(tree.getLeft());
        stackRight.push(tree.getRight());

        // Perform mirror traversal of the left and right subtrees
        while (!stackLeft.isEmpty()) {
            BinaryTree left = stackLeft.pop();
            BinaryTree right = stackRight.pop();

            if (left == null && right == null) {
                continue; // Both left and right subtrees are symmetric, continue to the next iteration
            }

            if (left == null || right == null || left.getValue() != right.getValue()) {
                return false; // Asymmetry detected, tree is not symmetric
            }

            // Push the children of left and right onto the respective stacks in reverse order
            stackLeft.push(left.getLeft());
            stackLeft.push(left.getRight());

            stackRight.push(right.getRight());
            stackRight.push(right.getLeft());
        }

        return true; // Tree is symmetric
    }

    // Other methods and properties for BinaryTree class
}

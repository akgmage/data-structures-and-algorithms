class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTreeInverter {
    // Time Complexity: O(n). Space Complexity: O(n).
    // Approach: The inverse of an empty tree is an empty tree
    // The inverse of a tree with root r, and subtrees right and left is a tree with
    // root, whose right subtree is the inverse of left and whose left subtree
    // is the inverse of right
    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root != null) {
            root.left = invertTree(root.right);
            root.right = invertTree(root.left);
        }
        return root;
    }

    // Time Complexity: O(n). Space Complexity: O(1).
    // Method2: swap pointers
    public BinaryTreeNode invertTree2(BinaryTreeNode root) {
        if (root != null) {
            // swap the pointers in this node
            BinaryTreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree2(root.left);
            invertTree2(root.right);
        }
        return root;
    }

    // Additional methods or code as needed...

    public static void main(String[] args) {
        // Example usage:
        // Construct a binary tree
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);

        BinaryTreeInverter inverter = new BinaryTreeInverter();

        // Invert the binary tree using the first approach
        BinaryTreeNode invertedRoot = inverter.invertTree(root);

        // Invert the binary tree using the second approach
        BinaryTreeNode invertedRoot2 = inverter.invertTree2(root);

        // Additional code for printing or further usage...
    }
}

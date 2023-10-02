/*
    Reconstruct BST
	The pre-order traversal of a Binary Tree is a traversal technique that starts at the tree's root node and visits nodes in the following order:
		Current Node
		Left Subtree
		Right Subtree

  	Given a non-empty array of integers representing the pre-order traversal of a Binary Search Tree (BST),
	write a function that creates the relevant BST and returns its root node.

    The input array will contain the values of BST nodes in the order in which these nodes would be visited with a pre-order traversal.

	Sample Input: [10, 4, 2, 1, 5, 17, 19, 18]
	Sample Output:
	    10
      /    \
     4      17
   /   \      \
  2     5     19
 /           /
1           18

    The ReconstructBst function takes a slice preOrderTraversalValues which represents the pre-order traversal of a binary search tree.
	It reconstructs the BST using a range-based approach. Here's how the algorithm works:

	The ReconstructBst function initializes a treeInfo struct to keep track of the current root index.

	The ReconstructBst function calls the reconstructBSTFromRange helper function, passing the minimum and maximum integer values
	as the initial range, the pre-order traversal values, and the treeInfo struct.

	The reconstructBSTFromRange function first checks if the current root index has reached the end of the pre-order traversal values.
	If so, it returns nil indicating an empty subtree.

	It retrieves the value of the current root from the pre-order traversal values.

	It checks if the root value is outside the valid range defined by the lower and upper bounds. If so, it returns

	The time complexity of the ReconstructBst function is O(n), where n is the number of nodes in the reconstructed BST.
	This is because the function processes each node exactly once.

	The space complexity of the ReconstructBst function is O(n), where n is the number of nodes in the reconstructed BST.
	This is because the function creates BST nodes and recursively calls itself to construct the left and right subtrees.
	The space complexity is determined by the height of the BST, which can be at most n in the worst case for a skewed BST.

*/
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        value = x;
        left = null;
        right = null;
    }
}

class TreeInfo {
    int rootIdx;

    TreeInfo(int idx) {
        rootIdx = idx;
    }
}

public class ReconstructBST {

    public static TreeNode reconstructBst(int[] preOrderTraversalValues) {
        // Create a TreeInfo object to keep track of the current root index.
        TreeInfo treeInfo = new TreeInfo(0);

        // Call the helper function to reconstruct the BST from the given range and return the result.
        return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    private static TreeNode reconstructBstFromRange(int lowerBound, int upperBound, int[] preOrderTraversalValues, TreeInfo currentSubtreeInfo) {
        // Check if the root index has reached the end of the pre-order traversal values. If so, return null indicating an empty subtree.
        if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.length) {
            return null;
        }

        // Get the value of the current root from the pre-order traversal values.
        int rootValue = preOrderTraversalValues[currentSubtreeInfo.rootIdx];

        // Check if the root value is out of the valid range defined by the lower and upper bounds. If so, return null indicating an invalid subtree.
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }

        // Increment the root index to move to the next element in the pre-order traversal values.
        currentSubtreeInfo.rootIdx++;

        // Recursively reconstruct the left subtree within the range (lowerBound, rootValue) using the updated root index.
        TreeNode leftSubtree = reconstructBstFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubtreeInfo);

        // Recursively reconstruct the right subtree within the range (rootValue, upperBound) using the updated root index.
        TreeNode rightSubtree = reconstructBstFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubtreeInfo);

        // Create a new TreeNode with the current root value and the reconstructed left and right subtrees.
        TreeNode rootNode = new TreeNode(rootValue);
        rootNode.left = leftSubtree;
        rootNode.right = rightSubtree;

        return rootNode;
    }

    public static void main(String[] args) {
        int[] preOrderTraversalValues = {10, 5, 2, 7, 15, 12, 20};
        TreeNode root = reconstructBst(preOrderTraversalValues);

        // Printing the reconstructed BST is left as an exercise
    }
}

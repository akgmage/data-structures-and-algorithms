/*
	Write a function that takes in a Binary Tree and returns its diameter. The diameter of a binary tree
	is defined as the length of its longest path, even if that path doesn't pass through the root of the tree.

	Sample Input :
	          1
            /   \
           3     2
         /   \
        7     4
       /       \
      8         5
     /           \
    9             6
	Output: 6
	Diameter being 9 -> 8 -> 7 -> 3 -> 4 -> 5 -> 6

	Explanation:
	This code calculates the diameter of a binary tree, which is defined as the length of the longest path between any two
	nodes in the tree. The BinaryTreeDiameter function takes the root of the binary tree as input and returns the diameter.

	The getTreeInfo function is a helper function that recursively calculates the height and diameter of the binary tree.
	It takes a node of the binary tree as input and returns a TreeInfo struct containing the height and diameter of the tree.

	In the getTreeInfo function:

	The base case is when the tree is nil, indicating an empty tree. In this case, it returns a TreeInfo with height 0 and
	diameter 0.

	The height and diameter of the left and right subtrees are calculated recursively by calling getTreeInfo on the left
	and right child nodes.

	The longest path passing through the root node is determined by adding the heights of the left and right subtrees.

	The maximum diameter seen so far is calculated by taking the maximum of the diameters of the left and right subtrees.

	The current diameter is determined by taking the maximum among the longest path through the root and the maximum
	diameter seen so far.

	The current height is calculated by taking the maximum height among the left and right subtrees and adding 1.

	Finally, the function returns a TreeInfo struct with the current height and diameter.
	The max function is a helper function that returns the maximum of two integers.

	Overall, the code effectively calculates the diameter of a binary tree by recursively calculating the height and
	diameter of the tree and considering the longest path passing through the root.

	Average case:
	Time Complexity O(n) when the tree is balanced
	Space complexity: O(h) where n is the number of nodes in the Binary Tree and h is the height of the Binary Tree
*/
public class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;
    
    public BinaryTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class TreeInfo {
    int height;
    int diameter;
    
    public TreeInfo(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}

public class Main {
    // Calculates the diameter of a binary tree.
    public static int binaryTreeDiameter(BinaryTree tree) {
        return getTreeInfo(tree).diameter;
    }
    
    // Recursively calculates the height and diameter of the binary tree.
    private static TreeInfo getTreeInfo(BinaryTree tree) {
        // Base case: If the tree is null, return height 0 and diameter 0.
        if (tree == null) {
            return new TreeInfo(0, 0);
        }
        
        // Recursively calculate the height and diameter of the left and right subtrees.
        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);
        
        // Calculate the longest path passing through the root node.
        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
        
        // Calculate the maximum diameter seen so far.
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
        
        // Calculate the current diameter, which is the maximum among the longest path through root and max diameter so far.
        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        
        // Calculate the current height, which is the maximum height among the left and right subtrees plus 1.
        int currentHeight = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
        
        // Return the current height and diameter as the tree information.
        return new TreeInfo(currentHeight, currentDiameter);
    }
    
    public static void main(String[] args) {
        // Example usage
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        
        int diameter = binaryTreeDiameter(tree);
        System.out.println("Diameter of the binary tree: " + diameter);
    }
}

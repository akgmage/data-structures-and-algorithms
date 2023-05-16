////// Explanation:
// To validate a Binary Search Tree (BST), we need to ensure that the values of nodes in the left subtree of any node are less than the value of the node, and the values of nodes in the right subtree are greater than the value of the node. 
// Additionally, the left and right subtrees themselves must also be valid BSTs.

////// Code:
class validateBST {
    public static class Node {
		public int data;
		public Node left, right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	};

	static Node prev;

	static Boolean isBST(Node root) {
	    
		// traverse the tree in inorder fashion and // keep track of prev node
		if (root == null) 
		    return true;
		    
		//If Left Node is not BST then return false
		if (!isBST(root.left)) 
		    return false;
		    
		//Check if current node is less than its parent node
		if (prev != null && root.data <= prev.data) 
		    return false;
		    
        	prev = root;
		return isBST(root.right);
	}

    public static void main(String[] args) {
        
	    //Creating BST 
       	    Node root = new Node(1);
	    root.left = new Node(-2);
	    root.right = new Node(3);
	    root.left.left = new Node(-4);
	    root.left.right = new Node(-1);
	    root.right.left = new Node(2);
	    root.right.right = new Node(7);

		// Function call
		if (isBST(root))
			System.out.println("Is Valid BST");
		else
			System.out.println("Not a Valid BST");
    }
}

////// Complexity:
// Time  Complexity: O(n) where n is number of nodes
// Space Complexity: O(1)

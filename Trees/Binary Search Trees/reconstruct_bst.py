'''
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

'''
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class TreeInfo:
    def __init__(self, root_idx):
        self.root_idx = root_idx

def reconstruct_bst(pre_order_traversal_values):
    # Create a TreeInfo object to keep track of the current root index.
    tree_info = TreeInfo(0)

    # Call the helper function to reconstruct the BST from the given range and return the result.
    return reconstruct_bst_from_range(float('-inf'), float('inf'), pre_order_traversal_values, tree_info)

def reconstruct_bst_from_range(lower_bound, upper_bound, pre_order_traversal_values, current_subtree_info):
    # Check if the root index has reached the end of the pre-order traversal values. If so, return None indicating an empty subtree.
    if current_subtree_info.root_idx == len(pre_order_traversal_values):
        return None

    # Get the value of the current root from the pre-order traversal values.
    root_value = pre_order_traversal_values[current_subtree_info.root_idx]

    # Check if the root value is out of the valid range defined by the lower and upper bounds. If so, return None indicating an invalid subtree.
    if root_value < lower_bound or root_value >= upper_bound:
        return None

    # Increment the root index to move to the next element in the pre-order traversal values.
    current_subtree_info.root_idx += 1

    # Recursively reconstruct the left subtree within the range (lower_bound, root_value) using the updated root index.
    left_subtree = reconstruct_bst_from_range(lower_bound, root_value, pre_order_traversal_values, current_subtree_info)

    # Recursively reconstruct the right subtree within the range (root_value, upper_bound) using the updated root index.
    right_subtree = reconstruct_bst_from_range(root_value, upper_bound, pre_order_traversal_values, current_subtree_info)

    # Create a new TreeNode with the current root value and the reconstructed left and right subtrees.
    root_node = TreeNode(root_value)
    root_node.left = left_subtree
    root_node.right = right_subtree

    return root_node

# Example usage:
pre_order_traversal_values = [10, 5, 2, 7, 15, 12, 20]
tree_info = TreeInfo(0)  # Initialize tree_info with root index 0
root = reconstruct_bst_from_range(float('-inf'), float('inf'), pre_order_traversal_values, tree_info)

# Printing the reconstructed BST is left as an exercise

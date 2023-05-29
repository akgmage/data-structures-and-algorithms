'''
	You're given the root node of a Binary Tree. Write a function that returns true
	if this Binary Tree is height balanced and false if it isn't.

	Explanation:

	The provided code is for checking whether a binary tree is height-balanced or not. Here's how it works:

	- The code defines a `BinaryTree` struct representing a node in a binary tree. Each node has a value and
	pointers to its left and right child nodes.

	- The code also defines a `TreeeInfo` struct to store information about a binary tree. It includes a boolean
	field `isBalanced` indicating whether the tree is balanced or not, and an integer field `height` representing
	the height of the tree.

	- The `HeightBalancedBinaryTree` function is the main function that checks if a binary tree is height-balanced.
	It takes the root of the tree as input and returns a boolean value indicating the balance status.

	- The `getTreeInfo` function is a helper function that recursively calculates the information of a binary tree.
	It takes a binary tree node as input and returns the `TreeeInfo` struct containing the balance status and height
	of the tree.

	- In the `getTreeInfo` function, there are two base cases:
	- If the current tree node is `nil`, it is considered balanced with height -1.
	- If the current tree node is not `nil`, the function recursively calculates the tree information of its
	left and right subtrees.

	- After getting the information of the left and right subtrees, the code checks if both subtrees are balanced
	(`isBalanced` field is `true`) and their height difference is at most 1. If so, the current tree is considered
	balanced.

	- The height of the current tree is calculated by taking the maximum height of the left and right subtrees and
	adding 1.

	- Finally, the `max` function is used to get the maximum of two integers, and the `abs` function is used to get
	the absolute value of an integer.

	To determine whether a binary tree is height-balanced, you can call the `HeightBalancedBinaryTree` function with
	the root of the tree. It will return `true` if the tree is balanced and `false` otherwise.

	The time complexity of the `HeightBalancedBinaryTree` function is O(N), where N is the number of nodes in the
	binary tree. This is because the function needs to traverse each node of the tree once to calculate the tree
	information.

	The space complexity of the `HeightBalancedBinaryTree` function is O(H), where H is the height of the binary tree.
	This is because the recursive calls to the `getTreeInfo` function will utilize the call stack, and the maximum
	depth of the recursive calls is equal to the height of the tree. Additionally, the space complexity of the
	`getTreeInfo` function itself is O(1) as it uses a constant amount of space for the `TreeeInfo` struct.

	Overall, the space complexity is determined by the height of the binary tree, and the time complexity is
	determined by the number of nodes in the binary tree.

'''

# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class TreeInfo:
    def __init__(self, is_balanced, height):
        self.is_balanced = is_balanced
        self.height = height

# Checks if a binary tree is height-balanced.
def height_balanced_binary_tree(tree):
    # Retrieve the tree information using the helper function.
    tree_info = get_tree_info(tree)
    
    # Return the balance status of the tree.
    return tree_info.is_balanced

# Retrieves the information of a binary tree, including its balance status and height.
def get_tree_info(tree):
    # Base case: If the tree is None, it is considered balanced with height -1.
    if tree is None:
        return TreeInfo(True, -1)
    
    # Recursively calculate the tree information of the left and right subtrees.
    left_subtree_info = get_tree_info(tree.left)
    right_subtree_info = get_tree_info(tree.right)
    
    # Check if both left and right subtrees are balanced and their height difference is at most 1.
    is_balanced = left_subtree_info.is_balanced and right_subtree_info.is_balanced and \
        abs(left_subtree_info.height - right_subtree_info.height) <= 1
    
    # Calculate the height of the current tree by taking the maximum height of the left and right subtrees plus 1.
    height = max(left_subtree_info.height, right_subtree_info.height) + 1
    
    # Create and return the tree information.
    return TreeInfo(is_balanced, height)

# Returns the maximum of two integers.
def max(a, b):
    return a if a > b else b

# Returns the absolute value of an integer.
def abs(a):
    return -a if a < 0 else a

# Main function
def main():
    # Create a sample binary tree
    #          1
    #        /   \
    #       2     3
    #      / \   /
    #     4   5 6
    node1 = BinaryTree(1)
    node2 = BinaryTree(2)
    node3 = BinaryTree(3)
    node4 = BinaryTree(4)
    node5 = BinaryTree(5)
    node6 = BinaryTree(6)
    
    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    
    # Check if the binary tree is height-balanced
    is_balanced = height_balanced_binary_tree(node1)
    
    # Print the result
    if is_balanced:
        print("The binary tree is height-balanced.")
    else:
        print("The binary tree is not height-balanced.")

# Call the main function
if __name__ == "__main__":
    main()



'''
	Write a function that takes in a potentially invalid Binary Search Tree (BST) and returns a boolean representing
	whether the BST is valid.

	Explanation:

	This code defines a Binary Search Tree (BST) struct with an integer value and left and right nodes that can point to other
	BST nodes. The struct also has a method called ValidateBst() that returns a boolean indicating whether the tree is a valid
	BST or not.

	The BST struct has another method called validateBST() that is used by ValidateBst() to check whether the tree is a valid
	BST or not. The validateBST() method takes in two arguments, min and max, which represent the minimum and maximum values
	that the current node's value can take in order to be a valid BST.

	The validateBST() method first checks whether the current node's value is within the valid range determined by the min and
	max arguments. If not, the method returns false, indicating that the tree is not a valid BST.

	If the current node's value is within the valid range, the method then recursively calls itself on the left and right
	child nodes to check whether their values are within their valid ranges. The valid range for the left child node is defined by the minimum value and the parent node's value, while the valid range for the right child node is defined by the parent node's value and the maximum value.

	If all of the nodes in the tree satisfy the BST property, the method returns true, indicating that the tree is a valid BST.

	O(n) time | O(d) space - where n is the number of nodes in the BST and d is the depth (height) of the BST
'''
import math

class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    # Public method to check if the BST is valid
    def validate_bst(self):
        return self._validate_bst(-math.inf, math.inf)

    # Private recursive helper function to check if the BST is valid
    def _validate_bst(self, min_val, max_val):
        # Base case: if the current node's value is outside the allowed range, then the tree is invalid
        if self.value < min_val or self.value >= max_val:
            return False
        
        # Recursively check the left subtree, making sure all values are less than the current node's value
        if self.left and not self.left._validate_bst(min_val, self.value):
            return False
        
        # Recursively check the right subtree, making sure all values are greater than or equal to the current node's value
        if self.right and not self.right._validate_bst(self.value, max_val):
            return False
        
        # If we reach this point, then the tree is valid
        return True

# Example usage:
root = BST(10)
root.left = BST(5)
root.right = BST(15)
root.left.left = BST(2)
root.left.right = BST(7)

if root.validate_bst():
    print("The BST is valid.")
else:
    print("The BST is not valid.")

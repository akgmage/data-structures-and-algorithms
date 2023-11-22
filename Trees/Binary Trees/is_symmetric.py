'''
  Write a function that takes in a Binary Tree and returns if that tree is symmetrical. A tree is symmetrical 
  if the left and right subtrees are mirror images of each other.
'''
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

def is_symmetrical_tree_iterative(tree):
    stack_left = [tree.left] if tree else []  # Initialize stackLeft with the left child of the root node
    stack_right = [tree.right] if tree else []  # Initialize stackRight with the right child of the root node

    # Perform mirror traversal of the left and right subtrees
    while stack_left:
        left = stack_left.pop() if stack_left else None
        right = stack_right.pop() if stack_right else None

        if not left and not right:
            continue  # Both left and right subtrees are symmetric, continue to the next iteration

        if not left or not right or left.value != right.value:
            return False  # Asymmetry detected, tree is not symmetric

        # Push the children of left and right onto the respective stacks in reverse order
        stack_left.extend([left.left, left.right] if left else [])
        stack_right.extend([right.right, right.left] if right else [])

    return True  # Tree is symmetric

# Example usage:
# Construct a symmetric tree
symmetric_tree = BinaryTree(1, BinaryTree(2, BinaryTree(3), BinaryTree(4)), BinaryTree(2, BinaryTree(4), BinaryTree(3)))

print(is_symmetrical_tree_iterative(symmetric_tree))  # Output: True

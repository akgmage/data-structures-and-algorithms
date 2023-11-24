# Invert Binary tree
class BinaryTreeNode:
    def __init__(self, data):
        self.left = None
        self.data = data
        self.right = None

def invert_tree(root):
    if root:
        root.left, root.right = invert_tree(root.right), invert_tree(root.left)
    return root

def invert_tree2(root):
    if root is not None:
        # swap the pointers in this node
        root.left, root.right = root.right, root.left
        invert_tree2(root.left)
        invert_tree2(root.right)
    return root

# Example usage:
# Assuming you have a binary tree
root = BinaryTreeNode(1)
root.left = BinaryTreeNode(2)
root.right = BinaryTreeNode(3)
root.left.left = BinaryTreeNode(4)
root.left.right = BinaryTreeNode(5)

# Invert the binary tree using the first approach
inverted_root = invert_tree(root)

# Invert the binary tree using the second approach
inverted_root2 = invert_tree2(root)

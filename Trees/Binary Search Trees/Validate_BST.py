## Explanation:
# To validate a Binary Search Tree (BST), we need to ensure that the values of nodes in the left subtree of any node are less than the value of the node, and the values of nodes in the right subtree are greater than the value of the node. 
# Additionally, the left and right subtrees themselves must also be valid BSTs.

## Code:
class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def is_bst(root):
    global prev
    prev = None

    def inorder_traversal(node):
        global prev
        if node is None:
            return True

        if not inorder_traversal(node.left):
            return False

        if prev is not None and node.data <= prev.data:
            return False

        prev = node
        return inorder_traversal(node.right)

    return inorder_traversal(root)


# Create the tree
root = Node(1)
root.left = Node(-2)
root.right = Node(3)
root.left.left = Node(-4)
root.left.right = Node(-1)
root.right.left = Node(2)
root.right.right = Node(7)

# Function call
if is_bst(root):
    print("Is Valid BST")
else:
    print("Not a Valid BST")

## Complexity:
# Time  Complexity: O(n) where n is number of nodes
# Space Complexity: O(1)
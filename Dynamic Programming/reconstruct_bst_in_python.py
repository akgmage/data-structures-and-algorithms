class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def constructBST(preorder):
    if not preorder:
        return None

    root = TreeNode(preorder[0])

    i = 1
    while i < len(preorder) and preorder[i] < root.val:
        i += 1

    root.left = constructBST(preorder[1:i])
    root.right = constructBST(preorder[i:])

    return root

def inorderTraversal(root):
    if root is None:
        return []

    return inorderTraversal(root.left) + [root.val] + inorderTraversal(root.right)

# Sample Input
preorder = [10, 4, 2, 1, 5, 17, 19, 18]

# Construct the BST
root = constructBST(preorder)

# Print the inorder traversal of the reconstructed BST
inorder = inorderTraversal(root)
print(inorder)

'''Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.

Explanation:

In this Python implementation, we define a TreeNode class to represent each node in the binary tree. The constructBST function takes the pre-order traversal array as input and returns the root node of the constructed BST.

We create the root node using the first element of the pre-order array and also initialize a stack with the root node. Then, for each element in the pre-order array (starting from the second element), we create a new node. We compare the value of the new node with the top of the stack to determine its position in the BST.

If the value is less than the top of the stack, we add it as the left child of the top node. Otherwise, we pop nodes from the stack until we find a node with a value greater than the new node. The last popped node becomes the parent of the new node and we add the new node as its right child.

Finally, we return the root node of the constructed BST. The inorderTraversal function is used to verify the correctness of the construction by performing an in-order traversal of the BST and printing the values.

When executed, this code will output the in-order traversal of the constructed BST, which should match the expected output you provided.

'''

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def constructBST(preorder):
    if not preorder:
        return None
    
    root = TreeNode(preorder[0])
    stack = [root]
    
    for val in preorder[1:]:
        node = TreeNode(val)
        
        if val < stack[-1].val:
            stack[-1].left = node
        else:
            while stack and val > stack[-1].val:
                last = stack.pop()
            last.right = node
        
        stack.append(node)
    
    return root

def inorderTraversal(root):
    if root:
        inorderTraversal(root.left)
        print(root.val, end=' ')
        inorderTraversal(root.right)

preorder = [10, 4, 2, 1, 5, 17, 19, 18]
root = constructBST(preorder)

# Verify the constructed BST by performing an in-order traversal
inorderTraversal(root)

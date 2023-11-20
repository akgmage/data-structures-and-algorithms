class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

class Solution:
    def inorderTraversal(self, root):
        result = []
        stack = []
        current = root

        while current or stack:
            # Traverse all the way to the leftmost node, pushing each node onto the stack
            while current:
                stack.append(current)
                current = current.left

            # Pop the top node from the stack (current leftmost node)
            current = stack.pop()

            # Add the value of the current node to the result list
            result.append(current.val)

            # Move to the right subtree of the current node
            current = current.right

        return result

# Example usage
root = TreeNode(1)
root.right = TreeNode(2)
root.right.left = TreeNode(3)

solution = Solution()
result = solution.inorderTraversal(root)

print(result)  # Output: [1, 3, 2]

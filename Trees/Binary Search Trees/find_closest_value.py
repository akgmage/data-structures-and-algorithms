'''
  Write a function that takes in a Binary Search Tree (BST) and a target integer
  value and returns the closest value to that target value contained in the BST.

Sample Input : 12

  		 10
       /     \
      5      15
    /   \   /   \
   2     5 13   22
 /           \
1            14
Output : 13

    Explanation:

    The code defines a BST (Binary Search Tree) class with member functions to find the closest value to a given target value.
    The findClosestValue function is the public interface that initializes the closest value with the root value and calls
    the helper function. The findClosestValueHelper function recursively traverses the tree, updating the closest value based
    on the absolute difference between the target and the current node value. It then continues the search in the appropriate
    subtree based on the comparison with the target value. The absDiff function calculates the absolute difference between two
    integers.

	Time and Space complexity:

	Average: O(log(n)) time | O(1) space - where n is the number of nodes in the BST
	Worst: O(n) time | O(1) space - where n is the number of nodes in the BST
'''
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def find_closest_value(self, target):
        # Call the helper function with the initial closest value as the root value
        return self._find_closest_value_helper(target, self.value)

    def _find_closest_value_helper(self, target, closest):
        # Compare the absolute difference between the target and the current closest value
        # with the absolute difference between the target and the current node value
        if abs(target - closest) > abs(target - self.value):
            closest = self.value

        # Look for the target in the left subtree if the target is smaller than the current node value
        if target < self.value and self.left:
            return self.left._find_closest_value_helper(target, closest)
        # Look for the target in the right subtree if the target is greater than the current node value
        elif target > self.value and self.right:
            return self.right._find_closest_value_helper(target, closest)

        return closest

# Create a BST instance
bst = BST(10)
bst.left = BST(5)
bst.right = BST(15)
bst.left.left = BST(2)
bst.left.right = BST(5)
bst.right.left = BST(13)
bst.right.right = BST(22)
bst.left.left.left = BST(1)
bst.right.left.right = BST(14)

# Find the closest value to the target
target = 12
closest_value = bst.find_closest_value(target)

# Print the result
print(f"The closest value to {target} is {closest_value}")

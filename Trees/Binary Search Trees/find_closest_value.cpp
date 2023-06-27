/*
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
*/
#include <cmath>

class BST {
public:
    int value;
    BST* left;
    BST* right;

    BST(int val) {
        value = val;
        left = nullptr;
        right = nullptr;
    }

    int findClosestValue(int target) {
        // Call the helper function with the initial closest value as the root value
        return findClosestValueHelper(target, value);
    }

private:
    int findClosestValueHelper(int target, int closest) {
        // Compare the absolute difference between the target and the current closest value
        // with the absolute difference between the target and the current node value
        if (std::abs(target - closest) > std::abs(target - value)) {
            closest = value;
        }

        // Look for the target in the left subtree if the target is smaller than the current node value
        if (target < value && left != nullptr) {
            return left->findClosestValueHelper(target, closest);
        }
        // Look for the target in the right subtree if the target is greater than the current node value
        else if (target > value && right != nullptr) {
            return right->findClosestValueHelper(target, closest);
        }

        return closest;
    }
};

int main() {
    // Create a BST instance
    BST* bst = new BST(10);
    bst->left = new BST(5);
    bst->right = new BST(15);
    bst->left->left = new BST(2);
    bst->left->right = new BST(5);
    bst->right->left = new BST(13);
    bst->right->right = new BST(22);
    bst->left->left->left = new BST(1);
    bst->right->left->right = new BST(14);

    // Find the closest value to the target
    int target = 12;
    int closestValue = bst->findClosestValue(target);

    // Print the result
    std::cout << "The closest value to " << target << " is " << closestValue << std::endl;

    return 0;
}

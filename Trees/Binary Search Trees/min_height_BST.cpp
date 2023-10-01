/*

  	Write a function that takes in a non-empty sorted array of distinct integers, constructs a BST from the integers, and returns the root of the BST.
  	The function should minimize the height of the BST.
	Smple Input : [1, 2, 5, 7, 10, 13, 14, 15, 22]
	Output:

	      10
       /     \
      2      14
    /   \   /   \
   1     5 13   15
          \       \
           7      22

	Explanation:

	The given code is used to construct a minimum height binary search tree (BST) from a sorted array.
	The goal is to create a balanced BST where the difference in height between the left and right subtrees is minimized.

	The MinHeightBST function serves as a wrapper function that initializes the construction process by calling
	the constructMinHeightBST helper function.

	The constructMinHeightBST function recursively constructs the minimum height BST. It takes the sorted array,
	a partially constructed bst, and the start and end indices that define the range of elements from the array currently being considered.

	The function follows these steps:

	Base Case: If end < start, it means there are no elements to consider in the current range, so it returns nil indicating an empty subtree.

	Calculate the mid index as the midpoint of the current range (start and end).

	Get the value from the array at the mid index.

	If the bst is nil, indicating that there are no values in the BST yet, create a new BST node with the value.
	Otherwise, insert the value into the existing bst using the Insert method.

	Recursively call constructMinHeightBST for the left half of the array by passing start and mid-1 as the new range.
	This constructs the left subtree.

	Recursively call constructMinHeightBST for the right half of the array by passing mid+1 and end as the new range.
	This constructs the right subtree.

	Finally, return the bst which represents the constructed minimum height BST.

	The BST struct represents a node in the binary search tree. It has a Value field to store the node's value and
	Left and Right fields to point to the left and right child nodes, respectively.

	The Insert method is used to insert a new value into the BST. It recursively finds the appropriate position to
	insert the value based on the comparison with the current node's value and updates the left or right child accordingly.

	Overall, this code efficiently constructs a minimum height BST from a sorted array by recursively dividing the
	array and inserting the mid-value into the BST, ensuring a balanced structure.

	Time Complexity:

	The MinHeightBST function calls the constructMinHeightBST helper function, which performs a binary search-like
	operation to divide the array and construct the BST. This process is recursive and takes O(log n) time, where
	n is the number of elements in the array.

	The bst.Insert(value) operation in constructMinHeightBST has a time complexity of O(log n) in the worst case,
	as it involves traversing the height of the BST to find the appropriate position to insert the value.
	Since each element in the array is inserted into the BST once, the overall time complexity is O(n log n),
	where n is the number of elements in the array.

	Space Complexity:

	The space complexity is determined by the stack space used during recursive calls and the space required
	to store the BST.

	The recursive calls in constructMinHeightBST consume additional stack space proportional to the height of
	the tree. In the worst case scenario, where the BST is skewed and its height is equal to the number of
	elements (n), the space complexity becomes O(n).

	The space required to store the BST is also O(n) in the worst case since each element in the array is
	inserted into the BST.

	Therefore, the overall space complexity is O(n) due to the stack space and the BST storage.
	In summary, the time complexity is O(n log n) and the space complexity is O(n).



*/
#include <iostream>
#include <vector>

struct TreeNode {
    int value;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int x) : value(x), left(nullptr), right(nullptr) {}
};

TreeNode* minHeightBST(std::vector<int>& array) {
    // Call helper method with start index, end index, and a nullptr root node
    return constructMinHeightBST(array, nullptr, 0, array.size() - 1);
}

TreeNode* constructMinHeightBST(std::vector<int>& array, TreeNode* bst, int start, int end) {
    // Base case
    if (end < start) {
        return nullptr;
    }
    int mid = (start + end) / 2;
    int value = array[mid];
    // If the BST is empty, create a new root node
    if (bst == nullptr) {
        bst = new TreeNode(value);
    } else {
        // Insert the value into the existing BST
        bst->insert(value);
    }
    // Recursively construct the left and right subtrees
    bst->left = constructMinHeightBST(array, bst->left, start, mid - 1);
    bst->right = constructMinHeightBST(array, bst->right, mid + 1, end);
    return bst;
}

class BST {
public:
    int value;
    BST* left;
    BST* right;

    BST(int x) : value(x), left(nullptr), right(nullptr) {}

    void insert(int value) {
        if (value < this->value) {
            if (left == nullptr) {
                left = new BST(value);
            } else {
                left->insert(value);
            }
        } else {
            if (right == nullptr) {
                right = new BST(value);
            } else {
                right->insert(value);
            }
        }
    }
};

int main() {
    std::vector<int> array = {1, 2, 3, 4, 5, 6, 7};
    TreeNode* root = minHeightBST(array);

    // Printing the BST is left as an exercise

    // Clean up memory
    deleteTree(root);

    return 0;
}

void deleteTree(TreeNode* root) {
    if (root == nullptr) {
        return;
    }
    deleteTree(root->left);
    deleteTree(root->right);
    delete root;
}

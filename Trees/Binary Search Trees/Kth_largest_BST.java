/**
 * A class to represent a node in the BST.
 */
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

/**
 * A class to represent a binary search tree.
 */
class BST {
    Node root;

    BST() {
        root = null;
    }

    /**
     * Function to find the kth largest element in the BST.
    Time complexity: O(n), where n is the number of nodes in the BST. This is because we need to visit every node in the worst case to find the kth largest element.
    Space complexity: O(h), where h is the height of the BST. This is because we're recursively traversing the tree using a call stack, which can have at most h frames in it
    
    The kthLargest() function takes an integer k as input and returns the kth largest element in the BST. It first creates an empty result list, calls the kthLargestHelper() function to traverse the BST in reverse inorder, and collects the kth largest element in the result list. It then returns the last element of the result list, which is the kth largest element in the BST.
    
    Time complexity: O(k), since we're only collecting up to k elements in the result list.
    pace complexity: O(h), where h is the height of the BST. This is because we're recursively traversing the tree using a call stack, which can have at most h frames in it
     */
    public int kthLargest(int k) {
        List<Integer> result = new ArrayList<>();
        kthLargestHelper(root, result, k);
        return result.get(result.size() - 1);
    }


     /**The kthLargestHelper() function is a helper function to traverse the BST in reverse inorder and collect the kth largest element in the result list. It first recursively calls itself on the right child of the current node, then adds the current node's `data */
    private void kthLargestHelper(Node node, List<Integer> result, int k) {
        if (node == null || result.size() == k) {
            return;
        }
        kthLargestHelper(node.right, result, k);
        if (result.size() < k) {
            result.add(node.data);
        }
        kthLargestHelper(node.left, result, k);
    }

    /**
     * Function to insert a node in the BST.
     Time complexity: O(h), where h is the height of the BST. This is because we're traversing the tree from the root to the correct position for the new node.
    Space complexity: O(1), since we're only creating a new node and not using any extra memory.
     */
    public void insert(int data) {
        root = insertHelper(root, data);
    }

    /**
     * Helper function to insert a node in the BST.
     Time complexity: O(h), where h is the height of the BST. This is because we're traversing the tree from the root to the correct position for the new node.
S   pace complexity: O(1), since we're only creating a new node and not using any extra memory.

     */
    private Node insertHelper(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data < node.data) {
            node.left = insertHelper(node.left, data);
        } else if (data > node.data) {
            node.right = insertHelper(node.right, data);
        }
        return node;
    }
}

/**
 * A class to test the BST implementation.
 */
public class KthLargestBST {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        int k = 3;
        int kthLargest = bst.kthLargest(k);
        System.out.println(k + "th largest element in the BST is " + kthLargest);
    }
}

/**Overall, the time complexity of finding the kth largest element in a BST using this code is O(n), and the space complexity is O(h). */

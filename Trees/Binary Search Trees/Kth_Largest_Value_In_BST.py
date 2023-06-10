# Name : Manmay Ghosh
# Github username : ManmayGhosh
# Repository name : data-structures-and-algorithms
# Problem :  Kth Largest Value In BST in Python
# Issue Number : #1225

# Explanation of the below Python code :

# 1. The idea is to do reverse inorder traversal of BST. Keep a count of nodes visited.
# 2. The reverse inorder traversal traverses all nodes in decreasing order, i.e, visit the right node then centre then left and continue traversing the nodes recursively.
# 3. While doing the traversal, keep track of the count of nodes visited so far.
# 4. When the count becomes equal to k, stop the traversal and print the key.

# -------------------------------------------------------------------------//Python code begins here------------------------------------------------------------------------

class Node:
	# Constructor to create a new node
	def __init__(self, val):
		self.key = val
		self.left = None
		self.right = None
		
# This function will find k'th largest element in a tree.
def kthLargestUtil(root, k, c):
	
	# Base cases, c[0] >= k is important to avoid unnecessary recursive calls
	if root == None or c[0] >= k:
		return

	# Follow reverse inorder traversal so that the largest element is visited first
	kthLargestUtil(root.right, k, c)

	# Increment count of visited nodes
	c[0] += 1

	# If c becomes k now, then this is the k'th largest
	if c[0] == k:
		print("K'th largest element is",root.key)
		return

	# Recurssion for left subtree
	kthLargestUtil(root.left, k, c)


# Function to find k'th largest element
def kthLargest(root, k):
	
	# Initialize count of nodes visited as 0
	c = [0]

	# Note that c is passed by reference
	kthLargestUtil(root, k, c)


# Function to insert a new node in BST */
def insert(node, key):
	
	if node == None:
		return Node(key)

	if key < node.key:
		node.left = insert(node.left, key)
	elif key > node.key:
		node.right = insert(node.right, key)

	return node

# Driver Code
if __name__ == '__main__':
    root = None
    root = insert(root, 50)
    insert(root, 30)
    insert(root, 20)
    insert(root, 40)
    insert(root, 70)
    insert(root, 60)
    insert(root, 80)
    k = int(input("Enter the Kth element(should be greater than 1)"))
    kthLargest(root, k)

	
		
  
# Complexity Analysis:  
# Time Complexity: O(n). 
# In worst case the code can traverse each and every node of the tree if the k given is equal to n (total number of nodes in the tree). Therefore overall time complexity is O(n).
# Auxiliary Space: O(h). 
# Max recursion stack of height h at a given time.

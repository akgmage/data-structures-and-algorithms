# Finding Midpoint of a LinkedList
# Node class
class Node:

	# Function to initialise the node object
	def __init__(self, data):
		self.data = data
		self.next = None

class LinkedList:

	def __init__(self):
		self.head = None

	def push(self, new_data):
		new_node = Node(new_data)
		new_node.next = self.head
		self.head = new_node

    

	# Function to get the middle of
	# the linked list using pointers
	def printMiddle(self):
		slow_ptr = self.head 
		fast_ptr = self.head

		if self.head is not None:
			while (fast_ptr is not None and fast_ptr.next is not None):
				fast_ptr = fast_ptr.next.next
				slow_ptr = slow_ptr.next
			print("The middle element is: ", slow_ptr.data)

    

# Driver code
list1 = LinkedList()
list1.push(25)
list1.push(33)
list1.push(14)
list1.push(22)
list1.push(9)
list1.push(11)
list1.push(20)
list1.printMiddle()

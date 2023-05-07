# Implementation of Singly Linked List in Python
'''
    This implementation defines a Node class to represent a node in the linked list, and a LinkedList 
    class to represent the linked list itself. The LinkedList class has methods to insert nodes at the 
    beginning or end of the list, delete nodes from the list, and print the list. Each node has two 
    attributes: its data and a reference to the next node in the list (next). 
    The LinkedList class has one attribute: the head node of the list (head). When a new node is 
    inserted at the beginning of the list, its next attribute is set to the current head node, and the 
    head attribute is set to the new node. When a new node is inserted at the end of the list, it is 
    appended to the last node's next attribute. When a node is deleted, the list is traversed to find 
    the node with the given data, and its next attribute is set to the node after it. Finally, the 
    print_list method traverses the list and prints each node's data.
'''
# Define a class to represent a node in the linked list
class Node:
    def __init__(self, data):
        # Each node has two attributes: data and a reference to the next node
        self.data = data
        self.next = None

# Define a class to represent the linked list itself
class LinkedList:
    def __init__(self):
        # Each linked list has one attribute: the head node (which initially is None)
        self.head = None
    
    # Method to insert a new node at the beginning of the linked list
    def insert_at_beginning(self, data):
        # Create a new node
        new_node = Node(data)
        
        # Set the next node of the new node to be the current head node
        new_node.next = self.head
        
        # Set the head node to be the new node
        self.head = new_node
    
    # Method to insert a new node at the end of the linked list
    def insert_at_end(self, data):
        # Create a new node
        new_node = Node(data)
        
        # If the list is empty, set the head node to be the new node
        if self.head is None:
            self.head = new_node
            return
        
        # Traverse to the last node in the list
        current_node = self.head
        while current_node.next:
            current_node = current_node.next
        
        # Set the next node of the last node to be the new node
        current_node.next = new_node
    
    # Method to delete the first occurrence of a node with the given data
    def delete_node(self, data):
        # If the list is empty, do nothing
        if self.head is None:
            return
        
        # If the node to be deleted is the head node, set the head node to be the next node
        if self.head.data == data:
            self.head = self.head.next
            return
        
        # Traverse the list to find the node to be deleted
        current_node = self.head
        while current_node.next:
            if current_node.next.data == data:
                current_node.next = current_node.next.next
                return
            current_node = current_node.next
    
    # Method to print the linked list
    def print_list(self):
        # Traverse the list and print each node's data
        current_node = self.head
        while current_node:
            print(current_node.data, end=" -> ")
            current_node = current_node.next
        print("None")

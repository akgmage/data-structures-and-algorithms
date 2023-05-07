'''
This is an implementation of a singly linked list in Python with a Node class and a LinkedList class. The Node class represents each element of the linked list and the LinkedList class has methods to manipulate the list, including append, prepend, delete_node, and print_list.
'''

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None  # The next node in the list

class LinkedList:
    def __init__(self):
        self.head = None  # The first node in the list

    def append(self, data):
        new_node = Node(data)
        if not self.head:  # If the list is empty, set the new node as the head
            self.head = new_node
            return
        curr_node = self.head
        while curr_node.next:  # Traverse to the last node in the list
            curr_node = curr_node.next
        curr_node.next = new_node  # Set the next node of the last node to the new node

    def prepend(self, data):
        new_node = Node(data)
        new_node.next = self.head  # Set the next node of the new node to the current head
        self.head = new_node  # Set the new node as the new head

    def delete_node(self, data):
        if not self.head:  # If the list is empty, do nothing
            return
        if self.head.data == data:  # If the head is the node to delete, set the next node as the new head
            self.head = self.head.next
            return
        curr_node = self.head
        while curr_node.next:  # Traverse the list until the last node
            if curr_node.next.data == data:  # If the next node is the node to delete, set the next node of the current node to the node after the next node
                curr_node.next = curr_node.next.next
                return
            curr_node = curr_node.next

    def print_list(self):
        curr_node = self.head
        while curr_node:  # Traverse the list and print each node's data
            print(curr_node.data)
            curr_node = curr_node.next


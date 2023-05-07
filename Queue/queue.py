# Implement Queue Data Structure
'''
    This implementation uses a Python list to store the items in the queue. The __init__() method initializes 
    an empty list. The is_empty() method checks whether the list is empty or not by checking the length of 
    the list. The enqueue() method adds an item to the back of the queue by appending it to the end of the 
    list. The dequeue() method removes and returns the item at the front of the queue by using the pop() 
    method to remove the first item in the list. If the list is empty, the method raises an IndexError. 
    The peek() method returns the item at the front of the queue without removing it by returning the 
    first item in the list. If the list is empty, the method raises an IndexError. The size() method 
    returns the number of items in the list by returning the length of the list.
'''
class Queue:
    def __init__(self):
        """
        Initializes an empty queue.
        """
        self.items = []

    def is_empty(self):
        """
        Returns True if the queue is empty, False otherwise.
        """
        return len(self.items) == 0

    def enqueue(self, item):
        """
        Adds the given item to the back of the queue.
        """
        self.items.append(item)

    def dequeue(self):
        """
        Removes and returns the item at the front of the queue.
        If the queue is empty, raises an IndexError.
        """
        if self.is_empty():
            raise IndexError("Queue is empty")
        return self.items.pop(0)

    def peek(self):
        """
        Returns the item at the front of the queue without removing it.
        If the queue is empty, raises an IndexError.
        """
        if self.is_empty():
            raise IndexError("Queue is empty")
        return self.items[0]

    def size(self):
        """
        Returns the number of items in the queue.
        """
        return len(self.items)

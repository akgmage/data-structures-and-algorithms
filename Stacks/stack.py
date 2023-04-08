# Implemenmtation of  stack data structure
'''
    In this implementation, the Stack class contains the following methods:

    __init__: Constructor function to initialize an empty stack.
    is_empty: Check if stack is empty.
    push: Push an item onto the stack.
    pop: Remove and return the top item from the stack.
    peek: Return the top item from the stack without removing it.
    size: Return the number of items in the stack.
    Each method includes a docstring that explains what it does, along with any arguments and return values.
'''
class Stack:
    """
    Stack class implementation using list in Python
    """
    def __init__(self):
        """
        Constructor function to initialize an empty stack
        """
        self.items = []
    
    def is_empty(self):
        """
        Check if stack is empty
        
        Returns:
        bool: True if stack is empty, False otherwise
        """
        return len(self.items) == 0
    
    def push(self, item):
        """
        Push an item onto the stack
        
        Args:
        item: Item to be pushed onto the stack
        """
        self.items.append(item)
    
    def pop(self):
        """
        Remove and return the top item from the stack
        
        Returns:
        item: Top item from the stack
        
        Raises:
        IndexError: If stack is empty
        """
        if self.is_empty():
            raise IndexError("Stack is empty")
        return self.items.pop()
    
    def peek(self):
        """
        Return the top item from the stack without removing it
        
        Returns:
        item: Top item from the stack
        
        Raises:
        IndexError: If stack is empty
        """
        if self.is_empty():
            raise IndexError("Stack is empty")
        return self.items[-1]
    
    def size(self):
        """
        Return the number of items in the stack
        
        Returns:
        int: Number of items in the stack
        """
        return len(self.items)

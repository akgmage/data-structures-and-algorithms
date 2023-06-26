from queue import Queue

class Stack:
    """
    Stack implementation using queues.
    """

    def __init__(self):
        """
        Initialize an empty stack.
        """
        self.queue1 = Queue()
        self.queue2 = Queue()

    def push(self, item):
        """
        Add an item to the top of the stack.
        """
        # Add the item to the empty queue
        self.queue1.put(item)

        # Move all the elements from the other queue to the empty queue
        while not self.queue2.empty():
            self.queue1.put(self.queue2.get())

        # Swap the names of the two queues
        self.queue1, self.queue2 = self.queue2, self.queue1

    def pop(self):
        """
        Remove and return the item at the top of the stack.
        """
        if self.queue2.empty():
            raise IndexError("Stack is empty")

        # Remove and return the front element of the non-empty queue
        return self.queue2.get()

    def top(self):
        """
        Return the item at the top of the stack without removing it.
        """
        if self.queue2.empty():
            raise IndexError("Stack is empty")

        # Get the front element of the non-empty queue
        return self.queue2.queue[0]

    def is_empty(self):
        """
        Check if the stack is empty.
        """
        return self.queue2.empty()

    def size(self):
        """
        Return the number of items in the stack.
        """
        return self.queue2.qsize()

'''
__init__() - This method initializes the stack by creating two queues. Since no operations are performed on the queues in this method, the time complexity is O(1).

push(item) - This method adds an item to the top of the stack. Initially, it adds the item to an empty queue, which takes O(1) time. Then, it moves all the elements from the other queue to the empty queue, which takes O(n) time, where n is the number of elements in the stack. Finally, it swaps the names of the two queues, which is a constant time operation. Therefore, the overall time complexity of push(item) is O(n).

pop() - This method removes and returns the item at the top of the stack. It checks if the stack is empty, which takes O(1) time. Then, it removes and returns the front element of the non-empty queue, which is a constant time operation. Therefore, the overall time complexity of pop() is O(1).

top() - This method returns the item at the top of the stack without removing it. It checks if the stack is empty, which takes O(1) time. Then, it retrieves the front element of the non-empty queue, which is a constant time operation. Therefore, the overall time complexity of top() is O(1).

is_empty() - This method checks if the stack is empty by checking if the queue is empty, which takes O(1) time. Therefore, the time complexity of is_empty() is O(1).

size() - This method returns the number of items in the stack by returning the size of the queue, which is a constant time operation. Therefore, the time complexity of size() is O(1).

the time complexity of the operations in the Stack class implemented using queues is as follows:

push(item): O(n)
pop(): O(1)
top(): O(1)
is_empty(): O(1)
size(): O(1)

'''

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



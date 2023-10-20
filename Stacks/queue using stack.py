# Queue using stack
class Queue:
    def __init__(self):
        self.enqueue_stack = []  # Stack for enqueue operations
        self.dequeue_stack = []  # Stack for dequeue operations

    def enqueue(self, value):
        """Enqueue: Add an element to the back of the queue."""
        self.enqueue_stack.append(value)

    def dequeue(self):
        """Dequeue: Remove and return the front element of the queue."""
        # If the dequeue stack is empty, transfer elements from the enqueue stack
        if not self.dequeue_stack:
            while self.enqueue_stack:
                # Pop an element from the enqueue stack and push it onto the dequeue stack
                element = self.enqueue_stack.pop()
                self.dequeue_stack.append(element)

        # If the dequeue stack is still empty, the queue is empty
        if not self.dequeue_stack:
            raise IndexError("Queue is empty")

        # Pop and return the front element from the dequeue stack
        return self.dequeue_stack.pop()

# Example usage
queue = Queue()
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
print(queue.dequeue())  # Output: 1
print(queue.dequeue())  # Output: 2
queue.enqueue(4)
queue.enqueue(5)
print(queue.dequeue())  # Output: 3
print(queue.dequeue())  # Output: 4
print(queue.dequeue())  # Output: 5

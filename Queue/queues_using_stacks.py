''' Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Implement Queue using Stacks in Python
Issue Number : #256
Problem statement :

Explanation of the below python code :

In the above code, the Queue class represents a queue implemented using two stacks. The enqueue method simply adds the element to the first stack (stack1). The dequeue method pops an element from the second stack (stack2) if it's not empty. If stack2 is empty, it transfers all elements from stack1 to stack2 in reverse order and then pops an element from stack2.

The program provides the user with a menu to select the operation they want to perform - enqueue, dequeue, or quit. The user can input the value to enqueue, and the program prints the enqueued or dequeued value accordingly.

Summary about the code and time complexity:

This code implements a queue using two stacks.
The enqueue operation is simply implemented by appending an element to one of the stacks, while the dequeue operation involves reversing the order of the elements by popping from one stack and pushing onto the other, and then popping the top element from the second stack.
The time complexity of the enqueue operation is O(1), while the time complexity of the dequeue operation is O(n) in the worst case, where n is the number of elements in the queue. This is because in the worst case, all the elements will need to be moved from one stack to the other during the dequeue operation.



----------------------------------------------------------------------------------------------------------//Python code begins here-----------------------------------------------------------------------------------------------------------------------
'''

class Queue:
    def __init__(self):
        # Initialize two empty stacks
        self.stack1 = []
        self.stack2 = []

    def enqueue(self, val):
        # Add an element to the end of the queue by appending it to stack1
        self.stack1.append(val)

    def dequeue(self):
        # If stack2 is empty, reverse the order of the elements by popping from stack1 and pushing onto stack2
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        # If stack2 is still empty, the queue is empty, so return None
        if not self.stack2:
            return None
        # Otherwise, pop the top element from stack2 and return it
        return self.stack2.pop()

# Create an instance of the Queue class
queue = Queue()

# Enter into an infinite loop to prompt the user for operations
while True:
    print("Select operation -\n"
          "1. Enqueue\n"
          "2. Dequeue\n"
          "3. Quit")

    # Prompt the user for their choice of operation
    choice = int(input("Enter choice: "))

    if choice == 1:
        # If the user selects option 1, prompt them for a value to enqueue and enqueue it
        val = int(input("Enter value to enqueue: "))
        queue.enqueue(val)
        print("Enqueued value:", val)
    elif choice == 2:
        # If the user selects option 2, dequeue a value and print it, or indicate that the queue is empty
        val = queue.dequeue()
        if val:
            print("Dequeued value:", val)
        else:
            print("Queue is empty.")
    elif choice == 3:
        # If the user selects option 3, quit the loop
        break
    else:
        # If the user selects an invalid option, prompt them to try again
        print("Invalid choice. Please try again.")


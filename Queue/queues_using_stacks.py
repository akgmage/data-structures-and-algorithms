''' Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Implement Queue using Stacks in Python
Issue Number : #256
Problem statement :

Explanation of the below python code :

In the above code, the Queue class represents a queue implemented using two stacks. The enqueue method simply adds the element to the first stack (stack1). The dequeue method pops an element from the second stack (stack2) if it's not empty. If stack2 is empty, it transfers all elements from stack1 to stack2 in reverse order and then pops an element from stack2.

The program provides the user with a menu to select the operation they want to perform - enqueue, dequeue, or quit. The user can input the value to enqueue, and the program prints the enqueued or dequeued value accordingly.



----------------------------------------------------------------------------------------------------------//Python code begins here-----------------------------------------------------------------------------------------------------------------------
'''

class Queue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def enqueue(self, val):
        self.stack1.append(val)

    def dequeue(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        if not self.stack2:
            return None
        return self.stack2.pop()

queue = Queue()

while True:
    print("Select operation -\n"
          "1. Enqueue\n"
          "2. Dequeue\n"
          "3. Quit")

    choice = int(input("Enter choice: "))

    if choice == 1:
        val = int(input("Enter value to enqueue: "))
        queue.enqueue(val)
        print("Enqueued value:", val)
    elif choice == 2:
        val = queue.dequeue()
        if val:
            print("Dequeued value:", val)
        else:
            print("Queue is empty.")
    elif choice == 3:
        break
    else:
        print("Invalid choice. Please try again.")

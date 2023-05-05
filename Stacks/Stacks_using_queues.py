''' Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Implement Stack using Queues in Python
Issue Number : #261
Problem statement :

Explanation of the below python code :

__init__(self) initializes the two queues (q1 and q2) in the constructor.

push(self, x: int) adds a new element x to the top of the stack. It first adds the element to q2, and then moves all the elements from q1 to q2 using a while loop. Finally, it swaps q1 and q2 so that q1 always contains the elements in the stack.

pop(self) -> int removes and returns the element at the top of the stack, which is the first element in q1.

top(self) -> int returns the element at the top of the stack, which is also the first element in q1.

empty(self) -> bool returns True if the stack is empty (i.e., q1 is empty), and False otherwise.

The deque data structure from the collections module is used to implement the two queues, since it provides efficient O(1) operations for adding and removing elements from both ends of the queue.

Overall, this implementation is quite simple and efficient, since the push and pop operations take O(1) time complexity on average, while the top and empty operations take constant time.

-------------------------------------------------------------------------//Python code begins here----------------------------------------------------------------------------
'''

from collections import deque

class Stack:
    def __init__(self):             #The Stack class is defined with a constructor that initializes a deque object as the Stack's underlying data structure.
        self.queue = deque()

    def push(self, x: int) -> None:
        self.queue.append(x)
        # Move all existing elements to the end of the queue      #The push method takes an integer value as input and appends it to the end of the deque. It then moves all the existing elements in the deque to the end, effectively simulating the addition of the new element to the top of the Stack.
        for _ in range(len(self.queue) - 1):
            self.queue.append(self.queue.popleft())

    def pop(self) -> int:
        return self.queue.popleft()     #The pop method removes and returns the element at the top of the Stack, which is the first element in the deque.

    def top(self) -> int:             #The top method returns the element at the top of the Stack without removing it, which is the first element in the deque.
        return self.queue[0]

    def empty(self) -> bool:           #The empty method returns True if the Stack is empty (i.e., the deque has length 0), and False otherwise.
        return len(self.queue) == 0


stack = Stack()
while True:
    print("1. Push")
    print("2. Pop")
    print("3. Top")
    print("4. Empty")
    print("5. Quit")
    choice = int(input("Enter your choice: "))
    if choice == 1:
        x = int(input("Enter the element to push: "))
        stack.push(x)
        print("Element pushed to stack")
    elif choice == 2:
        if stack.empty():                                 '''The code above shows an example usage of the Stack class, where the user can interact with the Stack through a command-line interface.The user is prompted with a menu of options to choose from, and their choice is read in as an integer value using the input() functiom'''                                            Depending on the user's choice, the appropriate method is called on the stack object and the results are printed to the console.
            print("Stack is empty")
        else:
            x = stack.pop()
            print("Popped element:", x)
    elif choice == 3:
        if stack.empty():
            print("Stack is empty")
        else:
            x = stack.top()
            print("Top element:", x)
    elif choice == 4:
        if stack.empty():
            print("Stack is empty")
        else:
            print("Stack is not empty")
    elif choice == 5:
        break
    else:
        print("Invalid choice")

// Implemenmtation of  stack data structure
/*
    This implementation creates a class Stack that has a private integer top to keep track of the index 
    of the topmost element in the stack, and an integer array arr to store the elements of the stack. 
    The push, pop, peek, and isEmpty methods are used to add elements to, remove elements from, view 
    the topmost element in, and check if the stack is empty, respectively. The main function creates 
    an instance of Stack and demonstrates the use of the stack by pushing some elements onto it, 
    printing the topmost element, popping an element from the stack, and checking if the stack is empty.
*/
#include <iostream>
using namespace std;

const int MAX_SIZE = 100; // Maximum size of stack

class Stack {
private:
    int top; // Index of topmost element in stack
    int arr[MAX_SIZE]; // Array to store elements of stack
public:
    Stack() {
        top = -1; // Initialize top index to -1, indicating empty stack
    }

    // Pushes an element onto the top of the stack
    void push(int x) {
        if (top == MAX_SIZE - 1) { // Check if stack is full
            cout << "Stack Overflow\n";
            return;
        }
        arr[++top] = x; // Increment top index and add element to array
    }

    // Removes and returns the topmost element from the stack
    int pop() {
        if (top == -1) { // Check if stack is empty
            cout << "Stack Underflow\n";
            return -1;
        }
        int val = arr[top]; // Store topmost element in a variable
        top--; // Decrement top index to remove element from stack
        return val; // Return topmost element
    }

    // Returns the topmost element in the stack without removing it
    int peek() {
        if (top == -1) { // Check if stack is empty
            cout << "Stack Underflow\n";
            return -1;
        }
        return arr[top]; // Return topmost element
    }

    // Returns true if stack is empty, false otherwise
    bool isEmpty() {
        return top == -1;
    }
};

int main() {
    Stack s;

    // Push some elements onto the stack
    s.push(5);
    s.push(10);
    s.push(15);

    // Print the topmost element without removing it
    cout << "Top element: " << s.peek() << endl;

    // Pop an element from the stack and print it
    cout << "Popped element: " << s.pop() << endl;

    // Check if stack is empty
    cout << "Is stack empty? " << (s.isEmpty() ? "Yes" : "No") << endl;

    return 0;
}

// stack using queues
#include <iostream>
#include <queue>

class StackUsingQueues {
public:
    StackUsingQueues() {}

    // Push an element onto the stack.
    void push(int x) {
        // Add the element to the primary queue.
        primaryQueue.push(x);
    }

    // Remove and return the top element of the stack.
    int pop() {
        if (isEmpty()) {
            throw std::runtime_error("Stack is empty");
        }

        // Move elements from the primary queue to the temporary queue except the last one.
        while (primaryQueue.size() > 1) {
            tempQueue.push(primaryQueue.front());
            primaryQueue.pop();
        }

        // Get the last element from the primary queue (top of the stack).
        int topElement = primaryQueue.front();
        primaryQueue.pop();

        // Swap the primary and temporary queues.
        primaryQueue = tempQueue;
        while (!tempQueue.empty()) {
            tempQueue.pop();
        }

        return topElement;
    }

    // Return the top element of the stack without removing it.
    int top() {
        if (isEmpty()) {
            throw std::runtime_error("Stack is empty");
        }

        int topElement = pop();

        // Add the top element back to the stack.
        push(topElement);

        return topElement;
    }

    // Check if the stack is empty.
    bool isEmpty() {
        return primaryQueue.empty();
    }

private:
    std::queue<int> primaryQueue;
    std::queue<int> tempQueue;
};

int main() {
    StackUsingQueues stack;

    // Push elements onto the stack.
    stack.push(1);
    stack.push(2);
    stack.push(3);

    // Pop elements from the stack.
    std::cout << stack.pop() << std::endl; // Output: 3
    std::cout << stack.pop() << std::endl; // Output: 2

    // Push more elements.
    stack.push(4);
    stack.push(5);

    // Peek at the top element.
    std::cout << stack.top() << std::endl; // Output: 5

    // Check if the stack is empty.
    std::cout << stack.isEmpty() << std::endl; // Output: 0 (false)

    return 0;
}

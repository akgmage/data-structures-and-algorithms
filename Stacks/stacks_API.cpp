/*
  In this implementation, we use a std::priority_queue named heap to simulate the behavior of a stack. The push operation inserts elements into the heap with a unique sequence number generated for each element. The pop operation removes the top element from the heap. The top operation returns the top element without removing it. The empty operation checks if the heap is empty.

The time complexity of the stack operations implemented using a heap is as follows:

push: O(log n), where n is the number of elements in the stack.
pop: O(log n), where n is the number of elements in the stack.
top: O(1)
empty: O(1)
The push and pop operations have a time complexity of O(log n) because the std::priority_queue internally maintains the heap property, ensuring that the highest priority (in this case, the highest sequence number) element is always at the top
                       */



#include <iostream>
#include <queue>

class Stack {
private:
    std::priority_queue<int> heap;  // Using max heap to simulate stack behavior
    int sequenceNumber;  // To keep track of the order of elements

public:
    Stack() : sequenceNumber(0) {}

    void push(int value) {
        heap.push(std::make_pair(sequenceNumber++, value));
    }

    int pop() {
        if (heap.empty()) {
            throw std::runtime_error("Stack is empty");
        }

        int value = heap.top().second;
        heap.pop();
        return value;
    }

    int top() const {
        if (heap.empty()) {
            throw std::runtime_error("Stack is empty");
        }

        return heap.top().second;
    }

    bool empty() const {
        return heap.empty();
    }
};

int main() {
    Stack stack;

    stack.push(5);
    stack.push(10);
    stack.push(3);

    std::cout << stack.top() << std::endl;  // Output: 3

    stack.pop();

    std::cout << stack.top() << std::endl;  // Output: 10

    return 0;
}

/*
This implementation maintains two queues, queue1 and queue2, where queue1 always holds the elements in the stack. When pushing a new element, it is added to queue2, and then all the elements from queue1 are moved to queue2, making the newly added element the front/top of the stack. Finally, the names of the two queues are swapped to maintain the order.

The pop() function removes and returns the front/top element of queue1, while the top() function returns the front/top element without removing it. Both functions check if queue1 is empty and throw an exception if the stack is empty.

The empty() function checks if queue1 is empty and returns true if it is, indicating an empty stack.

Time complexity

push(x): O(n)
pop(): O(1)
top(): O(1)
empty(): O(1)
*/
  


#include <queue>

class MyStack {
private:
    std::queue<int> queue1;
    std::queue<int> queue2;
    
public:
    MyStack() {
        
    }
    
    void push(int x) {
        // Add the new element to queue2
        queue2.push(x);
        
        // Move all elements from queue1 to queue2
        while (!queue1.empty()) {
            queue2.push(queue1.front());
            queue1.pop();
        }
        
        // Swap the names of the two queues
        std::swap(queue1, queue2);
    }
    
    int pop() {
        if (queue1.empty()) {
            throw std::runtime_error("Stack is empty");
        }
        
        int topElement = queue1.front();
        queue1.pop();
        return topElement;
    }
    
    int top() {
        if (queue1.empty()) {
            throw std::runtime_error("Stack is empty");
        }
        
        return queue1.front();
    }
    
    bool empty() {
        return queue1.empty();
    }
};


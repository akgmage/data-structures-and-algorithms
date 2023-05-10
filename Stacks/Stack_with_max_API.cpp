/*
Time Complexity of all Operations is O(1)
Space Complexity is O(n)
In this implementation, we use two stacks: s is the main stack that holds the elements of the stack, and max_s is a secondary stack that holds the maximum values in s. When a new value is pushed onto the stack, we compare it with the current maximum value in max_s and add it to max_s if it's greater than or equal to the current maximum.
*/
#include <stack>
using namespace std;

class MaxStack {
private:
    stack<int> s;       // Main stack that holds the elements of the stack
    stack<int> max_s;   // Secondary stack that holds the maximum values in s

public:
    void push(int val) {
        s.push(val);    // Push the value onto the main stack
        if (max_s.empty() || val >= max_s.top()) {
            // If max_s is empty or the new value is greater than or equal to the current maximum,
            // push the value onto max_s
            max_s.push(val);
        }
    }

    void pop() {
        if (s.top() == max_s.top()) {
            // If the top value of s is equal to the top value of max_s, it means that the top value
            // of s is the current maximum, so we need to pop it from max_s as well
            max_s.pop();
        }
        s.pop();    // Pop the value from the main stack
    }

    int top() {
        return s.top(); // Return the top value of the main stack
    }

    int max() {
        return max_s.top(); // Return the top value of max_s, which is the maximum value in the stack
    }

    bool empty() {
        return s.empty();   // Check if the main stack is empty
    }
};

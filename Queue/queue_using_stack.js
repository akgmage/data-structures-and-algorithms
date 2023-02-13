/*
Implement a first in first out (FIFO) queue using only two stacks. 
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
- method adds an element to the back of the queue by pushing it onto stack1. 


int pop() Removes the element from the front of the queue and returns it.
- method removes and returns the front element of the queue by first checking if stack2 is empty.
- if it is, reversing the elements from stack1 onto stack2 so that the front element 
  of the queue is now at the top of stack2. 
- Then it pops the top element from stack2.


int peek() Returns the element at the front of the queue.
- returns the front element of the queue without removing it. 
- First checking if stack2 is empty
- if it is, reversing the elements from stack1 onto stack2 so that the front element of the queue is now at the top of stack2.
- Then it returns the top element of stack2.


boolean empty() Returns true if the queue is empty, false otherwise.
- returns a boolean indicating whether the queue is empty or not. 
- It returns true if both stack1 and stack2 are empty, and false otherwise.
*/

var MyQueue = function() {
    this.stack1 = [];
    this.stack2 = [];
};


/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.stack1.push(x);
};


/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    if (this.stack2.length === 0) {
        if (this.stack1.length === 0) {
          return "Underflow";
        }
        while (this.stack1.length > 0) {
          this.stack2.push(this.stack1.pop());
        }
      }
    return this.stack2.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    if (this.stack2.length === 0) {
        if (this.stack1.length === 0) {
          return "Queue is empty";
        }
        while (this.stack1.length > 0) {
          this.stack2.push(this.stack1.pop());
        }
      }
    return this.stack2[this.stack2.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.stack1.length === 0 && this.stack2.length === 0;
};


// MyQueue object will be instantiated and called as such:
let myQueue = new MyQueue();
var param_0 = myQueue.push(1); // queue is: [1]
var param_1 = myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
var param_2 = myQueue.peek(); // return 1
var param_3 = myQueue.pop(); // return 1, queue is [2]
var param_4 = myQueue.empty(); // return false


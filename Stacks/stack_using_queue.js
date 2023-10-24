// Stack using queues
class StackUsingQueues {
  constructor() {
    this.primaryQueue = [];
    this.tempQueue = [];
  }

  // Push an element onto the stack.
  push(x) {
    // Add the element to the primary queue.
    this.primaryQueue.push(x);
  }

  // Remove and return the top element of the stack.
  pop() {
    if (this.isEmpty()) {
      throw new Error("Stack is empty");
    }

    // Move elements from the primary queue to the temporary queue except the last one.
    while (this.primaryQueue.length > 1) {
      this.tempQueue.push(this.primaryQueue.shift());
    }

    // Get the last element from the primary queue (top of the stack).
    const topElement = this.primaryQueue.shift();

    // Swap the primary and temporary queues.
    [this.primaryQueue, this.tempQueue] = [this.tempQueue, this.primaryQueue];

    return topElement;
  }

  // Return the top element of the stack without removing it.
  top() {
    if (this.isEmpty()) {
      throw new Error("Stack is empty");
    }

    const topElement = this.pop();

    // Add the top element back to the stack.
    this.push(topElement);

    return topElement;
  }

  // Check if the stack is empty.
  isEmpty() {
    return this.primaryQueue.length === 0;
  }
}

const stack = new StackUsingQueues();

// Push elements onto the stack.
stack.push(1);
stack.push(2);
stack.push(3);

// Pop elements from the stack.
console.log(stack.pop()); // Output: 3
console.log(stack.pop()); // Output: 2

// Push more elements.
stack.push(4);
stack.push(5);

// Peek at the top element.
console.log(stack.top()); // Output: 5

// Check if the stack is empty.
console.log(stack.isEmpty()); // Output: false

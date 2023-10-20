// Queue using stack
class Queue {
  constructor() {
    this.enqueueStack = []; // Stack for enqueue operations
    this.dequeueStack = []; // Stack for dequeue operations
  }

  enqueue(value) {
    // Enqueue: Add an element to the back of the queue.
    this.enqueueStack.push(value);
  }

  dequeue() {
    // Dequeue: Remove and return the front element of the queue.
    // If the dequeue stack is empty, transfer elements from the enqueue stack
    if (this.dequeueStack.length === 0) {
      while (this.enqueueStack.length > 0) {
        // Pop an element from the enqueue stack and push it onto the dequeue stack
        const element = this.enqueueStack.pop();
        this.dequeueStack.push(element);
      }
    }

    // If the dequeue stack is still empty, the queue is empty
    if (this.dequeueStack.length === 0) {
      throw new Error("Queue is empty");
    }

    // Pop and return the front element from the dequeue stack
    return this.dequeueStack.pop();
  }
}

// Example usage
const queue = new Queue();
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
console.log(queue.dequeue()); // Output: 1
console.log(queue.dequeue()); // Output: 2
queue.enqueue(4);
queue.enqueue(5);
console.log(queue.dequeue()); // Output: 3
console.log(queue.dequeue()); // Output: 4
console.log(queue.dequeue()); // Output: 5

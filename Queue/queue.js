// 1. Queue Using Array:
// 2. Queue Using LinkedList:
/*
    In this implementation, we use an array to store the elements of the queue, and we keep track of the front and rear indices, as well as the current size of the queue.
    The enqueue operation adds an item to the rear of the queue, while the dequeue operation removes an item from the front of the queue.
    The isEmpty and isFull methods check whether the queue is empty or full, respectively, while the size method returns the current size of the queue.

*/
// 1. Queue Using Array:
class Queue {
  constructor() {
    this.items = [];
  }

  enqueue(element) {
    this.items.push(element);
  }

  dequeue() {
    if (this.isEmpty()) {
      return "Underflow";
    }
    return this.items.shift();
  }

  front() {
    if (this.isEmpty()) {
      return "No elements in Queue";
    }
    return this.items[0];
  }

  isEmpty() {
    return this.items.length === 0;
  }

  printQueue() {
    let str = "";
    for (let i = 0; i < this.items.length; i++) {
      str += this.items[i] + " ";
    }
    return str;
  }
}

// Here's an example implementation of a Queue data structure in Java using a linked list
/*
    In this implementation, we use a linked list to store the elements of the queue, and we keep track of the front and rear nodes, as well as the current size of the queue.
    The enqueue operation adds a new node to the rear of the linked list, while the dequeue operation removes the head node from the linked list.
    The isEmpty method checks whether the queue is empty, while the size method returns the current size of the queue.
    Note that this implementation uses generics to allow the queue to store elements of any type.
*/
// 2. Queue Using LinkedList:
class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  enqueue(data) {
    let newNode = new Node(data);
    if (this.rear === null) {
      this.front = newNode;
      this.rear = newNode;
    } else {
      this.rear.next = newNode;
      this.rear = newNode;
    }
    this.size++;
  }

  dequeue() {
    if (this.front === null) {
      return "Underflow";
    }
    let removedNode = this.front;
    this.front = this.front.next;
    if (this.front === null) {
      this.rear = null;
    }
    this.size--;
    return removedNode.data;
  }

  isEmpty() {
    return this.size === 0;
  }

  getFront() {
    return this.front ? this.front.data : "No elements in Queue";
  }

  printQueue() {
    let str = "";
    let temp = this.front;
    while (temp) {
      str += temp.data + " ";
      temp = temp.next;
    }
    return str;
  }
}

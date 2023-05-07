// Implemenmtation of  stack data structure
/*
    We define a class called Stack with an empty array items to store the stack elements.
    The class has four methods:
    push(item): Adds an item to the top of the stack by using the push method of the Array object.
    pop(): Removes and returns the item at the top of the stack using the pop method of the Array object.
    peek(): Returns the item at the top of the stack without removing it using the slice method of the Array object.
    isEmpty(): Returns true if the stack is empty, false otherwise by checking the length of the items array.

    This implementation uses the built-in Array object of JavaScript to implement the stack data structure. 
    The push, pop, and slice methods are used to manipulate the items array to add, remove, and access the 
    top item of the stack, respectively. The isEmpty method simply checks if the items array is empty or not.
*/
class Stack {
  constructor() {
    this.items = []; // initializing an empty array
  }

  // push function to add an element to the stack
  push(element) {
    this.items.push(element);
  }

  // pop function to remove the topmost element from the stack
  pop() {
    // checking if the stack is empty
    if (this.items.length === 0) return "Underflow";
    return this.items.pop();
  }

  // peek function to get the topmost element of the stack without removing it
  peek() {
    // checking if the stack is empty
    if (this.items.length === 0) return "No elements in Stack";
    return this.items[this.items.length - 1];
  }

  // isEmpty function to check if the stack is empty
  isEmpty() {
    return this.items.length === 0;
  }

  // printStack function to print the entire stack
  printStack() {
    let str = "";
    for (let i = 0; i < this.items.length; i++) {
      str += this.items[i] + " ";
    }
    return str;
  }
}

// creating an instance of the Stack class
let stack = new Stack();

// adding elements to the stack
stack.push(10);
stack.push(20);
stack.push(30);

// printing the stack
console.log(stack.printStack()); // Output: 10 20 30

// removing the topmost element from the stack
stack.pop();

// printing the stack
console.log(stack.printStack()); // Output: 10 20

// checking the topmost element of the stack
console.log(stack.peek()); // Output: 20

// checking if the stack is empty
console.log(stack.isEmpty()); // Output: false

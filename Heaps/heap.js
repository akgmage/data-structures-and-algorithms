/*
	Implement a Min-Heap class that supports

		Building a Min Heap from an input array of integers.
		Inserting integers in the heap.
		Removing the heap's minimum / root value.
		Peeking at the heap's minimum / root value.
		Sifting integers up and down the heap, which is to be used when inserting and removing values.

	Note that the heap should be represented in the form of an array.

	Explanation:

	The code snippet implements a MinHeap data structure in Go.

	- `NewMinHeap`: This function creates a new MinHeap from an input array and returns a pointer to the MinHeap object.
	   It calls the `BuildHeap` method to construct the heap structure.
	- `BuildHeap`: This method constructs the heap by iteratively calling `siftDown` on each parent node starting from the
	   last non-leaf node.
	- `siftDown`: This method corrects the heap property by moving an element down the heap until it reaches its correct position. It compares the element with its children and swaps it with the smaller child if necessary.
	- `siftUp`: This method corrects the heap property by moving an element up the heap until it reaches its correct position.
	   It compares the element with its parent and swaps it if necessary.
	- `Peek`: This method returns the minimum element in the heap (the root of the heap) without removing it.
	- `Remove`: This method removes and returns the minimum element in the heap. It swaps the root with the last element,
	   removes the last element from the heap, and then calls `siftDown` to maintain the heap property.
	- `Insert`: This method inserts a new element into the heap. It appends the element to the end of the heap and then
	   calls `siftUp` to maintain the heap property.
	- `swap`: This method swaps two elements in the heap given their indices.
	- `length`: This method returns the number of elements in the heap.

	Overall, this code provides a basic implementation of a MinHeap data structure, allowing for efficient insertion, removal,
	and retrieval of the minimum element.

	BuildHeap: O(n) time | O(1) space - where n is the length of the input array
	SiftDown: O(log(n)) time | O(1) space - where n is the length of the heap
	SiftUp: O(log(n)) time | O(1) space - where n is the length of the heap
	Peek: O(1) time | O(1) space
	Remove: O(log(n)) time | O(1) space - where n is the length of the heap
	Insert: O(log(n)) time | O(1) space - where n is the length of the heap

*/
class MinHeap {
  constructor(array) {
    this.heap = array.slice(); // Create a copy of the input array
    this.size = array.length;
    this.buildHeap(); // Build the heap
  }

  buildHeap() {
    const first = Math.floor((this.size - 2) / 2); // Start from the last parent node
    for (let currentIdx = first; currentIdx >= 0; currentIdx--) {
      this.siftDown(currentIdx);
    }
  }

  siftDown(currentIndex) {
    let childOneIdx = currentIndex * 2 + 1; // Calculate the index of the first child
    while (childOneIdx < this.size) {
      let childTwoIdx = -1; // Initialize the index of the second child
      if (currentIndex * 2 + 2 < this.size) {
        childTwoIdx = currentIndex * 2 + 2; // Calculate the index of the second child if it exists
      }
      let indexToSwap = childOneIdx; // Assume the first child is the one to swap with
      if (childTwoIdx > -1 && this.heap[childOneIdx] > this.heap[childTwoIdx]) {
        // If the second child exists and is smaller, update the index to swap with
        indexToSwap = childTwoIdx;
      }
      if (this.heap[currentIndex] > this.heap[indexToSwap]) {
        // If the current element is greater than the one to swap with, perform the swap
        this.swap(currentIndex, indexToSwap);
        currentIndex = indexToSwap;
        childOneIdx = currentIndex * 2 + 1; // Update the index of the first child
      } else {
        return;
      }
    }
  }

  siftUp() {
    let currentIdx = this.size - 1; // Start from the last element
    let parentIdx = Math.floor((currentIdx - 1) / 2); // Calculate the index of the parent
    while (currentIdx > 0) {
      const current = this.heap[currentIdx];
      const parent = this.heap[parentIdx];
      if (current < parent) {
        // If the current element is smaller than the parent, perform the swap
        this.swap(currentIdx, parentIdx);
        currentIdx = parentIdx;
        parentIdx = Math.floor((currentIdx - 1) / 2); // Update the index of the parent
      } else {
        return;
      }
    }
  }

  peek() {
    if (this.size === 0) {
      return -1;
    }
    return this.heap[0]; // Return the minimum element at the top of the heap
  }

  remove() {
    this.swap(0, this.size - 1); // Swap the root with the last element
    const peeked = this.heap[this.size - 1]; // Remove the last element (minimum) and store it
    this.size--;
    this.heap.length = this.size; // Resize the heap array
    this.siftDown(0); // Sift down the new root element
    return peeked;
  }

  insert(value) {
    this.heap.push(value); // Append the new element to the end of the heap
    this.size++;
    this.siftUp(); // Sift up the new element to its correct position
  }

  swap(i, j) {
    [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]]; // Swap elements at indices i and j
  }

  length() {
    return this.size; // Return the number of elements in the heap
  }
}

// Example usage:
const array = [9, 4, 7, 1, -2, 6, 5];
const minHeap = new MinHeap(array);

console.log("Peek:", minHeap.peek());
console.log("Remove:", minHeap.remove());
console.log("Length:", minHeap.length());

minHeap.insert(2);
minHeap.insert(-5);

console.log("Peek:", minHeap.peek());
console.log("Length:", minHeap.length());

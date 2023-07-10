'''
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

'''
class MinHeap:
    def __init__(self):
        self.heap = []  # The heap represented as a list

    def build_heap(self, array):
        # Build the heap by calling sift_down on each parent node
        first = (len(array) - 2) // 2  # Start from the last parent node
        for current_idx in range(first, -1, -1):
            self.sift_down(current_idx, len(array) - 1)

    def sift_down(self, current_idx, end_idx):
        child_one_idx = current_idx * 2 + 1  # Calculate the index of the first child
        while child_one_idx <= end_idx:
            child_two_idx = -1  # Initialize the index of the second child
            if current_idx * 2 + 2 <= end_idx:
                child_two_idx = current_idx * 2 + 2  # Calculate the index of the second child if it exists
            index_to_swap = child_one_idx  # Assume the first child is the one to swap with
            if child_two_idx > -1 and self.heap[child_one_idx] > self.heap[child_two_idx]:
                # If the second child exists and is smaller, update the index to swap with
                index_to_swap = child_two_idx
            if self.heap[current_idx] > self.heap[index_to_swap]:
                # If the current element is greater than the one to swap with, perform the swap
                self.swap(current_idx, index_to_swap)
                current_idx = index_to_swap
                child_one_idx = current_idx * 2 + 1  # Update the index of the first child
            else:
                return

    def sift_up(self):
        current_idx = len(self.heap) - 1  # Start from the last element
        parent_idx = (current_idx - 1) // 2  # Calculate the index of the parent
        while current_idx > 0:
            current, parent = self.heap[current_idx], self.heap[parent_idx]
            if current < parent:
                # If the current element is smaller than the parent, perform the swap
                self.swap(current_idx, parent_idx)
                current_idx = parent_idx
                parent_idx = (current_idx - 1) // 2  # Update the index of the parent
            else:
                return

    def peek(self):
        if not self.heap:
            return -1
        return self.heap[0]  # Return the minimum element at the top of the heap

    def remove(self):
        l = len(self.heap)
        self.swap(0, l - 1)  # Swap the root with the last element
        peeked = self.heap.pop()  # Remove the last element (minimum) and store it
        self.sift_down(0, l - 2)  # Sift down the new root element
        return peeked

    def insert(self, value):
        self.heap.append(value)  # Append the new element to the end of the heap
        self.sift_up()  # Sift up the new element to its correct position

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]  # Swap elements at indices i and j

    def length(self):
        return len(self.heap)  # Return the number of elements in the heap


def new_min_heap(array):
    heap = MinHeap()  # Create a new MinHeap object
    heap.build_heap(array)  # Build the heap using the given array
    return heap

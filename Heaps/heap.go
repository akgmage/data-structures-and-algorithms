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
package main

// MinHeap represents a min heap data structure.
type MinHeap []int

// NewMinHeap creates a new MinHeap from an input array and returns a pointer to it.
func NewMinHeap(array []int) *MinHeap {
	// Create a heap from the input array
	heap := MinHeap(array)
	ptr := &heap
	// Build the heap structure
	ptr.BuildHeap(array)
	return ptr
}

// BuildHeap constructs the heap by calling siftDown on each parent node.
func (h *MinHeap) BuildHeap(array []int) {
	// Calculate the index of the first parent node
	first := (len(array) - 2) / 2
	// Iterate over each parent node and sift it down
	for currentIdx := first + 1; currentIdx >= 0; currentIdx-- {
		h.siftDown(currentIdx, len(array)-1)
	}
}

// siftDown moves an element down the heap until it reaches its correct position.
func (h *MinHeap) siftDown(currentIndex, endIndex int) {
	childOneIdx := currentIndex*2 + 1
	for childOneIdx <= endIndex {
		childTwoIdx := -1
		if currentIndex*2+2 <= endIndex {
			childTwoIdx = currentIndex*2 + 2
		}
		indexToSwap := childOneIdx
		if childTwoIdx > -1 && (*h)[childOneIdx] > (*h)[childTwoIdx] {
			indexToSwap = childTwoIdx
		}
		if (*h)[currentIndex] > (*h)[indexToSwap] {
			h.swap(currentIndex, indexToSwap)
			currentIndex = indexToSwap
			childOneIdx = currentIndex*2 + 1
		} else {
			return
		}
	}
}

// siftUp moves an element up the heap until it reaches its correct position.
func (h *MinHeap) siftUp() {
	currentIdx := h.length() - 1
	parentIdx := (currentIdx - 1) / 2
	for currentIdx > 0 {
		current, parent := (*h)[currentIdx], (*h)[parentIdx]
		if current < parent {
			h.swap(currentIdx, parentIdx)
			currentIdx = parentIdx
			parentIdx = (currentIdx - 1) / 2
		} else {
			return
		}
	}
}

// Peek returns the minimum element in the heap without removing it.
func (h MinHeap) Peek() int {
	if len(h) == 0 {
		return -1
	}
	return h[0]
}

// Remove removes and returns the minimum element in the heap.
func (h *MinHeap) Remove() int {
	l := h.length()
	h.swap(0, l-1)
	peeked := (*h)[l-1]
	*h = (*h)[:l-1]
	h.siftDown(0, l-1)
	return peeked
}

// Insert inserts a new element into the heap.
func (h *MinHeap) Insert(value int) {
	*h = append(*h, value)
	h.siftUp()
}

// swap swaps two elements in the heap given their indices.
func (h MinHeap) swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

// length returns the number of elements in the heap.
func (h MinHeap) length() int {
	return len(h)
}

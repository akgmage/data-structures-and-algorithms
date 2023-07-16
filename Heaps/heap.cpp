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
#include <vector>

class MinHeap {
public:
    std::vector<int> heap;  // The heap represented as a vector

    void buildHeap(std::vector<int>& array) {
        int first = (array.size() - 2) / 2;  // Start from the last parent node
        for (int currentIdx = first; currentIdx >= 0; currentIdx--) {
            siftDown(currentIdx, array.size() - 1);
        }
    }

    void siftDown(int currentIndex, int endIndex) {
        int childOneIdx = currentIndex * 2 + 1;  // Calculate the index of the first child
        while (childOneIdx <= endIndex) {
            int childTwoIdx = -1;  // Initialize the index of the second child
            if (currentIndex * 2 + 2 <= endIndex) {
                childTwoIdx = currentIndex * 2 + 2;  // Calculate the index of the second child if it exists
            }
            int indexToSwap = childOneIdx;  // Assume the first child is the one to swap with
            if (childTwoIdx > -1 && heap[childOneIdx] > heap[childTwoIdx]) {
                // If the second child exists and is smaller, update the index to swap with
                indexToSwap = childTwoIdx;
            }
            if (heap[currentIndex] > heap[indexToSwap]) {
                // If the current element is greater than the one to swap with, perform the swap
                swap(currentIndex, indexToSwap);
                currentIndex = indexToSwap;
                childOneIdx = currentIndex * 2 + 1;  // Update the index of the first child
            } else {
                return;
            }
        }
    }

    void siftUp() {
        int currentIdx = heap.size() - 1;  // Start from the last element
        int parentIdx = (currentIdx - 1) / 2;  // Calculate the index of the parent
        while (currentIdx > 0) {
            int current = heap[currentIdx];
            int parent = heap[parentIdx];
            if (current < parent) {
                // If the current element is smaller than the parent, perform the swap
                swap(currentIdx, parentIdx);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;  // Update the index of the parent
            } else {
                return;
            }
        }
    }

    int peek() {
        if (heap.empty()) {
            return -1;
        }
        return heap[0];  // Return the minimum element at the top of the heap
    }

    int remove() {
        int l = heap.size();
        swap(0, l - 1);  // Swap the root with the last element
        int peeked = heap[l - 1];  // Remove the last element (minimum) and store it
        heap.pop_back();
        siftDown(0, l - 2);  // Sift down the new root element
        return peeked;
    }

    void insert(int value) {
        heap.push_back(value);  // Append the new element to the end of the heap
        siftUp();  // Sift up the new element to its correct position
    }

    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;  // Swap elements at indices i and j
    }

    int length() {
        return heap.size();  // Return the number of elements in the heap
    }
};

MinHeap* newMinHeap(std::vector<int>& array) {
    MinHeap* heap = new MinHeap();  // Create a new MinHeap object
    heap->buildHeap(array);  // Build the heap using the given array
    return heap;
}

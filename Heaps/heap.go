/*
	Implement a Min-Heap class that supports

		Building a Min Heap from an input array of integers.
		Inserting integers in the heap.
		Removing the heap's minimum / root value.
		Peeking at the heap's minimum / root value.
		Sifting integers up and down the heap, which is to be used when inserting and removing values.

	Note that the heap should be represented in the form of an array.

*/
package main

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
type MinHeap []int

func NewMinHeap(array []int) *MinHeap {
	// Do not edit the lines below.
	heap := MinHeap(array)
	ptr := &heap
	ptr.BuildHeap(array)
	return ptr
}

func (h *MinHeap) BuildHeap(array []int) {
	first := (len(array) - 2) / 2
    for currentIdx := first + 1; currentIdx >= 0; currentIdx-- {
        h.siftDown(currentIdx, len(array) - 1)
    }
}

func (h *MinHeap) siftDown(currentIndex, endIndex int) {
	childOneIdx := currentIndex * 2 + 1
    for childOneIdx <= endIndex {
        childTwoIdx := -1
        if currentIndex * 2 + 2 <= endIndex {
            childTwoIdx = currentIndex * 2 + 2
        }
        indexToSwap := childOneIdx
        if childTwoIdx > -1 && (*h)[childOneIdx] > (*h)[childTwoIdx] {
            indexToSwap = childTwoIdx
        }
        if (*h)[currentIndex] > (*h)[indexToSwap] {
            h.swap(currentIndex, indexToSwap)
            currentIndex = indexToSwap
            childOneIdx = currentIndex * 2 + 1
        } else {
            return
        }
    }
    
}

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

func (h MinHeap) Peek() int {
	if len(h) == 0 {
        return -1
    }
    return h[0]
}

func (h *MinHeap) Remove() int {
	l := h.length()
    h.swap(0, l - 1)
    peeked := (*h)[l - 1]
    *h = (*h)[: l - 1]
    h.siftDown(0, l - 1)
    return peeked
}

func (h *MinHeap) Insert(value int) {
	*h = append(*h, value)
    h.siftUp()
}

func (h MinHeap) swap(i, j int) {
    h[i], h[j] = h[j], h[i]
}

func (h MinHeap) length() int {
    return len(h)
}
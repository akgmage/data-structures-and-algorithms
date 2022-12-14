package main

import (
	"fmt"
	"math"
)

// Item: Defines the interface for an element to be held by a Heap instance
type Item interface {
	Less(item Item) bool
}
// Heap: binary heap with support for min heap operations
type Heap struct {
	size int
	data []Item
}

// New: returns a pointer to an empty min-heap
func New() *Heap {
	return &Heap{}
}

// Parent: For a node at ith location its parent is ar (i - 1) / 2 location
func Parent(i int) int {
	return int(math.Floor(float64(i - 1) / 2.0))
}

// LeftChild: For a node at ith location its left children is at 2 * i + 1 location
func LeftChild(parent int) int {
	return (2 * parent) + 1
}

// RightChild: For a node at ith location its right children is at 2 * i + 2 th locations
func RightChild(parent int) int {
	return (2 * parent) + 2
}

// GetMinimum: Minimum element is always at root
func GetMinimum(h *Heap) (Item, error) {
	if h.size == 0 {
		return nil, fmt.Errorf("Unable to get element from empty heap")
	}
	return h.data[0], nil
}

// Note: Deleting an element uses percolateUp, and inserting an element uses percolateDown.
// PercolateUp: move from bottom to top
// Heap is a complete binary tree and in the worst case we start at the root and come
// down to the leaf. This is equal to the height of the complete binary tree.
// Time Complexity: O(log n) Space Complexity: O(1).
func (h *Heap) percolateUp() {
	idx := h.size
	if idx <= 0 {
		return
	}
	for {
		p := Parent(idx)
		if p < 0 || h.data[p].Less(h.data[idx]) {
			break
		}
		swap(h, p, idx)
		idx = p
	}
}

// To delete an element from heap, we just need to delete the element from the root. This is the only operation
// (maximum element) supported by standard heap. After deleting the root element, copy the last element of the heap
// (tree) and delete that last element.
// After replacing the last element, the tree may not satisfy the heap property. To make it heap again, call the
// percolateDown function.
// 1 Copy the first element into some variable
// 2 Copy the last element into first element location
// 3 percolateDown the first element
// Time Complexity: O(log n) Space Complexity: O(1).
func (h *Heap) percolateDown(i int) {
	p := i
	for {
		l := LeftChild(p)
		r := RightChild(p)
		s := p
		if l < h.size && h.data[l].Less(h.data[s]) {
			s = l
		}
		if r < h.size && h.data[r].Less(h.data[s]) {
			s = r
		}
		if s == p {
			break
		}
		swap(h, p, s)
		p = s
	}
}

func swap(h *Heap, i int, j int) {
	temp := h.data[i]
	h.data[i] = h.data[j]
	h.data[j] = temp
}

// Extract - removes and returns the 'item' at the top of the heap, maintaining the min-heap invariant
func (h *Heap) Extract() (Item, error) {
	n := h.size
	if n == 0 {
		return nil, fmt.Errorf("Unable to extract from empty Heap")
	}
	m := h.data[0]
	h.data[0] = h.data[n-1]
	h.data = h.data[:n-1]
	h.size--
	if h.size > 0 {
		h.percolateDown(0)
	} else {
		h.data = nil
	}
	return m, nil
}

// Insert - inserts 'item' into the Heap, maintaining the min-heap
func (h *Heap) Insert(item Item) { 
	if h.size == 0 {
		h.data = make([]Item, 1)
		h.data[0] = item
	} else {
		h.data = append(h.data, item)
	}
	h.size++
	h.percolateUp()
}

// Heapify - returns a pointer to a min-heap composed of the elements of 'items'
// One simple approach for building the heap is, take n input items and place them into an empty heap. This can be
// done with n successive inserts and takes O(nlogn) in the worst case. This is due to the fact that each insert
// operation takes O(logn).
func Heapify(items []Item) *Heap {
	h := New()
	n := len(items)
	h.data = make([]Item, n)
	copy(h.data, items)
	h.size = len(items)
	i := int(n/2)
	for i >= 0 {
		h.percolateDown(i)
		i--
	}
	return h
}
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
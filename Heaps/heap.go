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


func swap(h *Heap, i int, j int) {
	temp := h.data[i]
	h.data[i] = h.data[j]
	h.data[j] = temp
}
package main

import "math"

type Item interface {
	Less(item Item) bool
}

type Heap struct {
	size int
	data []Item
}

func New() *Heap {
	return &Heap{}
}

func Parent(i int) int {
	return int(math.Floor(float64(i - 1) / 2.0))
}
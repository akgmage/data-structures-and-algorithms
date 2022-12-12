package main

type Item interface {
	Less(item Item) bool
}

type Heap struct {
	size int
	data []Item
}
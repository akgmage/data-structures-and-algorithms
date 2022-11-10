package main

type node struct {
	data int
	next *node
}

type linkedlist struct {
	length int
	head   *node
	tail   *node
}

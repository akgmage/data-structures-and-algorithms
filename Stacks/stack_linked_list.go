package main

type Stack struct {
	top *ListNode
	size int
}

type ListNode struct {
	data interface{}
	next *ListNode
}


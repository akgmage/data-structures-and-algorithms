package main

import "fmt"

type Stack struct {
	top  *ListNode
	size int
}

type ListNode struct {
	data interface{}
	next *ListNode
}

// Size: Returns the size of Stack
func (s *Stack) Length() int {
	return s.size
}

// Push: Pushes new [data] into Stack
// Time complexity O(1)
// Space complexity for n push operations O(n)
func (s *Stack) Push(data interface{}) {
	s.top = &ListNode{data, s.top}
	s.size++
	fmt.Printf("\n%v Pushed to stack", data)
}

// IsEmpty: Returns true if Stack is empty or else false
// Time complexity O(1)
func (s *Stack) IsEmpty() bool {
	return s.size == 0
}

// IsFull: Returns false since its LL based implementation
// Time complexity O(1)
func (s *Stack) IsFull() bool {
	return false
}

// Pop: Pops top most data from Stack
// Time complexity O(1)
func (s *Stack) Pop() (data interface{}) {
	if s.size > 0 {
		data, s.top = s.top.data, s.top.next
		s.size--
		fmt.Printf("\n%v Popped from stack", data)
		return data
	}
	return nil
}

// Peek: Returns top most element from Stack
// Time complexity O(1)
func (s *Stack) Peek() (data interface{}) {
	if s.size > 0 {
		data = s.top.data
		fmt.Printf("\n%v is the topmost element in stack", data)
		return data
	}
	return nil
}

func main() {
	stack := new(Stack)
	stack.Push("Hello")
	stack.Push("World!")
	stack.Push("Yo")
	stack.Peek()
	fmt.Println(stack.Length())
	stack.Pop()
	stack.Pop()
	stack.Pop()
}
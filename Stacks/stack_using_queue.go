// stack using queues
package main

import (
	"container/list"
	"fmt"
)

// Stack represents a stack data structure using two queues.
type Stack struct {
	queue1 *list.List // Primary queue
	queue2 *list.List // Temporary queue for operations
}

// Constructor creates a new stack.
func NewStack() *Stack {
	return &Stack{
		queue1: list.New(),
		queue2: list.New(),
	}
}

// Push adds an element to the top of the stack.
func (s *Stack) Push(value int) {
	// Add the element to the primary queue
	s.queue1.PushBack(value)
}

// Pop removes and returns the top element of the stack.
func (s *Stack) Pop() int {
	// Move elements from the primary queue to the temporary queue except the last one
	for s.queue1.Len() > 1 {
		element := s.queue1.Front()
		s.queue1.Remove(element)
		s.queue2.PushBack(element.Value)
	}

	// Get the last element from the primary queue (top of the stack)
	topElement := s.queue1.Front().Value

	// Swap the primary and temporary queues
	s.queue1, s.queue2 = s.queue2, s.queue1

	return topElement.(int)
}

// Top returns the top element of the stack without removing it.
func (s *Stack) Top() int {
	// Similar to Pop, but don't remove the last element
	topElement := s.Pop()

	// Add the top element back to the stack
	s.Push(topElement)

	return topElement
}

// IsEmpty checks if the stack is empty.
func (s *Stack) IsEmpty() bool {
	return s.queue1.Len() == 0
}

func main() {
	stack := NewStack()

	// Push elements onto the stack
	stack.Push(1)
	stack.Push(2)
	stack.Push(3)

	// Pop elements from the stack
	fmt.Println(stack.Pop()) // Output: 3
	fmt.Println(stack.Pop()) // Output: 2

	// Push more elements
	stack.Push(4)
	stack.Push(5)

	// Peek at the top element
	fmt.Println(stack.Top()) // Output: 5

	// Check if the stack is empty
	fmt.Println(stack.IsEmpty()) // Output: false
}

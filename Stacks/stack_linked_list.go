package main

type Stack struct {
	top  *ListNode
	size int
}

type ListNode struct {
	data interface{}
	next *ListNode
}

// Size: Returns the size of Stack
func (s *Stack) length() int {
	return s.size
}

// Push: Pushes new [data] into Stack
func (s *Stack) push(data interface{}) {
	s.top = &ListNode{data, s.top}
}

// IsEmpty: Returns true if Stack is empty or else false
func (s *Stack) IsEmpty() bool {
	return s.size == 0
}

// IsFull: Returns false since its LL based implementation
func (s *Stack) IsFull() bool {
	return false
}

// Pop: Pops top most data from Stack
func (s *Stack) Pop() (data interface{}) {
	if s.size > 0 {
		data, s.top = s.top.data, s.top.next
		s.size--
		return data
	}
	return nil
}

// Peek: Returns top most element from Stack
func (s *Stack) Peek() (data interface{}) {
	if s.size > 0 {
		data = s.top.data
		return data
	}
	return nil
}
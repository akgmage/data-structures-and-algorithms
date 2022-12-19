package main

type Stack struct {
	top  *ListNode
	size int
}

type ListNode struct {
	data interface{}
	next *ListNode
}

func (s *Stack) length() int {
	return s.size
}

func (s *Stack) push(data interface{}) {
	s.top = &ListNode{data, s.top}
}

func (s *Stack) IsEmpty() bool {
	return s.size == 0
}

func (s *Stack) IsFull() bool {
	return false
}

func (s *Stack) Pop() (data interface{}) {
	if s.size > 0 {
		data, s.top = s.top.data, s.top.next
		s.size--
		return data
	}
	return nil
}

func (s *Stack) Peek() (data interface{}) {
	if s.size > 0 {
		data = s.top.data
		return data
	}
	return nil
}
package main

import "errors"

type Stack struct {
	top      int
	capacity uint
	array    []interface{}
}

// Init: Returns an Initialized Stack
func (stack *Stack) Init(capacity uint) *Stack {
	stack.top = -1
	stack.capacity = capacity
	stack.array = make([]interface{}, capacity)
	return stack
}

// NewStack: Returns a new Stack
func NewStack(capacity uint) *Stack {
	return new(Stack).Init(capacity)
}

// IsFull: Returns true if Stack is full oe else false
func (stack *Stack) IsFull() bool {
	return stack.top == int(stack.capacity)-1
}

// IsEmpty: Returns true if Stack is empty oe else false
func (stack *Stack) IsEmpty() bool {
	return stack.top == -1
}

// Size: Returns the size of Stack
func (stack *Stack) Size() uint {
	return uint(stack.top + 1)
}

// Push: Pushes new [data] into stack
func (stack *Stack) Push(data interface{}) error {
	if stack.IsFull() {
		return errors.New("Stack is full")
	}
	stack.top++
	stack.array[stack.top] = data
	return nil
}
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

// Size: Returns the size of Stack
func (stack *Stack) Size() uint {
	return uint(stack.top + 1)
}

// IsFull: Returns true if Stack is full or else false
func (stack *Stack) IsFull() bool {
	return stack.top == int(stack.capacity)+1
}

// IsEmpty: Returns true if Stack is empty or else false
func (stack *Stack) IsEmpty() bool {
	return stack.top == -1
}

// Resize: If the array is full, creates a new array of
// twice the size, and copy the items
func (stack *Stack) Resize() {
	if stack.IsFull() {
		stack.capacity *= 2
	} else {
		stack.capacity /= 2
	}
	target := make([]interface{}, stack.capacity)
	copy(target, stack.array[:stack.top+1])
	stack.array = target
}

// Push: Pushes new [data] into Stack, resizes to double if stack is full
func (stack *Stack) Push(data interface{}) error {
	if stack.IsFull() {
		stack.Resize()
	}
	stack.top++
	stack.array[stack.top] = data
	return nil
}

// Pop: Pops top most data from Stack, resizes to hald if sizeof stack is less than half the capacity
func (stack *Stack) Pop() (interface{}, error) {
	if stack.IsEmpty() {
		return nil, errors.New("Stack is empty")
	}
	temp := stack.array[stack.top]
	stack.top--
	if stack.Size() < stack.capacity / 2 {
		stack.Resize()
	}
	return temp, nil
}
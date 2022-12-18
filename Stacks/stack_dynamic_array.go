package main

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
func Size(stack *Stack) uint {
	return uint(stack.top + 1)
}

// IsFull: Returns true if Stack is full or else false
func IsFull(stack *Stack) bool {
	return stack.top == int(stack.capacity)+1
}

// IsEmpty: Returns true if Stack is empty or else false
func IsEmpty(stack *Stack) bool {
	return stack.top == -1
}
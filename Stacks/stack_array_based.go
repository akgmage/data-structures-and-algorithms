package main

type Stack struct {
	top int
	capacity uint
	array []interface{}
}
func (stack *Stack) Init(capacity uint) *Stack {
	stack.top = -1
	stack.capacity = capacity
	stack.array = make([]interface{}, capacity)
	return stack
}

func NewStack(capacity uint) *Stack {
	return new(Stack).Init(capacity)
}

func (stack *Stack) IsFull() bool {
	return stack.top == int(stack.capacity) - 1
}
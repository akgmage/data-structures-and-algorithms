// Using Repeated Array doubling technique.
// If the array is full, create a new array of
// twice the size, and copy the items. With this approach, pushing k items
// takes time proportional to k
package main

import (
	"errors"
	"fmt"
	"strings"
)

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
// Time complexity O(1)
func (stack *Stack) Size() uint {
	return uint(stack.top + 1)
}

// IsFull: Returns true if Stack is full or else false
// Time complexity O(1)
func (stack *Stack) IsFull() bool {
	// Stack is full when top is equal to the last index
	return stack.top == int(stack.capacity) - 1
}

// IsEmpty: Returns true if Stack is empty or else false
// Time complexity O(1)
func (stack *Stack) IsEmpty() bool {
	// Stack is empty when top is equal to -1
	return stack.top == -1
}

// Resize: If the array is full, creates a new array of
// twice the size, and copy the items
func (stack *Stack) Resize() {
	fmt.Println("Resizing")
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
// Time complexity O(1)
// Space complexity for n push operations O(n)
func (stack *Stack) Push(data interface{}) error {
	if stack.IsFull() {
		stack.Resize()
	}
	stack.top++
	stack.array[stack.top] = data
	fmt.Printf("\n%v Pushed to stack", data)
	return nil
}

// Pop: Pops top most data from Stack, resizes to hald if sizeof stack is less than half the capacity
// Time complexity O(1)
func (stack *Stack) Pop() (interface{}, error) {
	if stack.IsEmpty() {
		return nil, errors.New("Stack is empty")
	}
	temp := stack.array[stack.top]
	fmt.Printf("\n%v Popped from stack", temp)
	stack.top--
	if stack.Size() < stack.capacity / 2 {
		stack.Resize()
	}
	return temp, nil
}

// Peek: Returns top most element from Stack
// Time complexity O(1)
func (stack *Stack) Peek() (interface{}, error) {
	if stack.IsEmpty() {
		return nil, errors.New("Stack is empty")
	}
	temp := stack.array[stack.top]
	fmt.Printf("\n%v is the topmost element in stack", temp)
	return temp, nil
}

// Drain: Removes all elements that are currently in Stack
// Time complexity O(1)
func (stack *Stack) Drain() {
	stack.array = nil
	stack.top = -1
}


func IsOperator(c uint8) bool {
	return strings.ContainsAny(string(c), "+ & - & * & /")
}

func IsOperand(c uint8) bool {
	return c >= '0' && c <= '9'
}

func GetOperatorWeight(op string) int {
	switch op {
		case "+", "-" : return 1
		case "*", "/" : return 2
	}
	return -1
}

func ToPostfix(s string) string {
	stack := NewStack(1)
	postfix := ""
	length := len(s)

	for i := 0; i < length; i++ {
		char := string(s[i])
		if char == " " {
			continue
		}
		if char == "(" {
			stack.Push(char)
		} else if char == ")" {
			for !stack.IsEmpty() {
				temp, _ := stack.Peek()
				str := temp.(string)
				if str == "(" {
					break
				}
				postfix += " " + str
				stack.Pop()
			}
			stack.Pop()
		}
	}
}

func HasHigherPrecedence(op1 string, op2 string) bool {
	op1Weight := GetOperatorWeight(op1)
	op2Weight := GetOperatorWeight(op2)
	return op1Weight >= op2Weight
}

func main() {
	stack := NewStack(1)
	stack.Push(1)
	stack.Push(2)
	stack.Push(3)
	fmt.Println(stack.Size())
	stack.Pop()
	stack.Pop()
	stack.Pop()
	stack.Drain()
	stack.Peek()
	fmt.Println(ToPostfix("((1+(4+5+2)-3)+(6+8))"))
}
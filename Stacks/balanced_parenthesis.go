// Checking balancing of symbols/parentheses.

package main

import (
	"errors"
	"fmt"
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

type Pair struct {
	open rune
	close rune
}

var pairs = []Pair {
	{'(', ')'},
	{'[', ']'},
	{'{', '}'},
}
// IsValid: returns true if string has balanced parenthesis
// Approach : If the character read is not a symbol to be balanced, ignore it.
// If the character is an opening symbol like (, [, {, push it onto the stack.
// If it is a closing symbol like ),],}, then if the stack is empty report an error. Otherwise pop the stack.
// If the symbol popped is not the corresponding opening symbol, report an error.
// At end of input, if the stack is not empty report an error
// Time Complexity: O(n). Since we are scanning the input only once. Space Complexity: O(n) [for stack].
func IsValid(s string) bool {
	stack := NewStack(1)
	for _, r := range s {
		for _, p := range pairs {
			temp, _ := stack.Peek()
			if r == p.open {
				stack.Push(r)
			} else if r == p.close && stack.IsEmpty() {
				return false
			} else if r == p.close && temp == p.open {
				stack.Pop()
				break
			} else if r == p.close && temp != p.open {
				return false
			}
		}
	}
	return stack.IsEmpty()
}

func main() {
	fmt.Println(IsValid("()(1[23){}{}"))
}
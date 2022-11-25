// Implement Stack Data Structure
// TODO: Make Stack Generic

package main

import "fmt"

type Stack []string

// IsEmpty func checks if the stack is empty
func (s *Stack) IsEmpty() bool {
	return len(*s) == 0
}

// Push func pushes a new value into the stack
func (s *Stack) Push(str string) {
	fmt.Printf("%s pushed into stack\n", str)
	*s = append(*s, str)
}
// Pop func pops the top most value from stack if there is any
func (s *Stack) Pop() (string, bool) {
	if s.IsEmpty() {
		return "", false
	} else {
		index := len(*s) - 1
		element := (*s)[index]
		*s = (*s)[:index]
		return element, true
	}
}
func main() {
	var stack Stack
	
	// push 3 values in stack
	stack.Push("Hello0")
	stack.Push("Hello1")
	stack.Push("Hello2")
	
	// pop out all values from stack
	for len(stack) > 0 {
		x, y := stack.Pop()
		if y == true {
			fmt.Printf("%s popped from stack\n", x)
		}
	}

}
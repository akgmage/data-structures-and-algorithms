package main

import "fmt"

type Stack []string

func (s *Stack) IsEmpty() bool {
	return len(*s) == 0
}

func (s *Stack) Push(str string) {
	fmt.Printf("%s pushed into stack\n", str)
	*s = append(*s, str)
}

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
	stack.Push("Hello0")
	stack.Push("Hello1")
	stack.Push("Hello2")

	for len(stack) > 0 {
		x, y := stack.Pop()
		if y == true {
			fmt.Printf("%s popped from stack\n", x)
		}
	}

}
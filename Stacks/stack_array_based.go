package main

import (
	"errors"
	"fmt"

	"golang.org/x/tools/go/analysis/unitchecker"
)

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
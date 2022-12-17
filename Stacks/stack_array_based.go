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
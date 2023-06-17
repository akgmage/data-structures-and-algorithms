package main

import "fmt"

type UnionFind struct {
	parents map[int]int
}

func NewUnionFind() *UnionFind {
	return &UnionFind{
		parents: map[int]int{},
	}
}

func (union *UnionFind) CreateSet(value int) {
	union.parents[value] = value
}

func (union *UnionFind) Find(value int) *int {
	// Check if the value exists in the parents map
	if _, found := union.parents[value]; !found {
		return nil // Value not found, return nil
	}

	currentParent := value
	// Find the representative (parent) by following the parent links
	for currentParent != union.parents[currentParent] {
		currentParent = union.parents[currentParent]
	}

	return &currentParent
}

func (union *UnionFind) Union(valueOne, valueTwo int) {
	// Check if both values exist in the parents map
	_, parentContainsOne := union.parents[valueOne]
	_, parentContainsTwo := union.parents[valueTwo]
	if !parentContainsOne || !parentContainsTwo {
		return // One or both values are missing, return without union
	}

	valueOneRoot := *union.Find(valueOne)
	valueTwoRoot := *union.Find(valueTwo)
	// Perform union by updating the parent of valueTwoRoot to valueOneRoot
	union.parents[valueTwoRoot] = valueOneRoot
}

func main() {
	// Create a new instance of UnionFind
	union := NewUnionFind()

	// Create individual sets
	union.CreateSet(1)
	union.CreateSet(2)
	union.CreateSet(3)

	// Perform union operations
	union.Union(1, 2)
	union.Union(2, 3)

	// Find representatives of values
	representative := union.Find(3)

	// Check if the representative is found
	if representative != nil {
		fmt.Println("The representative of 3 is:", *representative)
	} else {
		fmt.Println("Value 3 is not found.")
	}
}
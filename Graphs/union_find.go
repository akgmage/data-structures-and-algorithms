package main

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


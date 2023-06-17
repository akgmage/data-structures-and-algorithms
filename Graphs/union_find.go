/*
	Write a UnionFind class that implements the union-find (also called a disjoint set) data structure.
	This class should support three methods:


	The union-find data structure is similar to a traditional set data structure in that it contains a collection
	of unique values. However, these values are spread out amongst a variety of distinct disjoint sets, meaning that no set
	can have duplicate values, and no two sets can contain the same value.

	createSet(value) : : Adds a given value in a new set containing only that value.

	union(valueOne, valueTwo) : : Takes in two values and determines which sets they are in. If they are in different sets, the sets are combined
    into a single set. If either value is not in a set or they are in the same set, the function should have no effect.

	find(value): : Returns the "representative" value of the set for which a value belongs to. This can be any value in the set, but it should
    always be the same value, regardless of which value in the set find  is passed. If the value is not in a set, the function
    should return null / none

	Explanation:
	The code snippet you provided implements the Union-Find data structure, which is used for efficient operations on disjoint
	sets. Here's a detailed explanation of each part:


	- The `UnionFind` struct represents the Union-Find data structure. It contains a map called `parents` that will store the
	parent element for each set element.


	- `NewUnionFind()` is a constructor function that creates a new instance of the Union-Find data structure and initializes
	an empty `parents` map.


	- `CreateSet(value int)` is a method of the `UnionFind` struct. It creates a new set with the given `value` as the
	representative (parent) of the set. It adds an entry to the `parents` map, where the `value` maps to itself.


	- `Find(value int)` is a method that finds and returns the representative (parent) of the set that contains the given
	`value`. It starts from the given `value` and iteratively follows the parent links until it reaches the representative.
	The method returns a pointer to the representative value. If the `value` is not present in the `parents` map, it returns `nil`.


	- `Union(valueOne, valueTwo int)` is a method that performs the union of two sets that contain `valueOne` and `valueTwo`.
	It first checks if both `valueOne` and `valueTwo` exist in the `parents` map. If either of them is missing, it returns
	without performing the union operation. It then finds the representatives of both sets using the `Find()` method.
	It updates the parent of `valueTwoRoot` to be `valueOneRoot`, effectively merging the two sets into one.

	Overall, this code provides a basic implementation of the Union-Find data structure, allowing the creation of sets,
	finding the representative of a set, and performing unions between sets.

	The time and space complexity of the operations in the `UnionFind` data structure are as follows:

	- `NewUnionFind`: This operation has a time complexity of O(1) as it simply initializes a new `UnionFind` instance.
	The space complexity is also O(1) as it only requires memory to store the instance itself.

	- `CreateSet`: This operation has a time complexity of O(1) as it performs a constant number of operations to add
	a value to the `parents` map. The space complexity is also O(1) as it only requires memory to store the mapping between values and their parents.

	- `Find`: has a time complexity of O(n) in the worst case, where n is the number of elements in the disjoint sets

	- `Union`: Union operation in the given implementation has a time complexity of O(n), where n is the number of elements in the data structure.
		The space complexity is O(1) as it does not use any additional memory.

*/
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
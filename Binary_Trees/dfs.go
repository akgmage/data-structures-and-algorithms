package main

type Node struct {
	Value    int
	Children []*Node
}

func (n *Node) DepthFirstSearch(array []int) []int {
	array = append(array, n.Value)
	for _, child := range n.Children {
		array = child.DepthFirstSearch(array)
	}
}
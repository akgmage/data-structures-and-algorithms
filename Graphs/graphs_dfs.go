/*
	DFS on a graph
	Sample Input
        A
     /  |  \
    B   C   D
   / \     / \
  E   F   G   H
     / \   \
    I   J   K
	Output: ["A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"]
*/
package main

import "fmt"

type Node struct {
	Name     string
	Children []*Node
}

func (n *Node) DepthFirstSearch(array []string) []string {
    return n.dfsHelper(array)
}

func (n *Node) dfsHelper(array []string) []string {
    array = append(array, n.Name)
    
    for _, child := range n.Children {
        fmt.Println(child.Name, " -->")
        array = child.dfsHelper(array)
    }
    return array
}

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
/*
	Start at the root Node and try simply calling the depthFirstSearch method on all of its children Nodes.
	Then, call the depthFirstSearch method on all children Nodes of each child node.
	Keep applying this logic until the entire graph has been traversed.
	Don't forget to add the current Node's name to the input array at every call of depthFirstSearch.

	Time and Space complexity:  O(v + e) time | O(v) space - where v is the number of vertices of the input graph and e is the number of edges of the input graph
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

package main
type AdjacencyMatrix struct {
	Vertices int
	Edges int
	GraphType GraphType
	AdjMatrix [][]int
}
type GraphType string
const (
DIRECTED GraphType = "DIRECTED"
UNDIRECTED GraphType = "UNDIRECTED"
)
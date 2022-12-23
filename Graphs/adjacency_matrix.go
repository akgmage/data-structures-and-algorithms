package main

import "errors"

type AdjacencyMatrix struct {
	Vertices  int
	Edges     int
	GraphType GraphType
	AdjMatrix [][]int
}
type GraphType string

const (
	DIRECTED   GraphType = "DIRECTED"
	UNDIRECTED GraphType = "UNDIRECTED"
)

type Graph interface {
	Init()
	AddEdge(vertexOne int, vertexTwo int) error
	AddEdgeWithWeight(vertexOne int, vertexTwo int, weight int) error
	RemoveEdge(vertexOne int, vertexTwo int) error
	HasEdge(vertexOne int, vertexTwo int) bool
	GetGraphType() GraphType
	GetAdjacentNodesForVertex(vertex int) map[int]bool
	GetWeightOfEdge(vertexOne int, vertexTwo int) (int, error)
	GetNumberOfVertices() int
	GetNumberOfEdges() int
	GetIndegreeForVertex(vertex int) int
}

func (G *AdjacencyMatrix) Init() {
	G.AdjMatrix = make([][]int, G.Vertices)
	G.Edges = 0
	for i := 0; i < G.Vertices; i++ {
		G.AdjMatrix[i] = make([]int, G.Vertices) // default initialization is 0
	}
}
func (G *AdjacencyMatrix) AddEdge(vertexOne int, vertexTwo int) error {
	if vertexOne >= G.Vertices || vertexTwo >= G.Vertices || vertexOne < 0 || vertexTwo < 0 {
		return errors.New("Index out of bounds")
	}
	G.AdjMatrix[vertexOne][vertexTwo] = 1
	G.Edges++
	if G.GraphType == UNDIRECTED {
		G.AdjMatrix[vertexTwo][vertexOne] = 1
		G.Edges++
	}
	return nil
}
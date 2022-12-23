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
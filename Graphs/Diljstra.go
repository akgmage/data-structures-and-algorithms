package main

import (
    "fmt"
    "math"
)

// Define a struct to represent a graph.
type Graph struct {
    nodes map[string]map[string]float64
}

// Add an edge to the graph.
func (g *Graph) AddEdge(node1, node2 string, weight float64) {
    if g.nodes == nil {
        g.nodes = make(map[string]map[string]float64)
    }
    if g.nodes[node1] == nil {
        g.nodes[node1] = make(map[string]float64)
    }
    if g.nodes[node2] == nil {
        g.nodes[node2] = make(map[string]float64)
    }
    g.nodes[node1][node2] = weight
    g.nodes[node2][node1] = weight // Assuming an undirected graph
}

// Dijkstra's algorithm to find the shortest path.
func Dijkstra(graph Graph, startNode string) map[string]float64 {
    distances := make(map[string]float64)
    visited := make(map[string]bool)

    for node := range graph.nodes {
        distances[node] = math.Inf(1)
    }

    distances[startNode] = 0

    for {
        var closestNode string
        var shortestDistance float64 = math.Inf(1)

        for node, distance := range distances {
            if !visited[node] && distance < shortestDistance {
                closestNode = node
                shortestDistance = distance
            }
        }

        if closestNode == "" {
            break
        }

        visited[closestNode] = true

        for neighbor, weight := range graph.nodes[closestNode] {
            if newDistance := distances[closestNode] + weight; newDistance < distances[neighbor] {
                distances[neighbor] = newDistance
            }
        }
    }

    return distances
}

func main() {
    // Create a graph.
    g := Graph{}
    g.AddEdge("A", "B", 1)
    g.AddEdge("A", "C", 4)
    g.AddEdge("B", "C", 2)
    g.AddEdge("B", "D", 5)
    g.AddEdge("C", "D", 1)
    g.AddEdge("D", "E", 3)
    g.AddEdge("E", "F", 2)

    // Find the shortest distances from node "A" to all other nodes.
    shortestDistances := Dijkstra(g, "A")

    // Print the shortest distances.
    for node, distance := range shortestDistances {
        fmt.Printf("Shortest distance from A to %s: %v\n", node, distance)
    }
}

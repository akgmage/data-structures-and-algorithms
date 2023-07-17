package main

import "math"
func DijkstrasAlgorithm(start int, edges [][][]int) []int {
	numberOfVertices := len(edges)
    minDistances := make([]int, 0, len(edges))
    for range edges {
        minDistances = append(minDistances, math.MaxInt32)
    }
    minDistances[start] = 0
    visited := map[int]bool{}

    for len(visited) != numberOfVertices {
        vertex, currentMinDistance := getVertexWithMinDistance(minDistances, visited)
        if currentMinDistance == math.MaxInt32 {
            break
        }
        visited[vertex] = true

        for _, edge := range edges[vertex] {
            destination, distanceToDestination := edge[0], edge[1]
            if visited[destination] {
                continue
            } 
            newPathDistance := currentMinDistance + distanceToDestination
            currentDestinationDistance := minDistances[destination]
            if newPathDistance < currentDestinationDistance {
                minDistances[destination] = newPathDistance
            }
        }
    }
    finalDistances := make([]int, 0, len(minDistances))
    for _, distance := range minDistances {
        if distance == math.MaxInt32 {
            finalDistances = append(finalDistances, -1)
        } else {
            finalDistances = append(finalDistances, distance)
        }
    }
    return finalDistances
}

func getVertexWithMinDistance(distances []int, visited map[int]bool) (int, int) {
    currentMinDistance := math.MaxInt32
    vertex := -1

    for vertexIdx, distance := range distances {
        if visited[vertexIdx] {
            continue
        }
        if distance <= currentMinDistance {
            vertex = vertexIdx
            currentMinDistance = distance
        }
    }
    return vertex, currentMinDistance
}
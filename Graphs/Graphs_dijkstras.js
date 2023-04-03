// A class representing a priority queue
class PriorityQueue {
    constructor() {
        this.items = []
    }

    // Adds an item to the priority queue with a given priority
    enqueue(item, priority) {
        let added = false

        for (let i = 0; i < this.items.length; i++) {
            if (priority < this.items[i].priority) {
                this.items.splice(i, 0, { item, priority })
                added = true
                break
            }
        }

        if (!added) this.items.push({ item, priority })
    }

    // Removes and returns the item with minimum priority from the priority queue
    dequeue() {
        if (this.isEmpty()) return null

        return this.items.shift()
    }

    // Returns true if the priority queue is empty, false otherwise
    isEmpty() {
        return this.items.length === 0
    }

    // Returns the number of items in the priority queue
    size() {
        return this.items.length
    }
}

// Performs Dijkstra's shortest path algorithm on a given graph with a specified start node
function dijkstra(graph, n, start) {
    const visited = new Array(n) // An array to keep track of visited nodes
    visited.fill(false)

    const distances = new Array(n) // An array to store the distances from the start node to each node in the graph based on indices
    distances.fill(Number.POSITIVE_INFINITY)
    distances[start] = 0

    // An array to store the previous node in the shortest path to each node in the graph based on indices
    const prev = new Array(n)
    prev.fill(null)

    const pq = new PriorityQueue() //Creating a new priority queue
    pq.enqueue(start, 0) // Initializing the priority queue

    while (!pq.isEmpty()) {
        const val = pq.dequeue() // Dequeue the node with the lowest priority
        const idx = val.item // Get the index of the dequeued node
        const min = val.priority // Get the distance of the dequeued node
        visited[idx] = true // Mark the node as visited

        if (distances[idx] < min) continue // If the distance of the dequeued node is less than the minimum distance, continue to the next iteration of the loop

        // Iterate over the neighbors of the dequeued/current node
        for (let edge of graph[idx]) {
            if (visited[edge]) continue // If the destination node of the edge has already been visited, continue to the next iteration of the loop

            const newDist = distances[idx] + edge.weight // Calculate the new distance to the destination node

            // If the new distance is less than the current distance to the destination node, update the previous node, distance, and add the destination node to the priority queue
            if (newDist < distances[edge.node]) {
                prev[edge.node] = idx
                distances[edge.node] = newDist
                pq.enqueue(edge.node, newDist)
            }
        }
    }

    // Return the distances and previous nodes arrays in an object
    return { distances, prev }
}

// Finds the shortest path between the start and end nodes in the given graph using Dijkstra's algorithm
function findShortestPath(graph, n, start, end) {

    // check if start node is present in the graph, if not, throw error.
    if (!graph.hasOwnProperty(start)) {
        throw new Error(`Start node ${start} not found in graph`)
    }

    // check if end node is present in the graph, if not, throw error.
    if (!graph.hasOwnProperty(end)) {
        throw new Error(`End node ${end} not found in graph`)
    }

    const res = dijkstra(graph, n, start) // Run Dijkstra's algorithm to get the shortest distances and paths from the start node to all other nodes
    const distances = res.distances // Extract the distances array from the result of Dijkstra's algorithm
    const prev = res.prev // Extract the previous nodes array from the result of Dijkstra's algorithm
    const path = [] // Initialize an empty array to store the shortest path from the start to end node

    // If the end node is not reachable from the start node, return an empty path
    if (distances[parseInt(end)] == Number.POSITIVE_INFINITY) return path

    // Traverse the previous nodes array backwards from the end node to the start node to construct the shortest path
    for (let i = end; i !== null; i = prev[i]) path.unshift(i)

    // Return the shortest path
    return path
}

// Sample Use Case
// The graph will be represented in form of an adjacency list.
/* 
    The graph will be in form of an object where each key represents the nodes and each value will be an array of the neighbors of the node.

    The array in values will be an object array, where each object has the node, which is the neighbor, and weight, which is the distance to that neighbor from the current node.
*/
const graph = {
    0: [{ node: 1, weight: 10 }],
    1: [
        { node: 0, weight: 10 },
        { node: 2, weight: 10 },
        { node: 3, weight: 5 },
    ],
    2: [{ node: 1, weight: 10 }],
    3: [
        { node: 1, weight: 5 },
        { node: 4, weight: 10 },
        { node: 5, weight: 10 },
    ],
    4: [
        { node: 3, weight: 10 },
        { node: 5, weight: 10 },
    ],
    5: [
        { node: 3, weight: 10 },
        { node: 4, weight: 10 },
    ],
}

console.log(findShortestPath(graph, 6, 2, 5))
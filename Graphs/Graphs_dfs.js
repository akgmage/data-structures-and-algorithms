// Takes in a graph object and a starting node
function dfs(graph, startNode) {
    // Initialize an empty visited object
    const visited = {}

    // Call the dfsHelper function with the starting node, the visited object, and the graph object
    dfsHelper(startNode, visited, graph)
}

// Recursive helper function for the DFS algorithm
// Takes in a current node, a visited object, and a graph object
function dfsHelper(node, visited, graph) {
    // Mark the current node as visited by adding it to the visited object
    visited[node] = true

    // Print the current node (or perform some other action)
    console.log(node)

    // Get the adjacent nodes of the current node from the graph object
    const adjacentNodes = graph[node]

    // Iterate over the adjacent nodes
    for (let i = 0; i < adjacentNodes.length; i++) {
        // Get the node of the current adjacent node
        const adjacentNode = adjacentNodes[i].node

        // If the adjacent node has not been visited yet, recursively call dfsHelper with the adjacent node
        if (!visited[adjacentNode]) {
            dfsHelper(adjacentNode, visited, graph)
        }
    }
}

// SAMPLE USE CASE
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

dfs(graph, 0)
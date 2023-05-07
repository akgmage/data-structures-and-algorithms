// Define a function that takes a graph and a starting node as input
function bfs(graph, startNode) {
    // Initialize an empty object to keep track of visited nodes
    const visited = {}
    // Initialize a queue with the starting node
    const queue = [startNode]
  
    // Mark the starting node as visited
    visited[startNode] = true
  
    // While there are nodes in the queue
    while (queue.length > 0) {
      // Get the next node from the front of the queue
      const currentNode = queue.shift()
      // Log the current node to the console (or do something else with it)
      console.log(currentNode)
  
      // Get the adjacent nodes of the current node from the graph
      const adjacentNodes = graph[currentNode]
  
      // For each adjacent node
      for (let i = 0; i < adjacentNodes.length; i++) {
        // Get the adjacent node
        const adjacentNode = adjacentNodes[i].node
  
        // If the adjacent node has not been visited
        if (!visited[adjacentNode]) {
          // Mark the adjacent node as visited
          visited[adjacentNode] = true
          // Add the adjacent node to the back of the queue
          queue.push(adjacentNode)
        }
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

bfs(graph, 2)
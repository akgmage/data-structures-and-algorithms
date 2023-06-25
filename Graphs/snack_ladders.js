// Define the number of squares on the board

const BOARD_SIZE = 100;

// Define the start and end points of the snakes and ladders

const snakesAndLadders = {

  14: 4, 19: 8, 22: 20, 41: 38, 50: 39, 54: 34, 66: 53, 68: 63, 79: 67, 83: 72,

  92: 88, 97: 76, 8: 15, 13: 23, 37: 43, 40: 48, 57: 63, 61: 69, 65: 72, 75: 83,

  78: 87, 80: 92, 88: 94

};

// Define a function to build the game graph

function buildGraph() {

  const graph = {};

  for (let i = 1; i <= BOARD_SIZE; i++) {

    graph[i] = [];

    for (let j = i + 1; j <= i + 6 && j <= BOARD_SIZE; j++) {

      if (snakesAndLadders[j]) {

        graph[i].push(snakesAndLadders[j]);

      } else {

        graph[i].push(j);

      }

    }

  }

  return graph;

}

// Define the main function of the game

function playGame() {

  // Build the game graph

  const graph = buildGraph();

  // Define the starting node and the goal node

  const startNode = 1;

  const goalNode = BOARD_SIZE;

  // Define a queue for BFS

  const queue = [startNode];

  // Define a visited set for BFS

  const visited = new Set();

  visited.add(startNode);

  // Define a map for BFS to keep track of the parent node

  const parentMap = new Map();

  parentMap.set(startNode, null);

  // Loop until the goal node is found or the queue is empty

  while (queue.length > 0) {

    // Dequeue the next node from the queue

    const currentNode = queue.shift();

    // If the goal node is found, reconstruct the path and return it

    if (currentNode === goalNode) {

      const path = [];

      let node = currentNode;

      while (node !== null) {

        path.unshift(node);

        node = parentMap.get(node);

      }

      return path;

    }

    // Loop through the neighbors of the current node

    for (const neighbor of graph[currentNode]) {

      // If the neighbor has not been visited, add it to the queue

      if (!visited.has(neighbor)) {

        queue.push(neighbor);

        visited.add(neighbor);

        parentMap.set(neighbor, currentNode);

      }

    }

  }

  // If the goal node is not found, return null

  return null;

}

// Play the game and print the result

console.log(playGame());

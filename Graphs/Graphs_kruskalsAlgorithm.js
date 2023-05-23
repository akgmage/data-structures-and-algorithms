/**
 * Graphs: Implement Kruskal's Algorithm in JavaScript
 *
 * This code implements Kruskal's Algorithm to find the Minimum Spanning Tree (MST)
 * in a graph. The graph is represented using an adjacency list. The algorithm works
 * by repeatedly adding the minimum weight edges that do not form a cycle in the MST.
 *
 * Time Complexity: O(E log V), where E is the number of edges and V is the number of vertices.
 * Space Complexity: O(V), where V is the number of vertices.
 */

/**
 * Class representing a Disjoint Set data structure.
 * Used to track disjoint sets and perform union-find operations.
 */
class DisjointSet {
  constructor(n) {
    this.parent = new Array(n).fill(-1); // Array to store parent of each node
    this.rank = new Array(n).fill(0); // Array to store the rank of each node
  }

  /**
   * Find the parent of a node in the disjoint set.
   * Implements path compression to optimize future finds.
   * @param {number} x - The node to find the parent for.
   * @returns {number} The parent of the given node.
   */
  find(x) {
    if (this.parent[x] === -1) {
      return x;
    }
    this.parent[x] = this.find(this.parent[x]); // Path compression
    return this.parent[x];
  }

  /**
   * Union two disjoint sets by rank.
   * Uses union by rank to optimize the merge operation.
   * @param {number} x - The first node to union.
   * @param {number} y - The second node to union.
   */
  union(x, y) {
    let xRoot = this.find(x);
    let yRoot = this.find(y);

    if (this.rank[xRoot] < this.rank[yRoot]) {
      this.parent[xRoot] = yRoot;
    } else if (this.rank[xRoot] > this.rank[yRoot]) {
      this.parent[yRoot] = xRoot;
    } else {
      this.parent[yRoot] = xRoot;
      this.rank[xRoot]++;
    }
  }
}

/**
 * Function to implement Kruskal's Algorithm for finding the Minimum Spanning Tree (MST).
 * @param {number} n - The number of vertices in the graph.
 * @param {Array} edges - The edges of the graph represented as an adjacency list.
 * @returns {Array} The edges of the Minimum Spanning Tree.
 */
function kruskalsAlgorithm(n, edges) {
  // Sort edges in non-decreasing order by weight
  edges.sort((a, b) => a[2] - b[2]);

  const mst = []; // Minimum Spanning Tree
  const disjointSet = new DisjointSet(n); // Create a disjoint set for tracking sets

  for (let [src, dest, weight] of edges) {
    let srcRoot = disjointSet.find(src);
    let destRoot = disjointSet.find(dest);

    // If adding the edge does not create a cycle, add it to the MST
    if (srcRoot !== destRoot) {
      mst.push([src, dest, weight]);
      disjointSet.union(srcRoot, destRoot);
    }
  }

  return mst;
}

// Example usage
const numVertices = 5;
const graphEdges = [
  [0, 1, 2],
  [1, 2, 3],
  [0, 3, 6],
  [1, 3, 8],
  [1, 4, 5],
  [2, 4, 7],
  [3, 4, 9],
];

const minimumSpanningTree = kruskalsAlgorithm(numVertices, graphEdges);
console.log("Minimum Spanning Tree:", minimumSpanningTree);

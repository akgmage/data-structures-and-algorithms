import java.util.*;

public class PrimMST {
    private int V; // Number of vertices in the graph

    public PrimMST(int v) {
        V = v;
    }

    /**
     * Finds the minimum key value among the vertices not yet included in the MST.
     *
     * @param key     array representing the key values
     * @param mstSet  array representing whether a vertex is included in the MST
     * @return        the vertex with the minimum key value
     */
    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    /**
     * Prints the constructed minimum spanning tree (MST) represented by the parent array.
     *
     * @param parent  array representing the parent vertices in the MST
     * @param graph   2D array representing the adjacency matrix of the graph
     */
    private void printMST(int[] parent, int[][] graph) {
        System.out.println("Minimum Spanning Tree:");
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    /**
     * Applies Prim's algorithm to find the minimum spanning tree (MST) of the given graph.
     *
     * @param graph  2D array representing the adjacency matrix of the graph
     */
    public void primMST(int[][] graph) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        PrimMST mst = new PrimMST(V);
        mst.primMST(graph);
    }
}

// Problem: Minimum Spanning Tree (Prim's Algorithm)
// Given an undirected, weighted graph, find the minimum spanning tree using Prim's algorithm.

// Sample Input:
//     0    2    0    6    0
//     2    0    3    8    5
//     0    3    0    0    7
//     6    8    0    0    9
//     0    5    7    9    0
//
// Sample Output (Minimum Spanning Tree):
// Edge   Weight
// 0 - 1  2
// 1 - 2  3
// 0 - 3  6
// 1 - 4  5
//
// Approach:
// 1. Initialize key values of all vertices to infinity and set the key value of the first vertex as 0.
// 2. While there are vertices not included in the MST, do the following:
//    a. Select the vertex with the minimum key value among the vertices not yet included in the MST.
//    b. Include the selected vertex in the MST.
//    c. Update the key values of adjacent vertices if they are greater than the weight of the edge connecting them.
// 3. The parent array represents the constructed MST. Print the edges and their weights.
//
// Time Complexity: O(V^2) where V is the number of vertices in the graph.
// Space Complexity: O(V)
//

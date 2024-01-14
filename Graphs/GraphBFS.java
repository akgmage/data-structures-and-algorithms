/**
 * The GraphBFS class represents a simple undirected graph using an adjacency list
 * and provides a breadth-first search (BFS) algorithm to traverse the graph.
 */
import java.util.*;
import java.io.*;

class GraphBFS {
    private int V; // Number of vertices in the graph
    private List<Integer> adjacency[]; // Adjacency list to represent the graph

    // Constructor to initialize the graph with the given number of vertices
    GraphBFS(int v) {
        V = v;
        adjacency = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adjacency[i] = new ArrayList<Integer>();
        }
    }

    // Method to add an edge between vertices 'u' and 'v' in the graph
    void addEdge(int u, int v) {
        adjacency[u].add(v);
        adjacency[v].add(u);
    }

    /**
     * Performs breadth-first search (BFS) starting from the given source vertex 's'.
     * Prints the vertices in BFS order.
     * @param s The source vertex from which BFS starts.
     */
    void bfs(int s) {
        boolean[] visited = new boolean[V]; // Array to track visited vertices
        visited[s] = true; // Mark the source vertex as visited
        LinkedList<Integer> Q = new LinkedList<Integer>(); // Queue for BFS traversal
        Q.add(s); // Enqueue the source vertex

        // BFS traversal
        while(Q.size() != 0) {
            int current = Q.poll(); // Dequeue the current vertex
            System.out.print(current + " -> "); // Print the current vertex

            // Visit all neighbors of the current vertex
            for(int neighbour: adjacency[current]) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true; // Mark the neighbour as visited
                    Q.add(neighbour); // Enqueue the neighbour for further exploration
                }
            }
        }
    }

    // Main method for testing the GraphBFS class
    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(5); // Create a graph with 5 vertices
        g.addEdge(2, 3); // Add edges to the graph
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(4, 1);

        g.bfs(2); // Perform BFS starting from vertex 2
    }
}

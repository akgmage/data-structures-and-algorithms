import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph {
    private int V; // Number of vertices
    private int[][] adjacencyMatrix; // Adjacency matrix representation of the graph

    public Graph(int v) {
        V = v;
        adjacencyMatrix = new int[V][V];
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = 1;
        adjacencyMatrix[dest][src] = 1;
    }

    // Breadth-First Search traversal
    public boolean BFS(int startVertex, int searchElement) {
        boolean[] visited = new boolean[V]; // Array to track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal

        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            // Check if the current vertex matches the search element
            if (currentVertex == searchElement) {
                return true;
            }
            // Visit all adjacent vertices of the current vertex
            for (int i = 0; i < V; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a graph with 7 vertices
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.print("Enter the element to search: ");  // asking the user for which element to search 
        int searchElement = scanner.nextInt();

        System.out.println("Performing BFS...");
        boolean elementFound = graph.BFS(0, searchElement);

        if (elementFound) {
            System.out.println("Element " + searchElement + " found!");
        } else {
            System.out.println("Element " + searchElement + " not found!");
        }
    }
}

/*Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem :  Implement Depth First Search in Java
Issue Number : #733
Problem statement : 

Explanation of the below Java code :

In this example, we have a Node class representing each node in the graph. Each Node has a value, a list of neighbors, and a boolean flag to track if it has been visited.

The DepthFirstSearch class contains the dfs method, which performs the depth-first search traversal. It takes a starting node as an argument and recursively visits all unvisited neighbors of that node. When visiting a node, it marks it as visited and prints its value.

In the main method, we create a small graph with five nodes and test the dfs method by starting the traversal from the first node (node1). The output will display the visited nodes in the order they are traversed:


*/

-------------------------------------------------------------------------//Java code begins here------------------------------------------------------------------------


import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    List<Node> neighbors;
    boolean visited;

    Node(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
        this.visited = false;
    }

    void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }
}

class DepthFirstSearch {
    void dfs(Node startNode) {
        // Mark the startNode as visited
        startNode.visited = true;
        System.out.println("Visited Node: " + startNode.value);

        // Recursively visit all unvisited neighbors
        for (Node neighbor : startNode.neighbors) {
            if (!neighbor.visited) {
                dfs(neighbor);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a graph for testing
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.addNeighbor(node2);
        node1.addNeighbor(node3);
        node2.addNeighbor(node4);
        node3.addNeighbor(node4);
        node4.addNeighbor(node5);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.dfs(node1);
    }
}

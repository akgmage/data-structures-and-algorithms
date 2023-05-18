import java.util.*;

class Main {
    // Represents a node in the graph
    static class Node implements Comparable<Node> {
        String name;
        int distance;

        Node(String name) {
            this.name = name;
            this.distance = Integer.MAX_VALUE; // Initialize distance to infinity
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Represents a weighted edge between two nodes
    static class Edge {
        Node source;
        Node destination;
        int weight;

        Edge(Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Dijkstra's algorithm implementation
    static void dijkstra(Map<String, List<Edge>> graph, String start) {
        Map<String, Node> nodes = new HashMap<>(); // Stores nodes and their distances

        // Initialize nodes with their respective distances
        for (String nodeName : graph.keySet()) {
            Node node = new Node(nodeName);
            if (nodeName.equals(start)) {
                node.distance = 0; // Set distance of start node to 0
            }
            nodes.put(nodeName, node);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(); // Priority queue for node selection
        queue.add(nodes.get(start)); // Add the start node to the queue

        // Dijkstra's algorithm main loop
        while (!queue.isEmpty()) {
            Node current = queue.poll(); // Get the node with the smallest distance from the queue

            // Iterate over the edges of the current node
            for (Edge edge : graph.get(current.name)) {
                int newDistance = current.distance + edge.weight; // Calculate new distance to the neighbor node
                Node neighbor = nodes.get(edge.destination.name); // Get the neighbor node

                // If the new distance is shorter, update the neighbor node's distance and re-add it to the queue
                if (newDistance < neighbor.distance) {
                    queue.remove(neighbor); // Remove the neighbor node from the queue
                    neighbor.distance = newDistance; // Update the distance of the neighbor node
                    queue.add(neighbor); // Re-add the neighbor node to the queue
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>(); // Graph represented as a map of nodes and edges

        // Create edges and add them to the graph
        List<Edge> edgesA = new ArrayList<>();
        edgesA.add(new Edge(new Node("A"), new Node("B"), 2));
        edgesA.add(new Edge(new Node("A"), new Node("C"), 3));
        graph.put("A", edgesA);

        List<Edge> edgesB = new ArrayList<>();
        edgesB.add(new Edge(new Node("B"), new Node("C"), 1));
        edgesB.add(new Edge(new Node("B"), new Node("D"), 1));
        graph.put("B", edgesB);

        List<Edge> edgesC = new ArrayList<>();
        edgesC.add(new Edge(new Node("C"), new Node("D"), 4));
        graph.put("C", edgesC);

        List<Edge> edgesD = new ArrayList<>();
        edgesD.add(new Edge(new Node("D"), new Node("C"), 2));
        graph.put("D", edgesD);

        String start = "A"; // Starting node
        dijkstra(graph, start); // Run Dijkstra's algorithm

        // Print the shortest distances from the start node to each node in the graph
        for (String nodeName : graph.keySet()) {
            Node node = graph.get(nodeName).get(0).source;
            System.out.println("Shortest distance from " + start + " to " + node.name + ": " + node.distance);
        }
    }
}


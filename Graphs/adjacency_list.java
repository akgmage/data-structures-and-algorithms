/*
    This code is an implementation of a graph data structure using an adjacency list representation in Java. Let's break down the code and explain it step by step:

    1. `GraphNode` Class:
    - This class represents a node in the graph.
    - It has three attributes:
        - `name`: A string that represents the name or label of the node.
        - `index`: An integer that serves as a unique identifier/index for the node.
        - `neighbors`: An ArrayList of `GraphNode` objects that stores the neighboring nodes of the current node.

    2. `AdjacencyList` Class:
    - This class represents the graph using an adjacency list.
    - It has the following attributes:
        - `nodeList`: An ArrayList of `GraphNode` objects that stores all the nodes in the graph.
    - The constructor takes an ArrayList of `GraphNode` objects and initializes the `nodeList` attribute with it.
    - The class provides the following methods:
        - `addUndirectedEdge(int i, int j)`: This method takes two indices (`i` and `j`) representing two nodes in the graph and 
        adds an undirected edge between them. It does so by retrieving the corresponding `GraphNode` objects from the `nodeList` 
        and adding each node to the `neighbors` list of the other.
        - `printGraph()`: This method returns a human-readable representation of the graph. It iterates through the `nodeList`, 
        prints the name of each node, and lists its neighboring nodes.

    3. `main` Class:
    - This is the main class to demonstrate the graph creation and printing.
    - Inside the `main` method:
        - An ArrayList of `GraphNode` objects (`nodeList`) is created, and five nodes are added to it, each with a name and index.
        - An `AdjacencyList` object (`al`) is created, passing the `nodeList` to its constructor.
        - Several undirected edges are added using the `addUndirectedEdge` method to establish connections between nodes.
        - Finally, the `printGraph` method is called on the `al` object to print the graph's structure.

    The code demonstrates how to create a graph using an adjacency list and provides a readable representation of the graph, including its nodes and edges.
*/


import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    // An ArrayList to store neighboring nodes
    public ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

public class AdjacencyList {
    // An ArrayList to store all nodes in the graph
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public AdjacencyList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    // Method to add an undirected edge between two nodes
    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    // Method to print a human-readable representation of the graph
    public String printGraph() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size() - 1) {
                    s.append(nodeList.get(i).neighbors.get(j).name);
                } else {
                    s.append(nodeList.get(i).neighbors.get(j).name + " --> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        AdjacencyList al = new AdjacencyList(nodeList);
        al.addUndirectedEdge(0, 1);
        al.addUndirectedEdge(0, 2);
        al.addUndirectedEdge(0, 3);
        al.addUndirectedEdge(1, 4);
        al.addUndirectedEdge(2, 3);
        al.addUndirectedEdge(3, 4);
        System.out.println(al.printGraph());
    }
}

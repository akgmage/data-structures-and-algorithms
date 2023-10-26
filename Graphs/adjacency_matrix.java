/*
    This code snippet is a Java implementation of a graph using an adjacency matrix to represent the connections between nodes. Here's an explanation of the code:

    1. `GraphNode` Class:
    - `GraphNode` represents a node or vertex in the graph.
    - It has two attributes: `name` to store the name of the node and `index` to store the index of the node.
    - The constructor initializes these attributes.

    2. `AdjacencyMatrix` Class:
    - `AdjacencyMatrix` represents the graph using an adjacency matrix.
    - It has the following attributes:
        - `nodeList`: An `ArrayList` that stores all the nodes in the graph.
        - `adjacencyMatrix`: A 2D array that represents the connections between nodes.
    - The constructor takes an `ArrayList` of `GraphNode` objects and initializes the `nodeList` and `adjacencyMatrix` based on the size of the node list.

    3. `addUndirectedEdge` Method:
    - This method is used to add an undirected edge between two nodes.
    - It takes two indices `i` and `j` to represent the nodes between which the edge is added.
    - It sets the corresponding values in the adjacency matrix to 1, indicating an edge exists between nodes `i` and `j`. Since it's an undirected graph, it sets both `adjacencyMatrix[i][j]` and `adjacencyMatrix[j][i]` to 1.

    4. `printGraph` Method:
    - This method generates a human-readable string representation of the graph, including the adjacency matrix.
    - It first prints the node names as column headers and then iterates through the adjacency matrix to display the connections between nodes.

    5. `Main` Class:
    - In the `Main` class, a list of `GraphNode` objects (`nodeList`) is created, each representing a node with a name and an index.
    - An `AdjacencyMatrix` object (`am`) is created, passing the `nodeList` to its constructor.
    - Undirected edges are added between nodes using the `addUndirectedEdge` method.
    - Finally, the graph is printed using the `printGraph` method.

    The example in the `main` method demonstrates the creation of a simple graph with five nodes and several edges. When you run this program, it will print a representation of the graph showing the connections between the nodes based on the adjacency matrix.

    Output:
    A B C D E 
    A: 0 1 1 1 0 
    B: 1 0 0 0 1 
    C: 1 0 0 1 0 
    D: 1 0 1 0 1 
    E: 0 1 0 1 0 

*/
import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

public class AdjacencyMatrix {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;
    public AdjacencyMatrix(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }
    public String printGraph() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
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
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        AdjacencyMatrix am = new AdjacencyMatrix(nodeList);
        am.addUndirectedEdge(0, 1); // A-B
        am.addUndirectedEdge(0, 2); // A-C
        am.addUndirectedEdge(0, 3); // A-D
        am.addUndirectedEdge(1, 4); // B-E
        am.addUndirectedEdge(2, 3); // C-D
        am.addUndirectedEdge(3, 4); // D-E
        System.out.println(am.printGraph());
    }
}
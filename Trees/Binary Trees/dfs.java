// Implementation of Depth First Search
/*
	This code demonstrates a basic implementation of Depth-First Search (DFS) on a graph represented by nodes.
	It uses a recursive approach to traverse the graph in a depth-first manner, printing the values of the visited nodes.
	The algorithm maintains a set of visited nodes to avoid visiting the same node multiple times.
	The DFS function serves as the entry point to start the DFS traversal, and the dfsHelper
	function recursively visits each node and its children.
	Sample Input :
	//          1
	//        /   \
	//       2     3
	//      / \   / \
	//     4   5 6   7
	Output : 1 2 4 5 3 6 7

	The time complexity of Depth-First Search (DFS) on a graph is O(V + E), where V represents the number of vertices (nodes)
	in the graph and E represents the number of edges. In the worst case, DFS may visit all vertices and edges of the graph.

	The space complexity of DFS is determined by the maximum depth of the recursion stack. In the case of a tree-like
	structure, where each node has only one child, the maximum depth is equal to the height of the tree.
	Therefore, the space complexity of DFS on such a tree-like structure is O(H), where H represents the height of the tree.
	In the worst case, where the graph is a linear structure, the height of the tree is equal to the number of vertices,
	so the space complexity becomes O(V).
*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Node represents a node in a graph.
class Node {
    int value;
    List<Node> children;

    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}

// DFS traverses the graph using Depth-First Search starting from the given node.
class DepthFirstSearch {
    public static void DFS(Node node) {
        // Create a set to keep track of visited nodes.
        Set<Node> visited = new HashSet<>();

        // Call the recursive helper function to perform DFS.
        dfsHelper(node, visited);
    }

    // dfsHelper is a recursive function that performs Depth-First Search on the graph.
    private static void dfsHelper(Node node, Set<Node> visited) {
        // Mark the current node as visited.
        visited.add(node);

        // Process the current node (print its value in this case).
        System.out.println(node.value);

        // Traverse the children of the current node.
        for (Node child : node.children) {
            // If the child node has not been visited, recursively call dfsHelper on it.
            if (!visited.contains(child)) {
                dfsHelper(child, visited);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample graph.
        //          1
        //        /   \
        //       2     3
        //      / \   / \
        //     4   5 6   7
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.children.add(node2);
        node1.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);
        node3.children.add(node6);
        node3.children.add(node7);

        // Perform DFS starting from node1.
        System.out.println("Depth-First Search:");
        DepthFirstSearch.DFS(node1);
    }
}

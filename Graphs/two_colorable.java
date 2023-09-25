/*
	You're given a list of edges  representing a connected, unweighted, undirected graph with at least one node.
	Write a function that returns a boolean representing whether the given graph is two-colorable.

	Explanation:
	The code snippet implements an algorithm to determine if a given graph is two-colorable or bipartite. A graph is two-colorable if its vertices can be divided into two groups such that no two adjacent vertices have the same color.

	The function `TwoColorable(edges [][]int) bool` takes a 2D array of integers `edges`, representing the edges of the graph. Each row `edges[i]` contains the list of vertices that are connected to vertex `i`.

	The algorithm uses a stack and a map to keep track of the colors assigned to the vertices. It starts by assigning the first vertex (vertex 0) to color true and pushing it onto the stack.

	Then, it performs a depth-first traversal of the graph using the stack. For each vertex popped from the stack, it explores its adjacent vertices. If an adjacent vertex has not been colored yet (not present in the colors map), it assigns the opposite color to it (i.e., `!colors[node]`) and pushes it onto the stack. If the adjacent vertex has already been colored and its color is the same as the current vertex's color, then the graph cannot be two-colorable, and the function returns false.

	If the traversal completes without any conflicts (i.e., no adjacent vertices have the same color), the function returns true, indicating that the graph is two-colorable.

	The algorithm relies on the fact that a graph is two-colorable if and only if it is bipartite, and the two colors represent the two disjoint sets of vertices in the bipartite graph.

	Here's a step-by-step explanation of the algorithm:

	1. Initialize the `colors` map with the first vertex (0) assigned the color true (representing one group of vertices).
	2. Initialize an empty stack and push the first vertex (0) onto it.
	3. While the stack is not empty, repeat the following steps:
	a. Pop the top vertex from the stack (denoted by `node`).
	b. For each vertex `connection` connected to `node` (i.e., `edges[node]`), do the following:
		i. If `connection` has not been colored yet (not present in the `colors` map), assign it the opposite color of
		`node` (i.e., `!colors[node]`) and push it onto the stack.
		ii. If `connection` has already been colored and its color is the same as `node`'s color, return false since the
		graph is not two-colorable.
	4. If the traversal completes without conflicts, return true, indicating that the graph is two-colorable.

	Note: The algorithm assumes that the graph is connected, meaning there is a path from any vertex to any other vertex.
	If the graph is not connected, the algorithm will only determine whether the connected component containing vertex 0 is two-colorable.

	O(v + e) time | O(v) space - where v is the number of vertices and e is the number of edges in the graph

*/
import java.util.*;

public class TwoColorable {

    public static boolean isTwoColorable(List<List<Integer>> edges) {
        // colors keeps track of the colors assigned to each vertex.
        // We start by assigning the first vertex (0) the color true (denoted by 0: true).
        Map<Integer, Boolean> colors = new HashMap<>();
        colors.put(0, true);

        // stack is used for depth-first traversal of the graph.
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            // Pop the top vertex from the stack (denoted by 'node').
            int node = stack.pop();

            // Explore adjacent vertices (connections) of the current vertex 'node'.
            for (int connection : edges.get(node)) {
                // If the adjacent vertex has not been colored yet (not present in the 'colors' map),
                // assign it the opposite color of the current vertex (denoted by '!colors.get(node)'),
                // and push it onto the stack.
                if (!colors.containsKey(connection)) {
                    colors.put(connection, !colors.get(node));
                    stack.push(connection);
                } else {
                    // If the adjacent vertex has already been colored and its color is the same as the current vertex's color,
                    // then the graph cannot be two-colorable, return false.
                    if (colors.get(connection) == colors.get(node)) {
                        return false;
                    }
                }
            }
        }

        // If the traversal completes without any conflicts (no adjacent vertices have the same color),
        // return true, indicating that the graph is two-colorable.
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(0, 3));
        edges.add(Arrays.asList(0, 4));
        edges.add(Arrays.asList(1));
        edges.add(Arrays.asList(2));

        boolean isTwoColorable = isTwoColorable(edges);
        System.out.println("Is Two-Colorable: " + isTwoColorable);
    }
}

The Ford-Fulkerson algorithm is a graph algorithm used to find the maximum flow in a flow network. 
Here is a high-level overview of the algorithm and some resources for further documentation:

Ford-Fulkerson Algorithm Overview:

Start with an initial flow of zero.
While there exists an augmenting path from the source to the sink:
Find the residual capacity of the augmenting path (minimum capacity edge along the path).
Update the flow by increasing the flow along the augmenting path.
Update the residual capacities of the edges.
The maximum flow is the sum of the flows along the augmenting paths.

Here's an example of the Ford-Fulkerson algorithm implemented in C++:

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

// Number of vertices in the graph
#define V 6

// A BFS based function to check whether there is an augmenting path
// from source to sink. Returns true if there is an augmenting path,
// else returns false
bool bfs(int rGraph[V][V], int s, int t, int parent[])
{
    // Create a visited array and mark all vertices as not visited
    bool visited[V];
    memset(visited, 0, sizeof(visited));

    // Create a queue, enqueue source vertex and mark source vertex
    // as visited
    queue<int> q;
    q.push(s);
    visited[s] = true;
    parent[s] = -1;

    // Standard BFS Loop
    while (!q.empty()) {
        int u = q.front();
        q.pop();

        for (int v = 0; v < V; v++) {
            if (visited[v] == false && rGraph[u][v] > 0) {
                q.push(v);
                parent[v] = u;
                visited[v] = true;
            }
        }
    }

    // If we reached the sink in BFS starting from source, then return
    // true, else false
    return (visited[t] == true);
}

// A function to implement the Ford-Fulkerson algorithm
// This will find the maximum possible flow from the source to the sink
int fordFulkerson(int graph[V][V], int s, int t)
{
    int u, v;

    // Create a residual graph and fill the residual graph with
    // given capacities in the original graph as residual capacities
    // in residual graph
    int rGraph[V][V]; // Residual graph where rGraph[i][j] indicates
                      // residual capacity of edge from i to j (if there
                      // is an edge. If rGraph[i][j] is 0, then there is not)
    for (u = 0; u < V; u++)
        for (v = 0; v < V; v++)
            rGraph[u][v] = graph[u][v];

    int parent[V]; // This array is filled by BFS and to store path

    int maxFlow = 0; // There is no flow initially

    // Augument the flow while there is path from source to sink
    while (bfs(rGraph, s, t, parent)) {
        // Find minimum residual capacity of the edges along the
        // path filled by BFS. Or we can say find the maximum flow
        // through the path found.
        int pathFlow = INT_MAX;
        for (v = t; v != s; v = parent[v]) {
            u = parent[v];
            pathFlow = min(pathFlow, rGraph[u][v]);
        }

        // Update residual capacities of the edges and reverse edges
        // along the path
        for (v = t; v != s; v = parent[v]) {
            u = parent[v];
            rGraph[u][v] -= pathFlow;
            rGraph[v][u] += pathFlow;
        }

        // Add path flow to overall flow
        maxFlow += pathFlow;
    }

    // Return the overall flow as the maximum flow
    return maxFlow;
}
// Driver program to test above functions
int main()
{
    // Let us create a graph shown in the above example
    int graph[V][V] = { { 0, 16, 13, 0, 0, 0 },
                        { 0, 0, 10, 12, 0, 0 },
                        { 0, 4, 0, 0, 14, 0 },
                        { 0, 0, 9, 0, 0, 20 },
                        { 0, 0, 0, 7, 0, 4 },
                        { 0, 0, 0, 0, 0, 0 } };

    int source = 0;
    int sink = 5;

    cout << "The maximum possible flow is: " << fordFulkerson(graph, source, sink) << endl;

    return 0;
}

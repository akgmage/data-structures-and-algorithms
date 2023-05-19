/*Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem :  Implement Dijkstra's algorithm in C++ 
Issue Number : #947
Problem statement : 

Explanation of the below C++ code :

In this implementation, we have a dijkstra function that takes a graph represented as an adjacency list, the starting node, and the total number of nodes. It returns a vector containing the shortest distances from the start node to all other nodes.

The dijkstra function initializes all distances to infinity except for the start node, which is set to 0. It uses a min heap priority queue to process nodes based on their distances. The algorithm iteratively selects the node with the minimum distance, updates the distances of its neighbors if a shorter path is found, and adds them to the priority queue.

In the main function, we create a graph using the adjacency list representation. Each element of the graph vector is a vector of pairs, where the first element of the pair represents the neighbor node, and the second element represents the weight of the edge.

We then call the dijkstra function with the graph, starting node, and the total number of nodes. Finally, we print the shortest distances from the start node to all other nodes.


*/

-------------------------------------------------------------------------//C++ code begins here------------------------------------------------------------------------


#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

typedef pair<int, int> pii;

vector<int> dijkstra(vector<vector<pii>>& graph, int start, int n) {
    vector<int> dist(n, INT_MAX); // Initialize distances to infinity
    dist[start] = 0; // Distance from start node to itself is 0

    // Create a min heap priority queue to store vertices based on their distances
    priority_queue<pii, vector<pii>, greater<pii>> pq;
    pq.push(make_pair(0, start));

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        // Traverse all neighboring nodes of u
        for (auto& neighbor : graph[u]) {
            int v = neighbor.first;
            int weight = neighbor.second;

            // Update distance if a shorter path is found
            if (dist[v] > dist[u] + weight) {
                dist[v] = dist[u] + weight;
                pq.push(make_pair(dist[v], v));
            }
        }
    }

    return dist;
}

int main() {
    int n, m; // Number of nodes and edges
    int start; // Starting node

    cout << "Enter the number of nodes: ";
    cin >> n;

    cout << "Enter the number of edges: ";
    cin >> m;

    cout << "Enter the starting node: ";
    cin >> start;

    // Create an adjacency list representation of the graph
    vector<vector<pii>> graph(n);

    cout << "Enter the edges and their weights (node1 node2 weight):" << endl;
    for (int i = 0; i < m; i++) {
        int node1, node2, weight;
        cin >> node1 >> node2 >> weight;
        graph[node1].push_back(make_pair(node2, weight));
    }

    // Run Dijkstra's algorithm
    vector<int> distances = dijkstra(graph, start, n);

    // Print the shortest distances from the start node to all other nodes
    for (int i = 0; i < n; i++) {
        cout << "Shortest distance from node " << start << " to node " << i << ": " << distances[i] << endl;
    }

    return 0;
}

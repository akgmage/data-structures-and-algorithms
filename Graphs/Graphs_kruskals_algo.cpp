/*
Name : MAnmay Ghosh
Github username : ManmayGhosh
Repository name : data-structures-and-algorithms
Problem :  Implement Kruskal's algorithm in C++ 
Issue Number : #1301

Explanation of the below C++ code :

In this implementation, we have a dijkstra function that takes a graph represented as an adjacency list, the starting node, and the total number of nodes. It returns a vector containing the shortest distances from the start node to all other nodes.

The dijkstra function initializes all distances to infinity except for the start node, which is set to 0. It uses a min heap priority queue to process nodes based on their distances. The algorithm iteratively selects the node with the minimum distance, updates the distances of its neighbors if a shorter path is found, and adds them to the priority queue.

In the main function, we create a graph using the adjacency list representation. Each element of the graph vector is a vector of pairs, where the first element of the pair represents the neighbor node, and the second element represents the weight of the edge.

We then call the dijkstra function with the graph, starting node, and the total number of nodes. Finally, we print the shortest distances from the start node to all other nodes.

-------------------------------------------------------------------------//C++ code begins here------------------------------------------------------------------------
*/

#include <bits/stdc++.h>
using namespace std;
 
// DS data structure
// path compression + rank by union
class D_S {
    int* parent;
    int* rank;
 
public:
    D_S(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            rank[i] = 1;
        }
    }
 
    // Find function
    int find(int i)
    {
        if (parent[i] == -1)
            return i;
        return parent[i] = find(parent[i]);
    }
 
    // Union function
    void unite(int x, int y)
    {
        int s1 = find(x);
        int s2 = find(y);
 
        if (s1 != s2) {
            if (rank[s1] < rank[s2])
                parent[s1] = s2;
            else if (rank[s1] > rank[s2])
                parent[s2] = s1;
            else {
                parent[s2] = s1;
                rank[s1] += 1;
            }
        }
    }
};
 
class Graph {
    vector<vector<int>> edgelist;
    int V;
 
public:
    Graph(int V) { this->V = V; }
 
    // Function to add edge in a graph
    void addEdge(int x, int y, int w)
    {
        edgelist.push_back({ w, x, y });
    }
 
    void kruskals_mst()
    {
        // Arrange all edges in ascending order to find minimum weight edge
        sort(edgelist.begin(), edgelist.end());
 
        // Initialize the DSU
        D_S gr(V);
        int ans = 0;
        cout << "Following are the edges in the constructed MST"<< endl;
        for (auto edge : edgelist) {
            int w = edge[0];
            int x = edge[1];
            int y = edge[2];
 
            // Take the edge in MST if it does not forms a cycle
            if (gr.find(x) != gr.find(y)) {
                gr.unite(x, y);
                ans += w;
                cout << x << " -- " << y << " == " << w<< endl;
            }
        }
        cout << "Minimum Cost Spanning Tree: " << ans;
    }
};
 
// Driver code
int main()
{
    Graph g(4);
    g.addEdge(0, 1, 10);
    g.addEdge(1, 3, 15);
    g.addEdge(2, 3, 4);
    g.addEdge(2, 0, 6);
    g.addEdge(0, 3, 5);
 
    // Function call
    g.kruskals_mst();
 
    return 0;
}


/*
Time Complexity: O(E * logE) or O(E * logV) 

Sorting of edges takes O(E * logE) time. 
After sorting, we iterate through all edges and apply the find-union algorithm. The find and union operations can take at most O(logV) time.
So overall complexity is O(E * logE + E * logV) time. 
The value of E can be at most O(V2), so O(logV) and O(logE) are the same. Therefore, the overall time complexity is O(E * logE) or O(E*logV).
*/
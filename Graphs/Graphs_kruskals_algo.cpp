/*
Name : MAnmay Ghosh
Github username : ManmayGhosh
Repository name : data-structures-and-algorithms
Problem :  Implement Kruskal's algorithm in C++ 
Issue Number : #1301

Explanation of the below C++ code :

In this implementation, In Kruskal’s algorithm, sort all edges of the given graph in increasing order. 
Then it keeps on adding new edges and nodes in the MST if the newly added edge does not form a cycle. 
It picks the minimum weighted edge at first at the maximum weighted edge at last.
Thus we can say that it makes a locally optimal choice in each step in order to find the optimal solution

pseudosteps
1. Sort all the edges in non-decreasing order of their weight. 
2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. 
    If the cycle is not formed, include this edge. Else, discard it. 
3. Repeat step#2 until there are (V-1) edges in the spanning tree.
-------------------------------------------------------------------------//C++ code begins here------------------------------------------------------------------------
*/

#include <bits/stdc++.h>
using namespace std;
 
// DS data structure class will help in building graph 
class D_S {
    int* parent;                                        // to create a parent relationship b/w two nodes
    int* child;                                         // to create a child relationship b/w two nodes
public:

    //This function will create a user defined data structure which will help to create a graph
    D_S(int n)                                          
    {
        parent = new int[n];
        child = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            child[i] = 1;
        }
    }
 
    // Find function to find edges b/w vertices
    int find(int i)
    {
        if (parent[i] == -1)
            return i;
        return parent[i] = find(parent[i]);
    }
 
    // Union function to joint two nodes via smallest possible weighted edge
    void unite(int x, int y)
    {
        int s1 = find(x);
        int s2 = find(y);
 
        if (s1 != s2) {
            if (child[s1] < child[s2])
                parent[s1] = s2;
            else if (child[s1] > child[s2])
                parent[s2] = s1;
            else {
                parent[s2] = s1;
                child[s1] += 1;
            }
        }
    }
};
 
class Graph {
    //As we know for kruskal's algorithm we have to maintain a list for edges b/w two vertices 
    //from lowest weight to highest weight in increasing order
    vector<vector<int>> edgelist;
    int V;
 
public:
    Graph(int V) { this->V = V; }
 
    // Function to add edge in a graph
    void addEdge(int x, int y, int w)
    {
        edgelist.push_back({ w, x, y });
    }
 

    //Kruskal's Algorithm
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
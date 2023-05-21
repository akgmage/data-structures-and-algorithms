// Graphs Adjacency List implementation
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;

class Graph{
public:
    int V;
    list<int> *L; // a pointer to an array of linkedlist
    Graph(int v){
        V = v;
        L = new list<int>[V]; // Array of LL
        // there is a pointer to an array whose size is v and every object is list of integer
    }
    void addEdge(int u, int v, bool bidir = true){
        L[u].push_back(v);
        if(bidir){
            L[v].push_back(u);
        }
    }
    void printAdjacencyList(){
        for(int i = 0; i < V; i++){
            cout << i << "-> ";
            for(auto vertex : L[i]){
                cout << vertex << ", ";
            }
            cout << endl;
        }
    }
};
int main(){
    //graph has 5 vertices numbered from 0-4
    Graph g(5);
    g.addEdge(0, 1);
    g.addEdge(0, 4);
    g.addEdge(1, 4);
    g.addEdge(1, 3);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(4, 3);
    g.printAdjacencyList();
    return 0;
}
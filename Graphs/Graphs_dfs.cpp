// Graphs Adjacency List implementation for Generic Data
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;

template<typename T>
class Graph{
    map<T, list<T> > adjList;
    public:
        Graph(){

        }
        void addEdge(T u, T v, bool bidir = true){
            adjList[u].push_back(v);
            if(bidir){
                adjList[v].push_back(u);
            }
        }
        void printAdjList(){
            for(auto obj : adjList){
                cout << obj.first <<  "->";
                for(auto element : obj.second){
                    cout << element << ",";
                }
                cout << endl;
            }
        }
        void dfsHelper(int node, map<int, bool> &visited){
            visited[node] = true;
            cout << node << "->";
            for(int neighbour : adjList[node]){
                if(!visited[neighbour]){
                    dfsHelper(neighbour, visited);
                }
            }
        }
        void dfs(int src){
            map<int, bool> visited;
            dfsHelper(src, visited);
        }
};
int main(){
    Graph<int> g;
    g.addEdge(0, 1);
    g.addEdge(0, 4);
    g.addEdge(1, 4);
    g.addEdge(1, 3);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(4, 3);
    g.printAdjList();
    g.dfs(0);
    return 0;
}
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
        void dfsHelper(T node, map<T, bool> &visited){
            visited[node] = true;
            cout << node << "->";
            for(T neighbour : adjList[node]){
                if(!visited[neighbour]){
                    dfsHelper(neighbour, visited);
                }
            }
        }
        void dfs(T src){
            map<T, bool> visited;
            int component = 1;
            dfsHelper(src, visited);
            cout << endl;
            for(auto x : adjList){
                T city =  x.first;
                if(!visited[city]){
                    dfsHelper(city, visited);
                    component++;
                    cout << endl;
                }
            }
            cout << "Graph has " << component << " component." << endl;
        }
};
int main(){
    Graph<string> g;
    g.addEdge("Amritsar", "Jaipur");
    g.addEdge("Amritsar", "Delhi");
    g.addEdge("Delhi", "Jaipur");
    g.addEdge("Mumbai", "Jaipur");
    g.addEdge("Mumbai", "Bhopal");
    g.addEdge("Delhi", "Bhopal");
    g.addEdge("Mumbai", "Bangalore");
    g.addEdge("Agra", "Delhi");
    g.addEdge("Andaman", "Nicobar");
    g.addEdge("Nagaland", "Manipur");
    g.printAdjList();
    g.dfs("Amritsar");
    return 0;
}
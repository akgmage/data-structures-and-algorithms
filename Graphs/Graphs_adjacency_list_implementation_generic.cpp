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
};
int main(){
    Graph<string> g;
    g.addEdge("Ashish", "Asif", false);
    g.addEdge("Ashish", "Abhisek", false);
    g.addEdge("Ashish", "Amir", false);
    g.addEdge("Abhisek", "Asif", true);
    g.addEdge("Abhisek", "Anvesh", true);
    g.addEdge("Anvesh", "Sai", false);
    g.addEdge("Sai", "Abhisek", false);
    g.printAdjList();
    return 0;
}
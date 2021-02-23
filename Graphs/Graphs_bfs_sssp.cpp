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
        void bfs_sssp(int n){
            queue<int> q;
            map<int, int> distance;
            map<int, int> parent;
            for(auto i : adjList){
                distance[i.first] = INT_MAX;
            }
            q.push(n);
            distance[n] = 0;
            parent[n] = n;
            while(!q.empty()){
                int node_element = q.front();
                cout << node_element << " ";
                q.pop();
                for(int neighbour : adjList[node_element]){
                    if(distance[neighbour] == INT_MAX){
                        q.push(neighbour);
                        distance[neighbour] = distance[node_element] + 1;
                        parent[neighbour] = node_element;
                    }
                }
            }
            cout << endl;
            for(auto i : adjList){
                int node = i.first;
                cout << "Distance of " << node << " from " << n << " is " << distance[node] << endl;
            }
            for(auto x: parent){
                cout << x.first << " " << x.second << endl;
            }

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
    g.bfs_sssp(4);
    return 0;
}
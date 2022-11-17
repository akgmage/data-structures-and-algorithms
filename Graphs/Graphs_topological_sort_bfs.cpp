/*
Implementation of Topological sort using BFS
According to Introduction to Algorithms, given a directed acyclic graph (DAG), 
a topological sort is a linear ordering of all vertices such that for any edge (u, v), u comes before v. Another way to describe 
it is that when you put all vertices horizontally on a line, all of the edges are pointing from left to right.
*/
#include<bits/stdc++.h>
using namespace std;
template<typename T>
class Graph{
    public:
        map<T, list<T> > L;
        Graph(){ 

        }
        void addEdge(int u, int v, bool bidir = false){
            L[u].push_back(v);
            if(bidir){
                L[v].push_back(u);
            }
        }
        void printList(){
            for(auto i : L){
                cout << i.first << "->";
                for(auto element : i.second){
                    cout << element << ", ";
                }
                cout << endl;
            }
        }
        void bfsTopologicalSort(){
            queue<T> q;
            map<T, bool> visited;
            map<T, int> indegree;
            for(auto i : L){
                T node = i.first;
                visited[node] = false;
                indegree[node] = 0;
            }
            // Initialize the indegrees of all nodes
            for(auto i: L){
                T u = i.first;
                for(T v : L[u]){
                    indegree[v]++;
                }
            }
            // Finding nodes with 0 indegree
            for(auto i : L){
                T node = i.first;
                if(indegree[node] == 0){
                    q.push(node);
                }
            }
            while(!q.empty()){
                T node = q.front();
                q.pop();
                cout << node << "->";
                for(T neighbours : L[node]){
                    indegree[neighbours]--;
                    if(indegree[neighbours] == 0){
                        q.push(neighbours);
                    }
                }
            }
        }

};

int main(){
    Graph<int> g;
    /*
    g.addEdge(0, 2);
    g.addEdge(1, 0);
    g.addEdge(0, 7);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    g.addEdge(3, 4);
    g.addEdge(4, 5);
    g.addEdge(4, 6);
    */
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(2, 4);
    g.addEdge(4, 3);
    g.addEdge(2, 3);
    g.addEdge(3, 5);
    g.addEdge(4, 5);
    g.bfsTopologicalSort();
    return 0;
}
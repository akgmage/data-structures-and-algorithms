/*
Implementation of Topological sort using DFS
According to Introduction to Algorithms, given a directed acyclic graph (DAG), 
a topological sort is a linear ordering of all vertices such that for any edge (u, v), u comes before v. Another way to describe 
it is that when you put all vertices horizontally on a line, all of the edges are pointing from left to right.
*/
#include<bits/stdc++.h>
using namespace std;
template<typename T>
class Graph{
    map<T, list<T> > L;
    public:
        Graph(){

        }
        void addEdge(T v, T u, bool bidir = false){
            L[v].push_back(u);
            if(bidir){
                L[u].push_back(v);
            }
        }
        void print_edge(){
            for(auto x : L){
                cout << x.first << "->";
                for(auto y : x.second){
                    cout << y << ",";
                }
                cout << endl;
            }
        }
        void dfsHelper(T node, map<T, bool> &visited, list<T> &ordering){
            visited[node] = true;
            for(T neighbours : L[node]){
                if(!visited[neighbours]){
                    dfsHelper(neighbours, visited, ordering);
                }                
            }
            // add current node to list because all children of curr node have been visited
            ordering.push_front(node);
        }
        void dfs(){
            map<T, bool> visited;
            list<T> ordering;
            for(auto i : L){
                T node  = i.first;
                if(!visited[node]){
                    dfsHelper(node, visited, ordering);
                }
            }
            for(T element : ordering){
                cout << element << "->";
            }
        }
};
int main(){
    Graph<int> g;
    g.addEdge(0, 2);
    g.addEdge(1, 0);
    g.addEdge(0, 7);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    g.addEdge(3, 4);
    g.addEdge(4, 5);
    g.addEdge(4, 6);
    g.print_edge();
    g.dfs();
    return 0;
}
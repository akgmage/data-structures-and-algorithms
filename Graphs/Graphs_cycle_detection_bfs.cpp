// Graphs Cycle detection using BFS
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
template<typename T>
class Graph{
    map<T, list<T> > L;
    public:
        Graph(){

        }
        void add_edge(T u, T v, bool bidir = true){
            L[u].push_back(v);
            if(bidir){
                L[v].push_back(u);
            }
        }
        void print_edge(){
            for(auto x : L){
                cout << x.first << "->";
                for(auto element : x.second){
                    cout << element << ",";
                }
                cout << endl;
            }
        }
        bool is_cyclic(T source){
            map<T, bool> visited;
            map<T, int> parent;
            queue<T> q;
            q.push(source);
            visited[source] = true;
            parent[source] = source;
            while(!q.empty()){
                T node = q.front();
                q.pop();
                for(T neighbour : L[node]){
                    if(visited[neighbour]==true && parent[node] != neighbour){
                        return true;
                    }
                    else if(!visited[neighbour]){
                        visited[neighbour] = true;
                        q.push(neighbour);
                        parent[neighbour] = node;
                    }
                }
            }
            return false;
        }
  
};

int main(){
    Graph<int> g;
    g.add_edge(1,2);
    g.add_edge(1,4);
    g.add_edge(4,3);
    g.add_edge(2,3);
    g.print_edge();
    if(g.is_cyclic(1)){
        cout << "Graph is Cyclic";
    }
    else{
        cout << "Graph is not Cyclic";
    }
    return 0;
}
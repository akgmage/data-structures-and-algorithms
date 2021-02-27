// Graphs Cycle detection using DFS
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
        bool is_cyclic_helper(T node, map<T, bool> &visited, map<T, bool> &in_stack){
            visited[node] = true;
            in_stack[node] = true;
            for(T neighbour : L[node]){
                if((!visited[neighbour] && is_cyclic_helper(neighbour, visited, in_stack)) || in_stack[neighbour]){
                    return true;
                }
            }
            in_stack[node] = false;
            return false;
        }
        bool is_cyclic(){
            map<T, bool> visited;
            map<T, bool> in_stack;
            for(auto x: L){
                T node = x.first;
                if(!visited[node]){
                    bool answer = is_cyclic_helper(node, visited, in_stack);
                    if(answer){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
};

int main(){
    Graph<int> g;
    g.add_edge(0, 2, false);
    g.add_edge(0, 1, false);
    g.add_edge(2, 3, false);
    g.add_edge(2, 4, false);
 //   g.add_edge(3, 0, false);
    g.add_edge(4, 5, false);
    g.add_edge(1, 5, false);
    if(g.is_cyclic()){
        cout << "Cycle present" << endl;
    }
    else{
        cout << "Cycle not present" <<  endl;
    }
    return 0;
}
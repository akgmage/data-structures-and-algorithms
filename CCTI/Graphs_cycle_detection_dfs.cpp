#include<bits/stdc++.h>
using namespace std;
template<typename T>
class Graph{
    map<T, list<T> > L;
    public:
        Graph(){

        }
        void add_edge(int u, int v, bool bidir = false){
            L[u].push_back(v);
            if(bidir){
                L[v].push_back(u);
            }
        }
        void print_graph(){
            for(auto i : L){
                cout << i.first << "->";
                for(auto x: i.second){
                    cout << x << ",";
                }
                cout << endl;
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
            for(auto i : L){
                T node = i.first;
                bool result = is_cyclic_helper(node, visited, in_stack);
                if(result){
                    return true;
                }
                else{
                    return false;
                }
            
            }
        }
};
int main(){
    Graph<int> g;
    g.add_edge(0, 2);
    g.add_edge(0, 1);
    g.add_edge(2, 3);
    g.add_edge(2, 4);
    g.add_edge(3, 4);
    //g.add_edge(5, 0); // uncomment to make cycle
    //g.add_edge(3, 0); //uncomment to make cycle
    g.add_edge(4, 5);
    g.add_edge(1, 5);
    if(g.is_cyclic()){
        cout << "Graph is Cyclic\n";
    }
    else{
        cout << "Graph is Not Cyclic\n";
    }
}
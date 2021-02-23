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
        int bfs_sssp(int n, int m){
            queue<int> q;
            map<int, int> dist;
            map<int, int> parent;
            for(auto i : adjList){
                dist[i.first] = INT_MAX;
            }
            q.push(n);
            dist[n] = 0;
            parent[n] = n;
            while(!q.empty()){
                int node_element = q.front();
                q.pop();
                for(int neighbour : adjList[node_element]){
                    if(dist[neighbour] == INT_MAX){
                        q.push(neighbour);
                        dist[neighbour] = dist[node_element] + 1;
                        parent[neighbour] = node_element;
                    }
                }
            }
            cout << endl;
            int temp = m;
            while(temp != n){
                cout << temp << "-->";
                temp = parent[temp];
            }
            cout << n << endl;
            /*
            for(auto i : adjList){
                int node = i.first;
                cout << "Distance of " << node << " is " << dist[node] << endl;
            }
            */
            return dist[m];

        }
};
int main(){
    Graph<int> g;
    int board[50] = {0};
    board[2] = 13;
    board[5] = 2;
    board[9] = 18;
    board[18] = 11;
    board[17] = -13;
    board[20] = -14;
    board[24] = -8;
    board[25] = -10;
    board[32] = -2;
    board[34] = -22;
    for(int u = 0; u <= 36; u++){
        for(int dice  = 1; dice <= 6; dice++){
            int v = u + dice + board[u + dice];
            g.addEdge(u, v, false);
        }
    }
    cout <<  "The shortest distance is " << g.bfs_sssp(1, 36) << endl;
    return 0;
}
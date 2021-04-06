/* 
    Given a list of process where each process has a unique id and parent id.
    Parent id is the id of the process that initiated that process.
    You have to kill a particular process given by an integer kill. 
    Print id of all the processes that will be killed to kill that process
    In order to kill a process, all its child processes should be killed as well 
    also only one process have parent id as 0 ie the process that started itself
    Input : process id : [3, 1, 5, 7, 10, 11, 12] 
            parent id  : [0, 3, 3, 5, 5, 10, 10]
            kill_id    : 5
    Output:              [5, 7, 10, 11, 12]         
*/
#include<bits/stdc++.h>
using namespace std;

template<typename T>
class Graph{
    map<T, list<T> > L;
    public:
        Graph(){

        }
        void add_list(int u, int v, bool bidir = false){
            L[u].push_back(v);
            if(bidir){
                L[v].push_back(u);
            }    
        }
        void print_graph(){
            for(T node : L){
                cout << node.first << "->";
                for(T neighbour: node.second){
                    cout << neighbour << ",";
                }
                cout << endl;
            }
        }
        void kill_process(int process){
            map<T, bool> visited;
            queue<T> q;
            q.push(process);
            visited[process] = true;
            while(!q.empty()){
                int node = q.front();
                cout << node << "->";
                q.pop();
                for(T neighbour : L[node]){
                    if(!visited[neighbour]){
                        q.push(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
        }
};
int main(){
    Graph<int> g;
    int n;
    cout << "Enter number of process : ";
    cin >> n;
    vector<int> process_id(n);
    vector<int> parent_id(n);
    for(int i = 0; i < n; i++){
        cin >> process_id[i];
    }
    for(int i = 0; i < n; i++){
        cin >> parent_id[i];
    }
    for(int i = 0; i < n; i++){
        g.add_list(parent_id[i], process_id[i]);
    }
    int kill;
    cout << "Enter process to be killed : ";
    cin >> kill;
    g.kill_process(kill);
    return 0;
}
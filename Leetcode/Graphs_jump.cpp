/*
    Given an array of non-negative integers arr, 
    you are initially positioned at start index of the array. 
    When you are at index i, you can jump to i + arr[i] or i - arr[i], 
    check if you can reach to any index with value 0.
    Notice that you can not jump outside of the array at any time.
    Input: arr = [4,2,3,0,3,1,2], start = 5
    Output: true
*/
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
template<typename T>
class Graph{
    map<T, list<T> > L;
    public:
        Graph(){

        }
        void add_edge(T u, T v, bool bidir = false){
            L[u].push_back(v);
            if(bidir)
                L[v].push_back(u);
        }
        void print_adj_list(){
            for(auto x : L){
                cout << x.first << "->";
                for(auto element : x.second){
                    cout << element << ",";
                }
                cout << endl;
            }
        }
        bool can_jump(T source, T destination){
            queue<T> q;
            map<T, bool> visited;
            q.push(source);
            visited[source] = true;
            while(!q.empty()){
                T node = q.front();
                q.pop();
                for(T neighbours : L[node]){
                    if(!visited[neighbours]){
                        visited[neighbours] = true;
                        q.push(neighbours);
                    }

                }
            }
            if(!visited[destination]){
                return false;
            }
            return true;
        }
};
int main(){
    Graph<int> g; 
    int n, starting_node;

    cin >> n >> starting_node;
    vector<int> vertices(n);
    int pos_of_zero = 3;
    
    for(int i = 0; i < n; i++){
        cin >> vertices[i];
    }
    for(int i = 0; i < n; i++){
        cout << vertices[i] << ",";
    }
    cout << endl;
    g.add_edge(0, 0 + vertices[0]);
    for(int i = 1; i < n - 1; i++){
        if(vertices[i] == 0)
            continue;
        if(i + vertices[i] > 0 && i + vertices[i] < n){
            g.add_edge(i, i + vertices[i]);
        }
        if(i - vertices[i] >= 0 && i - vertices[i] < n-1){
            g.add_edge(i, i - vertices[i]);
        }
    }
    g.add_edge(n-1, (n-1) - vertices[n - 1]);
    g.print_adj_list();
    cout << endl;
    if(g.can_jump(starting_node, pos_of_zero))
        cout << "YES";
    else
        cout << "No";   
 
    return 0;
}
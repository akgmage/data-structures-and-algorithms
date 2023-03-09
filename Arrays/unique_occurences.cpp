/*
    Given an array of integers arr, write a function that returns true 
    if and only if the number of occurrences of each value in the array is unique.
    Input: arr = [1,2,2,1,1,3]
    Output: true
    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
*/
#include<bits/stdc++.h>
using namespace std;
bool check_unique(vector<int>& V, int n){
    map<int, int> M;
    for(int x : V){
        M[x]++;
    }
    map<int, int> second_map;
    for(auto x : M){
        if(second_map[x.second] > 0) // if same map value encountered then return false
            return false;
        else
            second_map[x.second]++;      
    }
    return true;
}
int main(){
    int n;
    cin >> n;
    vector<int> V(n);
    for(int i = 0; i < n; i++){
        cin >> V[i];
    }
    if(check_unique(V, n))
        cout << "True";
    else
        cout << "False";    
    return 0;
}

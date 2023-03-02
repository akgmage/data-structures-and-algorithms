// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Input : [1, 0, 0, 4, 3]
// Output : [1, 4, 3, 0, 0]
#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<int> V(n);
    for(int i = 0; i < n; i++){
        cin >> V[i];
    }
    int x = 0;
    for(int i = 0; i < n; i++){
        if(V[i] != 0){
            V[x] = V[i];
            x++;
        }
    }
    for(int i = x; i < n; i++){
        V[i] = 0;
    }
    for(int i = 0; i < n; i++){
        cout << V[i] << " ";
    }
    return 0;
}
// Printing all subarrays of an array
#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<int> V(n);
    for(int i = 0; i < n; i++){
        cin >> V[i];
    }
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            for(int k = i; k <= j; k++){
                cout << V[k] << ",";
            }
            cout << endl;
        }
    }
}
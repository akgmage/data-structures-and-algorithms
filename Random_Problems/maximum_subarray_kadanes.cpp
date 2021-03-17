// Subarray with maximum sum using kadane's algo O(n)
#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<int> V(n);
    for(int i = 0; i < n; i++){
        cin >> V[i];
    }
    int curr_sum = 0;
    int max_sum_so_far = INT_MIN;
    for(int x : V){
        curr_sum += x;
        max_sum_so_far = max(curr_sum, max_sum_so_far);
        curr_sum = max(curr_sum, 0);
    }
    cout << max_sum_so_far;
    return 0;
}
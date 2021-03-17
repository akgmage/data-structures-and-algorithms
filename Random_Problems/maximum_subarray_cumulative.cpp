// Subarray with maximum sum using cumulative sum O(n^2)
#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<int> V(n);
    vector<int> W(n);
    for(int i = 0; i < n; i++) W[i] = 0;
    cin >> V[0];
    W[0] = V[0];
    for(int i = 1; i < n; i++){
        cin >> V[i];
        W[i] = W[i-1] + V[i];
    }
    for(int i = 0; i < n; i++) cout << W[i] << " ";
    cout << endl;
    int current_sum = 0, left = 0, right = 0;
    int maximum_sum = INT_MIN;
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            current_sum = 0;
            current_sum = W[j] - W[i - 1];
            if(current_sum > maximum_sum){
                maximum_sum = current_sum;
                left = i;
                right = j;
            }
            //maximum_sum = max(maximum_sum, current_sum); 
        }
    }
    cout << maximum_sum << endl;
    for(int i = left; i <= right; i++) 
        cout << V[i];
    return 0;
}
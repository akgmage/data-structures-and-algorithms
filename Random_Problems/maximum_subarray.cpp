// Subarray with maximum sum O(n^3)
#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<int> V(n);
    for(int i = 0; i < n; i++){
        cin >> V[i];
    }
    int current_sum = 0, left = 0, right = 0;
    int maximum_sum = INT_MIN;
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            current_sum = 0;
            for(int k = i; k <= j; k++){
                current_sum += V[k];
            }
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
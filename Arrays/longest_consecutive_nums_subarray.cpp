// Subarray with maximum sum using cumulative sum O(n^2)
#include<bits/stdc++.h>
using namespace std;
const int Nmax = 100001;
int a[Nmax], n;
bool fr[Nmax];

int longest_consecutive_nums_subarray(){
    int ans = 0;
    for(int left = 1; left <= n; left++){
        for(int i = 1; i <= n; i++){
            fr[i] = false;
        }
        int mini = a[left], maxi = a[left];
        for(int right = left; right <= n; right++){
            if(fr[a[right]])
                break;
            fr[a[right]] = true;
            mini = min(mini, a[right]);
            maxi = max(maxi, a[right]);
            if(right - left == maxi - mini){
                ans = max(ans, right - left + 1);
            }    
        }
    }
    return ans;
}
int main(){
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> a[i];
    }
    cout << longest_consecutive_nums_subarray();
    return 0;
}
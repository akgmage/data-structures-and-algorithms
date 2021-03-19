// Minimum steps to reduce a number to one Recursive + Memoized
// Program Author : Abhisek Kumar Gupta

#include<bits/stdc++.h>
using namespace std;
int memoized[10004];
int find_min_steps(int number){
    if(number == 1)
        return 0;
    int r1 = INT_MAX, r2 = INT_MAX, r3 = INT_MAX;
    if(memoized[number] != -1) return memoized[number];
        r1 = 1 + find_min_steps(number - 1);
    if(number % 2 == 0)
        r2 = 1 + find_min_steps(number / 2);
    if(number % 3 == 0)
        r3 = 1 + find_min_steps(number / 3);
    memoized[number] = min(r1, min(r2, r3));
    return memoized[number];
}


int main(){
    int number;
    cin >> number;
    memset(memoized, -1, sizeof(memoized));
    int result = find_min_steps(number);
    cout << result;
    return 0;
}
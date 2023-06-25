// Minimum steps to reduce a number to one conditions are as follows
// a)  subtract 1 [one operation] 
// b)  divide by 2 [one operation] 
// c)  divide by 3 [one operation]

// Dynamic Programming solution
// Program Author : Abhisek Kumar Gupta
/*
    Input  : 10
    Output : 3
    Explanation : 10 reduced to 9 reduced to 3 reduced to 1 [total 3 operations]
    Input  : 15
    Output : 4
*/
#include<bits/stdc++.h>
using namespace std;
int dp[10000];
int find_min_steps(int number){
    int r1 = INT_MAX, r2 = INT_MAX, r3 = INT_MAX;
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;
    for(int i = 4; i <= number; i++){
        r1 = 1 + dp[i - 1];
        if(i % 2 == 0)
            r2 = 1 + dp[i / 2];
        if(i % 3 == 0)
            r3 = 1 + dp[i / 3];
        dp[i] = min(r1, min(r2, r3));
        r1 = INT_MAX, r2 = INT_MAX, r3 = INT_MAX;
    }

    return dp[number];
}

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
    memset(dp, 0, sizeof(dp));
    int result = find_min_steps(number);
    cout << result;
    return 0;
}

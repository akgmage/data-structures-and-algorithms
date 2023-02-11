/*
    Given two strings str1 and str2 and following three operations that can performed on str1. 
    1) Insert
    2) Remove
    3) Replace
    Find minimum number of operations required to convert ‘str1’ into ‘str2’. 
    For example if input strings are CAT AND CAR the edit distance is 1.

    Input  : s1 : saturday  s2 : sunday 
    Output : 3  
*/
// Memoized Solution : TC O(n^2)
// Porgram Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
int calls = 0;
int memoize[1009][1009];
int find_edit_distance(string s1, string s2, int l1, int l2){
    calls++;
    if(l1 == 0)
        return l2;
    if(l2 == 0)
        return l1;
    if(memoize[l1][l2] != -1) return memoize[l1][l2];          
    if(s1[l1] == s2[l2]){
        return find_edit_distance(s1, s2, l1 - 1, l2 - 1);
    }
    int del = find_edit_distance(s1, s2, l1, l2 - 1);
    int replace = find_edit_distance(s1, s2, l1 - 1, l2 - 1);
    int insert = find_edit_distance(s1, s2, l1 - 1, l2);
    memoize[l1][l2] = min (del, min(replace, insert)) + 1;
    return min (del, min(replace, insert)) + 1;
}
int main(){
    memset(memoize, -1, sizeof(memoize));
    string s1 = "abhisek";
    string s2 = "tsunade";
    int l1 = s1.length() - 1;
    int l2 = s2.length() - 1;
    int result = find_edit_distance(s1, s2, l1, l2);
    cout << result;
    cout << "\n" << calls;
    return 0;
}
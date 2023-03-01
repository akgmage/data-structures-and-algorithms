// Implement an algorithm to determine if a string is permutation of other.
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
bool check_permutation(string s, string t){
    // Time complexity O(n log (n)) n = len of string
    // but its clean simple and easy to understand
    if(s.length() != t.length())
        return false;
    sort(s.begin(), s.end());
    sort(t.begin(), t.end());
    if(s.compare(t) == 0)
        return true;
    return false;    
}
bool check_permutation_fast(string s, string t){
    // TC O(n)
    if(s.length() != t.length())
        return false;
    map<char, int> letters;
    for(char c : s){
        letters[c]++;
    }
    for(char c : t){
       letters[c]--;
       if(letters[c] < 0){
        return false;
       } 
    }
    return true;    
}
void print_ans(bool ans){
    if(ans){
        cout << "YES\n";
    }
    else{
        cout << "NO\n";
    }
}
int main(){
    check_permutation("ABDE", "DEBA") ? print_ans(true) : print_ans(false);
    check_permutation("ABCD", "DEFG") ? print_ans(true) : print_ans(false);
    check_permutation_fast("AA", "DEBA") ? print_ans(true) : print_ans(false);
    check_permutation_fast("ADEB", "ABED") ? print_ans(true) : print_ans(false);
    return 0;
}
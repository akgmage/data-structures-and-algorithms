// Implement an algorithm to determine if a string has all unique characters.
// what if you cannot use additional data structures?
// Program Author : Abhisek Kumar Gupta
// Approach 1 : compare every character of string with other character TC O(n^2)
// Approach 2 : Sort the string and compare neighbouring character for dups
//   TC of approach 2  : O(n log(n))
#include<bits/stdc++.h>
using namespace std;
bool is_unique_normal(string s){
    // using additional data structure
    // TC O(min(c, n)) c being size of character set n = len of string
    // SC is O(1) here
    if(s.length() > 128)
        return false;
    bool visited[128];
    for(int i = 0; i < s.length(); i++){
        int val = s[i] - 'a';
        if(visited[val]){
            return false;
        }
        visited[val] = true;
    }
    return true;    
}
bool is_unique(string s){
    // without using additional data structures
    // here we reduce our space usage
    if(s.length() > 128)
        return false;    
    int checker = 0;
    for(int i = 0; i < s.length(); i++){
        int val = s[i] - 'a';
        if(checker & (1 << val))
            return false;
        checker |= (1 << val);    
    }
    return true;    
}
void print_ans(bool ans, string s){
    if(ans){
        cout << s << " is unique\n";
    }
    else{
        cout << s << " is not unique\n";
    }
}
int main(){
    string s = "ABCDD";
    string t = "ABCD";
    string u = "AAAAAABCD";
    is_unique_normal(s) == true ? print_ans(true, s) : print_ans(false, s);
    is_unique_normal(t) == true ? print_ans(true, t) : print_ans(false, t);
    is_unique_normal(u) == true ? print_ans(true, u) : print_ans(false, u);
    cout << "\n***********************\n";
    is_unique(s) == true ? print_ans(true, s) : print_ans(false, s);
    is_unique(t) == true ? print_ans(true, t) : print_ans(false, t);
    is_unique(u) == true ? print_ans(true, u) : print_ans(false, u);
    return 0;
}
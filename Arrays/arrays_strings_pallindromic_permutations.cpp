// Write a function to check if it is a permutation of a pallindrome
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
// TC O(n) n is length of string
bool is_permutation_pallindrome(string s){
    // we built a hash table to count how many times each character appears
    // we then iterate through hashtable to find out no more than one character has 
    // odd count
    vector<int> table(26, 0);
    bool found_odd = false;
    for(int i = 0; i < s.length(); i++){
        table[s[i]-'a']++; 
    }
    for(int x : table){
        if(x&1){
            if(found_odd){
                return false;
            }
            found_odd = true;
        }
    }
    return true;
}
bool is_permutation_pallindrome_improved(string s){
    // instead of checking oddcounts at end we can check 
    // as we traverse the chars in string, as soon as we reach end 
    // we have out answer.
    vector<int> table(26, 0);
    int count_odd = 0;
    for(int i = 0; i < s.length(); i++){
        int x = s[i]-'a'; 
        table[x]++;
        if(table[x] & 1){
            count_odd++;
        } 
        else{
            count_odd--;
        }
    }
    return count_odd <= 1;
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
    is_permutation_pallindrome("aaabdddcba") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome("abab") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome("ABA") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome("abcddeab") ? print_ans(true) : print_ans(false);
    cout << "**********IMPROVED*********\n";
    is_permutation_pallindrome_improved("a") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome_improved("ab") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome_improved("ABA") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome_improved("abcddeab") ? print_ans(true) : print_ans(false);
    return 0;
}
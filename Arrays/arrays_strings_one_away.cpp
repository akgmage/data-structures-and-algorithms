//  Given two strings write a function to check if they are one edit(or zero edits) away
//  Program Author : Abhisek Kumar Gupta

// Sample Input : Pale Ple
// Output : Yes Pale
// Sample Input : Pale bae
// Output : No 
#include<bits/stdc++.h>
using namespace std;
bool one_edit_replace(string a, string b){
    bool found_difference = false;
    for(int i = 0; i < a.length(); i++){
        if(a[i] != b[i]){
            if(found_difference){
                return false;
            }
            found_difference = true;
        }
    }
    return true;
}
bool one_edit_insert(string a, string b){
    int i1 = 0, i2 = 0;
    while(i1 < a.length() && i2 < b.length()){
        if(a[i1] != b[i2]){
            if(i1 != i2){
                return false;
            }
            i2++;
        }
        else{
            i1++;
            i2++;
        }
    }
    return true;
}
bool is_one_edit_away(string a, string b){
    if(a.length() == b.length()){
        return one_edit_replace(a, b);
    }
    else if(a.length() + 1 == b.length()){
        return one_edit_insert(a, b);
    }
    else if(a.length() - 1 == b.length()){
        return one_edit_insert(b, a);
    }
    return false;
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
    is_one_edit_away("Pale", "Ple") == true ? print_ans(true) : print_ans(false);
    is_one_edit_away("Pales", "Pale") == true ? print_ans(true) : print_ans(false);
    is_one_edit_away("Pale", "bale") == true ? print_ans(true) : print_ans(false);
    is_one_edit_away("Pale", "bae") == true ? print_ans(true) : print_ans(false);   
    return 0;
}

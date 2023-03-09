// Write a function to check if it is a permutation of a pallindrome using bitvector
// Program Author : Abhisek Kumar Gupta
// Sample Input : aabcb
// Output : Yes
// Sample Input : ab
// Output : No
#include<bits/stdc++.h>
using namespace std;
bool check_exactly_for_one_set_bit(int bit_vector){
    return (bit_vector & (bit_vector - 1)) == 0;
}
int toggle(int bit_vector, int x){
    if(x < 0) return bit_vector;
    int mask = 1 << x;
    if((bit_vector & mask) == 0){
        bit_vector |= mask;
    }
    else{
        bit_vector &= ~mask;
    }
    return bit_vector;
}

int create_bit_vector(string a){
    int bit_vector = 0, mask = 0;
    for(int i = 0; i < a.length(); i++){
        int x = a[i] - 'a';
        bit_vector = toggle(bit_vector, x);
        /*
        mask = 1 << x;
        if((bit_vector & mask) == 0){
            bit_vector |= mask;
        }
        else{
            bit_vector &= ~mask;
        }
        */
    }
    return bit_vector;
}
void print_ans(bool ans){
    if(ans){
        cout << "YES\n";
    }
    else{
        cout << "NO\n";
    }
}
bool is_permutation_pallindrome(string a){
    int bit_vector = create_bit_vector(a);
    return bit_vector == 0 || check_exactly_for_one_set_bit(bit_vector);
}
int main(){
    is_permutation_pallindrome("aabcb") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome("ab") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome("ABA") ? print_ans(true) : print_ans(false);
    is_permutation_pallindrome("racecarf") ? print_ans(true) : print_ans(false);
    return 0;
}
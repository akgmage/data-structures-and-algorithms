// Check if a string is a permutation of other 
// Sample Input: s1 = abba s2 = baba
// Output: true 
#include<bits/stdc++.h>
using namespace std;
bool check_permutations(string a, string b){
    vector<int> Freq(26, 0);
    for(int i = 0; i < a.length(); i++){
        Freq[a[i] - 'a']++;
    }
    for(int x : Freq) cout << x << ",";
    cout << endl;
    for(int i = 0; i < b.length(); i++){
        if(Freq[b[i] - 'a'] > 0)
            Freq[b[i] - 'a']--;
        else
            Freq[b[i] - 'a']++;    
    }
    for(int x : Freq) cout << x << ",";
    cout << endl;
    int res = accumulate(Freq.begin(), Freq.end(), 0);
    return res == 0 ? true : false;
}
int main(){
    string a, b;
    cin >> a >> b;
    if(check_permutations(a, b))
        cout << "TRUE";
    else 
        cout << "FALSE";    
    return 0;
}
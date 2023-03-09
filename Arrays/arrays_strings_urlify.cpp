// Implement an algorithm to replace all spaces with %20.
// Sample Input : Mr Ashish Lala 
// Output: Mr%20Ashish%20Lala
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
void urlify(string s, int length){
    int space_count = 0;
    for(int i = 0; i < length; i++){
        if(s[i] == ' '){
            space_count++;
        }
    }
    int index = length + (space_count * 3);
    int new_length = index;
    for(int i = length - 1; i >= 0; i--){
        if(s[i] == ' '){
            s[index - 1] = '0';
            s[index - 2] = '2';
            s[index - 3] = '%';
            index = index - 3;
        }
        else{
            s[index - 1] = s[i];
            index--;
        }
    }
    for(int i = index; i < new_length; i++){
        cout << s[i];
    }

}
int main(){
    string s = "Mr John Smith               ";
    int  length = 13;
    urlify(s, 13);
    return 0;
}
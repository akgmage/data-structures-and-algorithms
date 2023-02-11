// Linear search in an array of strings
#include<bits/stdc++.h>
using namespace std;
int main(){
    char a[10][100];
    int n;
    cin >> n;
    cin.ignore();
    for(int i = 0 ; i < n; i++){
        cin.getline(a[i], 100);
    }
    char key[100];
    cout << "Enter string to search : ";
    cin.getline(key, 100);
    int i = 0; 
    for(i = 0; i < n; i++){
        if(strcmp(key, a[i]) == 0){
            cout << "Found at index : " << i;
            break;
        }    
    }
    if(i == n)
        cout << "Not Found" <<endl;
    return 0;
}
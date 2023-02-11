// Rotating a string
#include<bits/stdc++.h>
using namespace std;

void rotate(char *a, int k){
    int len = strlen(a);
    while(len >= 0){
        a[len + k] = a[len];
        len--;
    }
    len = strlen(a);
    int j = len - k;
    int s = 0;
    while(j < len){
        a[s] = a[j];
        s++;
        j++;
    }
    a[len - k] = '\0';
}
int main(){
    char a[100] = "abhisekkumar";
    int k = 5;
    rotate(a, k);
    cout << a << endl;
    return 0;
} 
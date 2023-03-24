// Prints a matrix in wave form 
#include<bits/stdc++.h>
using namespace std;
void wave_print(int Mat[][10], int R, int C){
    for(int j = 0; j < C; j++){
        if(j & 1){
            for(int i = R - 1; i >= 0; i--){
                cout << Mat[i][j] << " ";
            }
        }
        else{
            for(int i = 0; i < R; i++){
                cout << Mat[i][j] << " ";
            }
        }
    }
}
int main(){
    int Mat[10][10], R, C;
    cin >> R >> C;
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cin >> Mat[i][j];
        }
    }
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cout << Mat[i][j] << " ";
        }
        cout << endl;
    }
    wave_print(Mat, R, C);
}
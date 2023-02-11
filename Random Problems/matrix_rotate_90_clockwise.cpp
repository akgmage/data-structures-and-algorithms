#include<bits/stdc++.h>
using namespace std;
int main(){
    int Mat[10][10], R, C, value = 1;
    cin >> R >> C;
    // creating matrix
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            Mat[i][j] = value++;
        }
    }
    // Transposing matrix
    for(int i = 0; i < R; i++){
        for(int j = i + 1; j < C; j++){
            swap(Mat[i][j], Mat[j][i]);
        }
    }
    //Rotate matrix 90 degrees clockwise
    for(int i = 0; i < R; i++){
        int start = 0;
        int end = C-1;
        while(start < end){
            swap(Mat[i][start], Mat[i][end]);
            start++;
            end--;
        }
    }    
    // Display matrix
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cout << Mat[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}
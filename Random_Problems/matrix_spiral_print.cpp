// Printing Matrix in spiral order 
#include<bits/stdc++.h>
using namespace std;
void print_spiral(int Mat[][10], int R, int C){
    int startRow = 0, endRow = R-1, startCol = 0, endCol = C-1; 
    while(startRow <= endRow && startCol <= endCol){
        // Print first row
        for(int i = startCol; i <= endCol; i++){
            cout << Mat[startRow][i];
        }
        startRow++;
        // print end col
        for(int i = startRow; i <= endRow; i++){
            cout << Mat[i][endCol];
        }
        endCol--;
        // Print end row
        if(endRow > startRow){
            for(int i = endCol; i >= startCol; i--){
                cout << Mat[endRow][i];
            }
            endRow--;
        }
        // print start row
        if(startCol < endCol){
            for(int i = endRow; i >= startRow; i--){
                cout << Mat[i][startCol];
            }
            startCol++;
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
    print_spiral(Mat, R, C);
    return 0;
}
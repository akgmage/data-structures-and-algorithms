#include<bits/stdc++.h>
using namespace std;
int main(){
    int mat[100][100];
    int row, col;
    cin >> row >> col;
    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            cin >> mat[i][j];
        }
    }
    // spiral print
    int start_row = 0;
    int start_col = 0;
    int end_row = row - 1;
    int end_col = col - 1;
    while(start_row <= end_row && start_col <= end_col){
        // print first row
        for(int i = start_col; i <= end_col; i++){
            cout << mat[start_row][i] << " ";
        }
        start_row++;
        // print last col
        for(int i = start_row; i <= end_row; i++){
            cout << mat[i][end_col] << " ";
        }
        end_col--;
        // last row
        if(end_row > start_row){
            for(int i = end_col; i >= start_col; i--){
                cout << mat[end_row][i] << " ";
            }
            end_row--;
        }
        // start column
        if(end_col > start_col){
            for(int i = end_row; i >= start_row; i--){
                cout << mat[i][start_col] << " ";
            }
            start_col++;
        }
    }
    return 0;
}    
        
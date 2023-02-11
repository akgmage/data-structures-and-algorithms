/*
    Given a cost matrix cost[][] and a position (m, n) in cost[][], 
    write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). 
    Each cell of the matrix represents a cost to traverse through that cell. 
    The total cost of a path to reach (m, n) is the sum of all the costs on that path 
    (including both source and destination). You can only traverse down and right
    from a given cell, i.e., from a given cell (i, j), cells 
    (i+1, j), (i, j+1) can be traversed. You may assume that all 
    costs are positive integers.
    Input  : {1, 2, 3, 4},
             {5, 6, 7, 8},
             {9, 10, 11, 12}
    Output : 30 [Path : 1->2->3->4->8->12]
*/
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
int dp[100][100] = {};
int min_cost_path_in_a_grid(int grid[][100], int m, int n){
    
    dp[0][0] = grid[0][0];
    //row
    for(int i = 1; i < m; i++){
        dp[i][0] = grid[i][0] + dp[i - 1][0];
    }
    //col
    for(int i = 1; i < n; i++){
        dp[0][i] = grid[0][i] + dp[0][i - 1];
    }

    for(int i = 1; i < m; i++){
        for(int j = 1; j < n; j++){
            dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    return dp[m-1][n-1];
}
int main(){
    int grid[100][100] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    int m = 3, n = 4;
    int result = min_cost_path_in_a_grid(grid, m, n);
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            cout << setw(5) <<dp[i][j] << " ";
        }
        cout << "\n";
    }
    cout << result;
}
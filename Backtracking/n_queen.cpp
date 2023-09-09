#include <iostream>
#include <vector>

using namespace std;

// Function to check if it's safe to place a queen at board[row][col]
bool isSafe(vector<string>& board, int row, int col, int N) {
    // Check the row on the left side
    for (int i = 0; i < col; ++i) {
        if (board[row][i] == 'Q') {
            return false;
        }
    }

    // Check upper diagonal on the left side
    for (int i = row, j = col; i >= 0 && j >= 0; --i, --j) {
        if (board[i][j] == 'Q') {
            return false;
        }
    }

    // Check lower diagonal on the left side
    for (int i = row, j = col; i < N && j >= 0; ++i, --j) {
        if (board[i][j] == 'Q') {
            return false;
        }
    }

    return true;
}

// Recursive function to solve N-Queens problem
bool solveNQueens(vector<string>& board, int col, int N) {
    if (col == N) {
        // All queens are placed successfully
        return true;
    }

    for (int i = 0; i < N; ++i) {
        if (isSafe(board, i, col, N)) {
            // Place queen
            board[i][col] = 'Q';

            // Recur to place the rest of the queens
            if (solveNQueens(board, col + 1, N)) {
                return true;
            }

            // If placing queen in board[i][col] doesn't lead to a solution, backtrack
            board[i][col] = '.';
        }
    }

    // If no queen can be placed in this column, return false
    return false;
}

// Function to solve N-Queens problem and print the solution
void solveNQueens(int N) {
    vector<string> board(N, string(N, '.'));

    if (solveNQueens(board, 0, N)) {
        // Print the solution
        for (int i = 0; i < N; ++i) {
            cout << board[i] << endl;
        }
    } else {
        cout << "No solution exists." << endl;
    }
}

int main() {
    int N;
    cout << "Enter the number of queens (N): ";
    cin >> N;

    solveNQueens(N);

    return 0;
}

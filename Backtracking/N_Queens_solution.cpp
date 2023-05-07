// AUTHOR : SAGAR WADHWA
class Solution {
public:
    unordered_map<int, bool> rowCheck;
    unordered_map<int, bool> upperLeftDiagnolCheck;
    unordered_map<int, bool> bottomLeftDiagnolCheck;
    void storeSolution(vector<vector<char>> &board, int n,vector<vector<string>> &answer)
    {
        vector<string> temp;
        for (int i = 0; i < n; i++)
        {
            string output = "";
            for (int j = 0; j < n; j++)
            {
                output.push_back(board[i][j]);
            }
            temp.push_back(output);
        }
        answer.push_back(temp);
    }
    bool isSafe(int rowNumber, int columnNumber, vector<vector<char>> &board, int n)
    {
        if (rowCheck[rowNumber] == true)
        {
            return false;
        }
        if (upperLeftDiagnolCheck[n - 1 + columnNumber - rowNumber] == true)
        {
            return false;
        }
        if (bottomLeftDiagnolCheck[rowNumber + columnNumber] == true)
        {
            return false;
        }
        return true;
    }
    vector<vector<string>> solveNQueens(int n) {
        // creating the board
        vector<vector<char>> board(n, vector<char>(n, '.'));
        vector<vector<string>> answer;

        // since initially we try to place Q1 at column number 0
        int columnNumber = 0;
        solve(board, columnNumber, n,answer);
        return answer;
    }
    void solve(vector<vector<char>> &board, int columnNumber, int n,vector<vector<string>> &answer)
    {
        // base case,
        if (columnNumber >= n)
        {
            storeSolution(board, n,answer);
            return;
        }

        // try to place the queen at every possible cell
        for (int rowNumber = 0; rowNumber < n; rowNumber++)
        {
            if (isSafe(rowNumber, columnNumber, board, n))
            {
                board[rowNumber][columnNumber] = 'Q';

                // Add the entries into the map
                rowCheck[rowNumber] = true;
                upperLeftDiagnolCheck[n - 1 + columnNumber - rowNumber] = true;
                bottomLeftDiagnolCheck[rowNumber + columnNumber] = true;

                // now try to place another queen
                solve(board, columnNumber + 1, n,answer);

                // backtracking, when we come back from the above recursive call, unmark the previous queen and                try to place it on another location
                board[rowNumber][columnNumber] = '.';

                // Remove the entries from the map
                rowCheck[rowNumber] = false;
                upperLeftDiagnolCheck[n - 1 + columnNumber - rowNumber] = false;
                bottomLeftDiagnolCheck[rowNumber + columnNumber] = false;
            }
        }
    }
};
// AUTHOR : Sagar Wadhwa
class Solution {
public:
    bool isSafe(vector<vector<char>> &board,int curr_row,int curr_column,char value){
        // check for row
        for(int column=0;column<9;column++){
            if(board[curr_row][column] == value){
                return false;
            }
        }

        // check for column
        for(int row=0;row<9;row++){
            if(board[row][curr_column] == value){
                return false;
            }
        }

        // check for 3*3 block
        for (int i = 0; i < 9; i++)
        {
            if (board[3*(curr_row/3) + (i/3)][3*(curr_column/3) + (i%3)] == value)
            {
                return false;
            }
        }
        return true;
    }
    bool solve(vector<vector<char>> &board){
        int n = board[0].size();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //check if this cell is empty, if yes try to place values from [1-9]
                if(board[i][j]=='.'){
                    for(char value='1';value<='9';value++){
                        if(isSafe(board,i,j,value)){
                            board[i][j]=value;

                            //rest will be handled by recursion
                            bool futureSolution = solve(board);

                            if(futureSolution){
                                //since if we are able to place a value in the further block, no need to backtrack
                                //since it is guranteed that there exists only one solution
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    //if not able to place any value from [1-9] in this block, means we need to backtrack by returning futureSolution as false only then we will be 
                    // able to backtrack
                    return false;
                }
            }
        }
        //when all cells are filled, we will come here, no need to do anything now
        return true;
    }
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }
};
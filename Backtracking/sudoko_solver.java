/*Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:

 */
package Backtracking;

public class sudokoSolver {
    
    
        public void solveSudoku(char[][] board) {
            Solver(board, 0);
        }
    
         static boolean Solver(char[][] board , int total)
        {
            if(total==81)
            {
                return true;
            }
            int sr = total/9;
            int sc = total%9;
             
            if(board[sr][sc]!='.')
            {
                return Solver(board, total+1);
            }
            for(int i=1 ; i<=9 ; i++)
            {
                char curr = (char) (i+'0');
                if(canElementBePlaced(board , sr , sc , curr))
                {
                board[sr][sc]=curr;
                if (Solver(board , total+1))
                {
                  return true;
                }
                board[sr][sc]='.';
            }
        }
        return false;
        }
        static void print(char[][] board)
        {
          for(int i=0; i<9 ;i++)
            {
                for(int j=0 ; j<9 ; j++)
                {
                    System.out.print(board[i][j]+", ");
                }
                System.out.println();
            }
        }
         
        static boolean canElementBePlaced(char[][] board , int r , int c , char k)
        {
            for(int i=0 ; i<9 ; i++)
            {
                if(board[r][i]==k)
                {
                    return false;
                }
            }
            
            for(int j =0 ; j<9 ; j++)
            {
                if(board[j][c]==k)
                {
                    return false;
                }
            }
            
           int sr = r-(r%3);
           int sc = c-(c%3);
           
           for(int i=sr; i<=sr+2;i++)
           {
               for(int j=sc ; j<=sc+2; j++)
               {
                  if (board[i][j]==k)
                   {
                       return false;
                   }
               }
           }
           return true;
        }

}

/*
 This Java code defines a simple command-line Tic-Tac-Toe game that allows two players (X and O) to take turns making moves on a 3x3 game board. Here's an explanation of the code:

1. Constants:
   - `X` and `O` are integer constants representing the two players, with `X` assigned the value `1` and `O` assigned the value `-1`.
   - `EMPTY` is an integer constant representing an empty cell on the game board, with a value of `0`.

2. Game Board:
   - The game board is represented by a 3x3 integer array called `board`.
   - The `player` variable indicates which player's turn it is. It is initially set to `X`.

3. Constructor:
   - The `TicTacToe` class has a constructor that initializes a new game by clearing the board and setting the `player` to `X`.

4. `clearBoard` Method:
   - The `clearBoard` method initializes the game board by setting all cells to `EMPTY` and resets the `player` to `X`.

5. `putMark` Method:
   - The `putMark` method allows a player to make a move at a specified position (i, j).
   - It checks for valid coordinates and an empty cell. If the move is valid, the player's mark is placed, and the turn is switched to the other player.
   - If the move is invalid, an `IllegalArgumentException` is thrown.

6. `isWin` Method:
   - The `isWin` method checks if a player has won the game. It returns `true` if any of the winning conditions (e.g., a row, column, or diagonal with all marks of the same player) are met. Otherwise, it returns `false`.

7. `winner` Method:
   - The `winner` method determines the winner of the game. It checks for both `X` and `O` as potential winners using the `isWin` method and returns the result (positive for `X`, negative for `O`, or `0` for a tie).

8. `toString` Method:
   - The `toString` method converts the current game state to a human-readable string, representing the game board. It uses "X" and "O" to denote player marks and empty spaces as " " (space).

9. `main` Method:
   - In the `main` method, a new Tic-Tac-Toe game is created.
   - A series of moves are made using `putMark`, and the game state is printed after each move.
   - The final outcome of the game is determined using the `winner` method, and the result is displayed as "X wins," "O wins," or "Tie."

The code provides a basic implementation of a command-line Tic-Tac-Toe game with validation for player moves and win conditions. It demonstrates how to represent the game board, make moves, and check for a win or tie in the game.
 */
public class TicTacToe {
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;
    private int board[][] = new int[3][3];
    private int player;

    public TicTacToe() {
        clearBoard();
    }
    public void clearBoard()  {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = EMPTY;
        player = X;
    }

    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
            throw new IllegalArgumentException("Invalid board position");
        if (board[i][j] != EMPTY)
            throw new IllegalArgumentException("Board Position occupied");
        board[i][j] = player;
        player = -player; // switch players
    }

    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3)
                || (board[1][0] + board[1][1] + board[1][2] == mark * 3)
                || (board[2][0] + board[2][1] + board[2][2] == mark * 3)
                || (board[0][0] + board[1][0] + board[2][0] == mark * 3)
                || (board[0][1] + board[1][1] + board[2][1] == mark * 3)
                || (board[0][2] + board[1][2] + board[2][2] == mark * 3)
                || (board[0][0] + board[1][1] + board[2][2] == mark * 3)
                || (board[2][0] + board[1][1] + board[0][2] == mark * 3)
        );
    }
    public int winner() {
        if(isWin(X))
            return (X);
        else if (isWin(O))
            return (O);
        else
            return (0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X: sb.append("X"); break;
                    case O: sb.append("O"); break;
                    case EMPTY: sb.append(" "); break;
                }
                if (j < 2) sb.append("|");
            }
            if(i < 2) sb.append("\n-----\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.putMark(0, 0); game.putMark(0, 2);
        game.putMark(2, 2); game.putMark(1, 2);
        game.putMark(2, 0); game.putMark(1, 1);
        game.putMark(1, 0);


        System.out.println(game);
        int winningPlayer = game.winner();
        String[] outcome = {"O wins", "Tie", "X wins"};
        System.out.println(outcome[1 + winningPlayer]);
    }


}
 {
    
}

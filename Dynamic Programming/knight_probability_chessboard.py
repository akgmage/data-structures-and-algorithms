'''
    On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

    A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.


    Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

    The knight continues moving until it has made exactly k moves or has moved off the chessboard.

    Return the probability that the knight remains on the board after it has stopped moving.

    

    Example 1:

    Input: n = 3, k = 2, row = 0, column = 0
    Output: 0.06250
    Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
    From each of those positions, there are also two moves that will keep the knight on the board.
    The total probability the knight stays on the board is 0.0625.
    Example 2:

    Input: n = 1, k = 0, row = 0, column = 0
    Output: 1.00000
'''
class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        # Create a 3D grid to store the probabilities
        dp = [[[0 for _ in range(k + 1)] for _ in range(n)] for _ in range(n)]
        
        # Define the eight possible knight moves
        moves = [(-2, -1), (-2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2), (2, -1), (2, 1)]
        
        # Set the initial probability of the knight being on the starting cell to 1
        dp[row][column][0] = 1.0
        
        # Calculate the probabilities for each move
        for s in range(1, k + 1):
            for i in range(n):
                for j in range(n):
                    for move in moves:
                        x = i + move[0]
                        y = j + move[1]
                        
                        # Check if the move is within the chessboard
                        if 0 <= x < n and 0 <= y < n:
                            # Accumulate the probability for the current cell
                            dp[i][j][s] += dp[x][y][s - 1] / 8.0
        
        # Calculate the total probability of the knight remaining on the board
        probability = 0.0
        for i in range(n):
            for j in range(n):
                probability += dp[i][j][k]
        
        return probability

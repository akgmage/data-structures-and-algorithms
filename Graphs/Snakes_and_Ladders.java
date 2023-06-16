Here's the Java implementation of the solution along with an explanation:

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {
    
    private static class Position {
        int square;
        int moves;
        
        public Position(int square, int moves) {
            this.square = square;
            this.moves = moves;
        }
    }
    
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private static int[][] getBoardPosition(int square, int n) {
        int row = n - 1 - (square - 1) / n;
        int col = (row % 2 == n % 2) ? (square - 1) % n : n - 1 - (square - 1) % n;
        return new int[]{row, col};
    }
    
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int destination = n * n;
        
        Queue<Position> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(new Position(1, 0)); // Start position
        visited.add(1); // Mark the start position as visited
        
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int square = position.square;
            int moves = position.moves;
            
            if (square == destination) {
                return moves;
            }
            
            for (int roll = 1; roll <= 6; roll++) {
                int nextSquare = square + roll;
                
                if (nextSquare > destination) {
                    break;
                }
                
                int[] pos = getBoardPosition(nextSquare, n);
                int row = pos[0];
                int col = pos[1];
                
                if (!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    
                    if (board[row][col] != -1) {
                        queue.add(new Position(board[row][col], moves + 1));
                    } else {
                        queue.add(new Position(nextSquare, moves + 1));
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] board = {
            {-1, 4},
            {-1, 3}
        };
        
        System.out.println(snakesAndLadders(board)); // Output: 1
    }
}

Explanation:

The Position class is used to store the square number and the number of moves taken to reach that square.
The getBoardPosition function is used to convert a square number to its corresponding (row, column) position on the board.
The snakesAndLadders function implements the breadth-first search (BFS) algorithm to find the shortest path from square 1 to square n^2.
The function uses a queue (ArrayDeque) to store the positions to be explored during BFS and a set (HashSet) to keep track of visited positions.
The function starts by enqueuing the starting position (1, 0) into the queue and marking it as visited.
While the queue is not empty, it dequeues a position and checks if it is the destination square. If it is, the number of moves is returned.
Otherwise, the function generates the next possible destinations based on the roll of a 6-sided die and checks if they are valid and not visited.
If a destination has a snake or ladder, its destination is enqueued

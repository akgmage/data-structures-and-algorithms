/*You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

Explanation:

We start by importing the necessary classes and defining the class SnakesAndLadders.
We declare the constant BOARD_SIZE to represent the number of cells on the board.
We declare two maps: snakes to store the snake positions, and ladders to store the ladder positions.
The SnakesAndLadders class has a constructor that initializes the snakes and ladders maps.
The addSnake method is used to add a snake to the game by providing the start and end positions.
The addLadder method is used to add a ladder to the game by providing the start and end positions.
The playGame method simulates the game. It starts with the player's position at 0 and the number of dice rolls at 0.
Inside the while loop, a dice is rolled using the rollDice method, and the player's position is updated.
After each move, we check if the player has landed on a ladder or a snake. If so, we update the player's position accordingly.
The rollDice method generates a random number between 1 and 6, simulating a dice roll.
In the main method, we create an instance of SnakesAndLadders and add snakes and ladders to the game.
Finally, we call the playGame method to start the game and print the number of dice rolls required to reach or exceed the BOARD_SIZE.
Below is an implementation of the Snakes and Ladders game in Java, along with comments:*/

import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadders {
    private static final int BOARD_SIZE = 100;  // Number of cells in the board
    private Map<Integer, Integer> snakes;        // Map to store snake positions
    private Map<Integer, Integer> ladders;       // Map to store ladder positions

    public SnakesAndLadders() {
        // Initialize the snake and ladder positions
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }

    public void addSnake(int start, int end) {
        snakes.put(start, end);
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    public int playGame() {
        int currentPlayerPosition = 0;  // Player's current position
        int diceRolls = 0;              // Number of dice rolls

        while (currentPlayerPosition < BOARD_SIZE) {
            // Roll a dice
            int dice = rollDice();

            // Move the player
            currentPlayerPosition += dice;

            // Check if the player has landed on a ladder
            if (ladders.containsKey(currentPlayerPosition)) {
                // Climb the ladder
                currentPlayerPosition = ladders.get(currentPlayerPosition);
            }

            // Check if the player has landed on a snake
            if (snakes.containsKey(currentPlayerPosition)) {
                // Go down the snake
                currentPlayerPosition = snakes.get(currentPlayerPosition);
            }

            diceRolls++;  // Increment the number of dice rolls
        }

        return diceRolls;
    }

    private int rollDice() {
        // Generates a random number between 1 and 6 (inclusive)
        return (int) (Math.random() * 6) + 1;
    }

    public static void main(String[] args) {
        SnakesAndLadders game = new SnakesAndLadders();

        // Add snakes to the game
        game.addSnake(16, 6);
        game.addSnake(47, 26);
        game.addSnake(49, 11);
        game.addSnake(56, 53);
        game.addSnake(62, 19);
        game.addSnake(64, 60);
        game.addSnake(87, 24);
        game.addSnake(93, 73);
        game.addSnake(95, 75);
        game.addSnake(98, 78);

        // Add ladders to the game
        game.addLadder(1, 38);
        game.addLadder(4, 14);
        game.addLadder(9, 31);
        game.addLadder(21, 42);
        game.addLadder(28, 84);
        game.addLadder(36, 44);
        game.addLadder(51, 67);
        game.addLadder(71, 91);
        game.addLadder(80, 100);

        // Play the game
        int diceRolls = game.playGame();
        System.out.println("Number of dice rolls: " + diceRolls);
    }
}

Time Complexity:  the average generalized time complexity of the code can be expressed as O(N), where N represents the average number of dice rolls required to
                  complete the game over a large number of instances.
Space Complexity: The average generalized space complexity of the code can be expressed as O(M), where M represents the average number of snakes and ladders add-
                  -ed to the game.

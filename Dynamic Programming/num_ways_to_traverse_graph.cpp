/*

	You're given two positive integers representing the width and height of a grid-shaped, rectangular graph.
	Write a function that returns the number of ways to reach the bottom right corner of the graph when starting
	at the top left corner. Each move you take must either go down or right. In other words, you can never move up
	or left in the graph.

	For example, given the graph illustrated below, with width = 2 and height = 3 , there are three ways to
	reach the bottom right corner when starting at the top left corner:
	 _ _
	|_|_|
	|_|_|
	|_|_|
	Down Down Right
	Right Down Down
	Down Right Down

	Sample Input: Width : 4 height: 3
	Output: 10

	Explanation:
	The code snippet implements the `NumberOfWaysToTraverseGraph` function, which calculates the number of ways to
	traverse a 2D graph from the top-left corner to the bottom-right corner. The graph has a given width and height.

	Here's a breakdown of the code:

	1. The function takes two parameters: `width` and `height`, representing the dimensions of the graph.

	2. It initializes a 2D slice called `numberOfWays` with dimensions `(height+1) x (width+1)`. The additional "+1" is to
	   account for the boundary cases when traversing the graph.

	3. It enters a nested loop to iterate over the graph cells. The outer loop iterates over the width indices (`widthIdx`),
	   and the inner loop iterates over the height indices (`heightIdx`).

	4. For each cell, it checks if it is on the top row (`heightIdx == 1`) or the leftmost column (`widthIdx == 1`). If so, it
	   means that there is only one way to reach that cell, either by moving right or moving down. Therefore, it sets `numberOfWays[heightIdx][widthIdx]` to 1.

	5. If the cell is not on the top row or the leftmost column, it means that it can be reached by either moving from the
	   cell above (up) or the cell to the left (left). The number of ways to reach the current cell is the sum of the number of
	   ways to reach the cell above and the number of ways to reach the cell to the left. This value is stored in
	  `numberOfWays[heightIdx][widthIdx]`.

	6. After iterating over all cells, the function returns the value stored in the bottom-right corner of `numberOfWays`,
	   which represents the total number of ways to traverse the graph.

	The algorithm uses dynamic programming to build the `numberOfWays` matrix iteratively, starting from the top-left corner
	and moving towards the bottom-right corner. By calculating the number of ways to reach each cell based on the number of ways to reach its neighboring cells, it avoids redundant calculations and computes the result efficiently.

	The time complexity of the algorithm is O(width * height) since it iterates over all cells of the graph.

	The space complexity is also O(width * height) since it uses the `numberOfWays` matrix to store intermediate results.


*/

int numberOfWaysToTraverseGraph(int width, int height) {
    // Create a 2D vector to store the number of ways to reach each cell
    vector<vector<int>> numberOfWays(height, vector<int>(width, 1));

    // Iterate through the cells from top to bottom and left to right
    for (int i = 1; i < height; i++) {
        for (int j = 1; j < width; j++) {
            // Calculate the number of ways to reach the current cell
            // by summing the number of ways from the cell above and the cell to the left
            numberOfWays[i][j] = numberOfWays[i - 1][j] + numberOfWays[i][j - 1];
        }
    }

    // Return the number of ways to reach the bottom-right corner of the graph
    return numberOfWays[height - 1][width - 1];
}



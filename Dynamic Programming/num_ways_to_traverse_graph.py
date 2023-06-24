'''
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

'''

def number_of_ways_to_traverse_graph(width, height):
    # Initialize the numberOfWays matrix with dimensions (height+1) x (width+1)
    # The extra "+1" is to account for the boundary cases when traversing the graph
    numberOfWays = [[0] * (width + 1) for _ in range(height + 1)]

    # Iterate over the graph cells
    for widthIdx in range(1, width + 1):
        for heightIdx in range(1, height + 1):
            # Check if the current cell is on the top row or the leftmost column
            if widthIdx == 1 or heightIdx == 1:
                # If so, there is only one way to reach this cell (moving right or moving down)
                numberOfWays[heightIdx][widthIdx] = 1
            else:
                # If the cell is not on the top row or the leftmost column,
                # calculate the number of ways to reach this cell based on the
                # number of ways to reach the cell above (up) and the cell to the left (left)
                waysLeft = numberOfWays[heightIdx][widthIdx - 1]
                waysUp = numberOfWays[heightIdx - 1][widthIdx]
                numberOfWays[heightIdx][widthIdx] = waysLeft + waysUp

    # Return the number of ways to reach the bottom-right corner of the graph
    return numberOfWays[height][width]

'''
	Combinatorics Solution

	The given code snippet aims to calculate the number of ways to traverse a graph from the top-left corner to the bottom-right 
	corner. Let's break down the solution and provide a detailed explanation:

	1. The `NumberOfWaysToTraverseGraph` function takes two parameters: `width` and `height`, representing the dimensions of 
	   the graph.

	2. The variables `xDistanceToCorner` and `yDistanceToCorner` are calculated by subtracting 1 from the `width` and `height` 
	   respectively. These variables represent the distances from the top-left corner to the bottom-right corner along the x-axis and y-axis.

	3. The `factorial` function is defined separately to calculate the factorial of a number. It takes a number `num` as input 
	   and uses an iterative approach to calculate the factorial.

	4. In the `NumberOfWaysToTraverseGraph` function, the numerator is calculated as the factorial of the sum of 
	   `xDistanceToCorner` and `yDistanceToCorner`. This represents the total number of possible paths from the top-left 
	   corner to the bottom-right corner.

	5. The denominator is calculated as the product of the factorials of `xDistanceToCorner` and `yDistanceToCorner`. 
	   This represents the number of ways to arrange the steps along the x-axis and y-axis.

	6. Finally, the function returns the result by dividing the numerator by the denominator, giving the total number of 
	   ways to traverse the graph.

	The solution relies on the concept of combinatorics, specifically the binomial coefficient, to calculate the number of 
	ways to traverse the graph. By using factorials, it accounts for all possible paths and eliminates duplicate paths. 
	This approach provides an efficient solution to the problem.

	O(n + m) time | O(1) space - where n is the width of the graph and m is the height
'''

import math

def number_of_ways_to_traverse_graph_combinatorics(width, height):
    # Calculate the distance to the bottom-right corner of the graph
    x_distance_to_corner = width - 1
    y_distance_to_corner = height - 1

    # Calculate the number of ways to traverse the graph using combinatorics
    # by calculating the binomial coefficient of (x_distance_to_corner + y_distance_to_corner) choose x_distance_to_corner
    # where (n choose k) = n! / (k! * (n-k)!)
    numerator = math.factorial(x_distance_to_corner + y_distance_to_corner)
    denominator = math.factorial(x_distance_to_corner) * math.factorial(y_distance_to_corner)

    # Return the result by dividing the numerator by the denominator
    return numerator // denominator

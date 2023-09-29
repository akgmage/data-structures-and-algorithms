'''
Explanation:

1. The function `JuiceBottling` takes an array `prices` as input, where `prices[i]` represents the price of a juice bottle of size `i`.

2. It initializes two arrays, `maxProfit` and `dividingPoints`, both of size `numSizes` (the number of bottle sizes).
These arrays will be used to store information about maximum profit and dividing points.

3. The outer loop iterates through each possible bottle size, from 0 to `numSizes - 1`.

4. The inner loop iterates through possible dividing points for the current bottle size. For each combination of bottle size
and dividing point, it calculates the possible profit by adding the maximum profit from the previous bottle sizes and the
price of the bottle at the current dividing point.

5. If the calculated possible profit is greater than the current maximum profit for the bottle size, it updates both `maxProfit`
and `dividingPoints` arrays.

6. After completing the loops, the function reconstructs the solution by backtracking from the last bottle size to the first.
It appends the recorded dividing points to the `solution` array, which represents the optimal way to divide the bottles.

7. The function returns the `solution` array, which contains the indices of the dividing points that maximize profit.

In summary, the code uses dynamic programming to determine the optimal division of juice bottles to maximize profit.
It calculates the maximum profit for each bottle size and keeps track of the dividing points that lead to the maximum profit.
The solution is then reconstructed by backtracking from the end using the recorded dividing points.

'''
def juice_bottling(prices):
    num_sizes = len(prices)
    max_profit = [0] * num_sizes         # List to store the maximum profit for each bottle size
    dividing_points = [0] * num_sizes    # List to store the dividing points that maximize profit

    # Loop through each bottle size
    for size in range(num_sizes):
        # Loop through possible dividing points for the current size
        for dividing_point in range(size + 1):
            # Calculate the possible profit by combining the previous maximum profit
            # with the price at the current dividing point
            possible_profit = max_profit[size - dividing_point] + prices[dividing_point]

            # Update max_profit and dividing_points if the new possible profit is greater
            if possible_profit > max_profit[size]:
                max_profit[size] = possible_profit
                dividing_points[size] = dividing_point

    solution = []
    current_dividing_point = num_sizes - 1
    # Reconstruct the solution by tracing back from the end
    # using the dividing points information
    while current_dividing_point > 0:
        solution.append(dividing_points[current_dividing_point])
        current_dividing_point -= dividing_points[current_dividing_point]
    return solution

# Example usage:
prices = [3, 5, 8, 9, 10, 17, 17, 20]
result = juice_bottling(prices)
print("Dividing Points for Maximum Profit:", result)

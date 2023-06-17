'''
	Given an array of distinct positive integers representing coin denominations and a single non-negative integer n
	representing a target amount of money, write a function that returns the number of ways to make change for
	that target amount using the given coin denominations.

	Sample Input: n = 6 denominations : [1, 5]
	Output: 2 (1 * 1 + 1 * 5 and  6 * 1)

	Explanation:

	The given code snippet is implementing the "NumberOfWaysToMakeChange" algorithm in Go.
	This algorithm calculates the number of ways to make change for a given amount using a set of denominations.

	Here's how the algorithm works:

	1. The function "NumberOfWaysToMakeChange" takes two parameters: "n" (the target amount to make change for) and "denoms"
	(an array of coin denominations).

	2. It initializes an array called "ways" of size "n+1" to keep track of the number of ways to make change for each amount
	from 0 to "n". The initial value of "ways[0]" is set to 1, representing the base case where there is one way to make
	change for zero.

	3. The algorithm iterates over each denomination in the "denoms" array using a for-each loop.

	4. For each denomination, it further iterates from 1 to "n+1" to calculate the number of ways to make change for each
	amount.

	5. Inside the inner loop, it checks if the current denomination is less than or equal to the current amount. If so,
	it means that the current denomination can contribute to the change for the current amount.

	6. It then updates the "ways[amount]" value by adding the number of ways to make change for the current amount minus
	the current denomination. This is done to accumulate all the possible ways to make change using the current denomination.

	7. After completing the nested loops, the algorithm returns the value stored in "ways[n]", which represents the total
	number of ways to make change for the target amount "n" using the given denominations.

	In summary, this algorithm utilizes dynamic programming to calculate the number of ways to make change for a given
	amount using a set of denominations. By iteratively building up the solutions for smaller amounts, it efficiently computes the result in O(n * m) time complexity, where "n" is the target amount and "m" is the number of denominations. The space complexity is O(n), as the algorithm uses an array of size "n+1" to store the intermediate results.

	Time complexity : O(nd)
	Space complexity : O(n) where n is the target amount and d is the number of coin denominations
'''
def number_of_ways_to_make_change(n, denoms):
    # Create a list to store the number of ways to make change for each amount from 0 to n.
    ways = [0] * (n + 1)

    # Initialize the base case: There is one way to make change for amount 0 (using no coins).
    ways[0] = 1

    # Iterate over each denomination.
    for denom in denoms:
        # For each denomination, iterate over each amount from 1 to n.
        for amount in range(1, n + 1):
            # Check if the denomination can be used to make change for the current amount.
            if denom <= amount:
                # Add the number of ways to make change for the current amount
                # by considering the current denomination.
                ways[amount] += ways[amount - denom]

    # Return the number of ways to make change for the target amount n.
    return ways[n]


# Example usage
n = 10
denoms = [1, 2, 5]

number_of_ways = number_of_ways_to_make_change(n, denoms)
print("Number of ways to make change:", number_of_ways)

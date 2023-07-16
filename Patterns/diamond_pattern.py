'''
Approach:
- The code above prints a diamond pattern with `n` rows. The approach used is to iterate through each row of the diamond pattern, calculate the number of spaces and asterisks in each row based on the current row number, and then print the spaces and asterisks accordingly.
- In the upper half of the diamond, the number of spaces decreases by 1 and the number of asterisks increases by 2 in each row. In the lower half of the diamond, the number of spaces increases by 1 and the number of asterisks decreases by 2 in each row.

Sample input: `4`, the function `print_diamond_pattern(4)`

Sample Output:
   *
  ***
 *****
*******
 *****
  ***
   *

Time Complexity: The time complexity of this code is O(n^2), where n is the input parameter representing the number of rows in the diamond pattern. This is because we need to loop through each row and perform a constant number of operations for each row.

Space Complexity: The space complexity of this code is O(1), as we are not using any additional data structures whose space requirements depend on the input size.

NOTE: This code assumes that the input `n` is a positive integer greater than 0. It does not handle invalid inputs or edge cases where `n` is negative or zero.
'''

def print_diamond_pattern(n):
    # Calculate the number of rows in the diamond pattern
    num_rows = 2 * n - 1

    # Iterate through each row of the diamond pattern
    for i in range(num_rows):

        # Calculate the number of spaces and asterisks in each row
        if i < n:  # Upper half of the diamond
            num_spaces = n - i - 1
            num_asterisks = 2 * i + 1
        else:  # Lower half of the diamond
            num_spaces = i - n + 1
            num_asterisks = 2 * (num_rows - i) - 1

        # Print the spaces before the asterisks
        for _ in range(num_spaces):
            print(" ", end="")

        # Print the asterisks
        for _ in range(num_asterisks):
            print("*", end="")

        # Move to the next line
        print()

# Testing the function with a sample input
print_diamond_pattern(4)


'''
Problem: Python program to generate a hollow pattern using asterisks ('*'). The program will take an integer 'n' as input, which represents the size of the pattern, and it will produce a hollow pattern of the given size.

Approach:
1. We will iterate through rows and columns and print '*' at specific positions to form the hollow pattern.
2. For each row, we will check if it's the first row, last row, first column, or last column. If so, we will print a '*' character. Otherwise, we will print a space ' '.
3. This way, we will create the desired hollow pattern.

Time Complexity: O(n^2)
- The program uses two nested loops to print the pattern, one for rows and one for columns. So, the time complexity is proportional to the square of 'n'.

Space Complexity: O(1)
- The program uses a constant amount of extra space, as it only prints characters and does not use any additional data structures that depend on the input size 'n'.

Sample Input: 8
Sample Output:
```
* * * * * * * * 
*             * 
*             * 
*             * 
*             * 
*             * 
*             * 
* * * * * * * *
```

In this example, the input 'n' is 8, and the program generates a hollow pattern of size 8x8 using asterisks.
'''

def print_hollow_pattern(n):
    # Iterate through each row
    for i in range(n):
        # Iterate through each column in the row
        for j in range(n):
            # Check if it's the first row, last row, first column, or last column
            if i == 0 or i == n - 1 or j == 0 or j == n - 1:
                print('*', end=' ')
            else:
                print(' ', end=' ')
        # Move to the next line after each row is printed
        print()
      
# Sample input: n = 5
# Expected output:
# * * * * * 
# *       * 
# *       * 
# *       * 
# * * * * *
print_hollow_pattern(5)


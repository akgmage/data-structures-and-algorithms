'''
Explanation:
1. The code defines a function `print_triangular_pattern()` that takes a parameter `n`. This parameter determines the number of rows in the triangular pattern.
2. Inside the function, `num` is initialized to 1, which is the starting number of the pattern.
3. The code then uses nested loops. The outer loop runs from 1 to `n`, which represents the number of rows.
4. The inner loop runs from 1 to the current row number (i). It prints the numbers in each row in increasing order.
5. After printing all the numbers in a row, the code moves to the next line using `print()` to create a new row.
6. Ultimately, the pattern is printed as a set of rows, forming a triangular shape.

Time Complexity: The time complexity of this code is O(n^2), where n is the number of rows. This is because we have two nested loops, one iterating n times and the other iterating up to the current row number.

Space Complexity: The space complexity of this code is O(1), as we are not using any additional data structures that depend on the input size.

Sample Input:
n = 5

Sample Output:
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15

'''

#code in Python that prints a number pattern in a triangular pattern starting from 1:

def print_triangular_pattern(n):
    num = 1  # Initialize the starting number

    for i in range(1, n + 1):  # Iterate through each row
        for j in range(1, i + 1):  # Print numbers in each row
            print(num, end=" ")
            num += 1  # Increment the number for the next iteration
        print()  # Move to the next line after each row


# Example usage
n = 5
print_triangular_pattern(n)



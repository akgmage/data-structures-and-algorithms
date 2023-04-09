# Rotate clockwise and anti-clockwise
'''
    The rotate_clockwise() function takes a matrix as input and returns the matrix rotated by 90 degrees 
    clockwise. It does this by first transposing the matrix (swapping the elements across the diagonal), 
    and then reversing each row of the transposed matrix.

    The rotate_counterclockwise() function takes a matrix as input and returns the matrix rotated by 90 
    degrees counterclockwise. It also transposes the matrix first, and then reverses each column of 
    the transposed matrix.

    Both functions use two nested loops to iterate through the matrix and perform the required operations. 
    The n variable represents the size of the matrix, and is used to control the range of the loops.
'''
def rotate_clockwise(matrix):
    """
    Function to rotate the given matrix by 90 degrees clockwise
    """
    n = len(matrix)
    # Transpose the matrix
    for i in range(n):
        for j in range(i, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

    # Reverse each row to get the final rotated matrix
    for i in range(n):
        matrix[i] = matrix[i][::-1]

    return matrix


def rotate_counterclockwise(matrix):
    """
    Function to rotate the given matrix by 90 degrees counterclockwise
    """
    n = len(matrix)
    # Transpose the matrix
    for i in range(n):
        for j in range(i, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

    # Reverse each column to get the final rotated matrix
    for i in range(n//2):
        for j in range(n):
            matrix[j][i], matrix[j][n-i-1] = matrix[j][n-i-1], matrix[j][i]

    return matrix

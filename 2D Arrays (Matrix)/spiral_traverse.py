##### LEETCODE 54. Spiral Matrix ####

##### INPUT OUTPUT #####

# Given an m x n matrix, return all elements of the matrix in spiral order.
# Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
# Output: [1,2,3,6,9,8,7,4,5]
# Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
# Output: [1,2,3,4,8,12,11,10,9,5,6,7]
# Write python code along with explanation and comments use meaningful variables

##### EXPLAINATION #####

# The given problem statement is to return all elements of the matrix in spiral order. We can start by defining the four boundaries of the matrix - top, bottom, left and right. We can then traverse the matrix in a spiral order by following these four steps:

# Traverse from left to right along the top boundary
# Traverse from top to bottom along the right boundary
# Traverse from right to left along the bottom boundary
# Traverse from bottom to top along the left boundary
# After each traversal, we need to update the corresponding boundary and change the direction of traversal.

# We can implement this algorithm using a while loop that runs as long as the top boundary is less than or equal to the bottom boundary and the left boundary is less than or equal to the right boundary. Within the while loop, we can use an if-else ladder to check the current direction of traversal and perform the corresponding traversal along the boundary.

# Finally, we can return the result list containing all the spiral order elements of the matrix.


#### DRY RUN: ####

# Initially, we have the matrix:
# 1 2 3
# 4 5 6
# 7 8 9

# We initialize the variables top, bottom, left, and right to 0, 2, 0, and 2 respectively. We also set the direction variable to 0.
# Now, we enter the while loop since top<=bottom and left<=right.
# In the first iteration of the while loop, direction=0 means we need to traverse from left to right along the top boundary.
# We iterate the for loop from left=0 to right=2 and append the elements 1, 2, 3 to the result list. After this, we increment top by 1 to mark that the top boundary is now done.
# The result list now contains [1, 2, 3].
# In the second iteration of the while loop, direction=1 means we need to traverse from top to bottom along the right boundary.
# We iterate the for loop from top=1 to bottom=2 and append the elements 6, 9 to the result list. After this, we decrement right by 1 to mark that the right boundary is now done.
# The result list now contains [1, 2, 3, 6, 9].
# In the third iteration of the while loop, direction=2 means we need to traverse from right to left along the bottom boundary.
# We iterate the for loop from right=1 to left=0 and append the elements 8, 7 to the result list. After this, we decrement bottom by 1 to mark that the bottom boundary is now done.
# The result list now contains [1, 2, 3, 6, 9, 8, 7].
# In the fourth iteration of the while loop, direction=3 means we need to traverse from bottom to top along the left boundary.
# We iterate the for loop from bottom=1 to top=1 and append the element 4 and 5 to the result list. After this, we increment left by 1 to mark that the left boundary is now done.
# The result list now contains [1, 2, 3, 6, 9, 8, 7, 4, 5].
# Now, we have completed one full spiral traversal of the matrix. The direction variable is updated as (0+1)%4=1 which sets it to 1 for the next iteration.
# We continue with the while loop since top<=bottom and left<=right. In the second iteration, the process continues in the same way as described above until all elements of the matrix are visited.
# Finally, the function returns the result list containing all the spiral order elements of the matrix.

def spiralOrder(matrix):
    # Initialize variables to keep track of indices and boundaries
    top, bottom = 0, len(matrix) - 1
    left, right = 0, len(matrix[0]) - 1
    direction = 0  # 0 = right, 1 = down, 2 = left, 3 = up

    # Initialize an empty result list to store the spiral order elements
    result = []

    while top <= bottom and left <= right:
        if direction == 0:
            # Traverse right
            for i in range(left, right+1):
                result.append(matrix[top][i])
            top += 1
        elif direction == 1:
            # Traverse down
            for i in range(top, bottom+1):
                result.append(matrix[i][right])
            right -= 1
        elif direction == 2:
            # Traverse left
            for i in range(right, left-1, -1):
                result.append(matrix[bottom][i])
            bottom -= 1
        else:
            # Traverse up
            for i in range(bottom, top-1, -1):
                result.append(matrix[i][left])
            left += 1

        # Update direction after completing one full traversal
        direction = (direction + 1) % 4

    return result


matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print(spiralOrder(matrix))

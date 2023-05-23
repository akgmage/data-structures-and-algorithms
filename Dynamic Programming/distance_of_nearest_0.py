'''
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
 
Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.

Intuition
The goal is to get the nearest 0 for each 1. So how can we get the nearest 0 for each 1? Lets use Multisource BFS and Dynamic Programming.
Approach
To get the nearest 0 for each 1, we should treat every 0 as if they are on the same level, make a BFS on them and keep track of the distance as we go further. Since we are finding the nearest zero, we may need to use pre-calculated distances for the current 1 when all of its neighbours are all 1.
Lets see this with example!
Here is the given grid.
    0 0 0         
    0 1 0         
    1 1 1   
Then by taking all zeros and making a BFS on them, the nearest distance becomes 1 for all ones other than the back ticked 1 found on the third row.
    0 0 0         
    0 1 0         
    1 `1` 1  
The back ticked '1' is not adjacent to 0, so it should use the precalculated distance of the nearest 1 it get.
So, in here we are using precalculated values to get the nearest distance. This technique is called Dynamic programming.
Then we will get this grid by using the values we calculated for its adjacent 1
    0 0 0         
    0 1 0         
    1 2 1  
Complexity
Time complexity: O(N)
Space complexity: O(V + E)
Code
sample input and output:

1. Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
   Output: [[0,0,0],[0,1,0],[0,0,0]]

'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        # it a Multi-source BFS like 994. Rotting Oranges
        # treat every 0 as if they are on the same level and make BFS on them
        def isvalid(row, col):
            if row >= len(mat) or row < 0 or col >= len(mat[0]) or col < 0:
                return False
            return True
        
        # get every zero and add them to a queue
        q, visited = deque(), set()
        for row in range( len(mat)):
            for col in range( len(mat[0])):
                if mat[row][col] == 0:
                    q.append([row, col])
                    visited.add((row, col))
        
        level = 1 # the distance to the nearest zero starts from 1
        while q:
            size = len(q)
            for _ in range( size ):
                row, col =q.popleft()
                for r, c in [ [1, 0], [-1, 0], [0, 1], [0, -1]]:
                    newRow, newCol = row + r, col + c
                    if (newRow, newCol) not in visited and isvalid(newRow, newCol):
                        mat[newRow][newCol] = level
                        q.append([newRow, newCol])
                        visited.add( (newRow, newCol))
            level += 1
        
        return mat
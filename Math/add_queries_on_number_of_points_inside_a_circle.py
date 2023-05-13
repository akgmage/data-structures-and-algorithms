# Program Author : TheCodeVenturer[Niraj Modi]
'''
    Program Definition : Queries on Number of Points inside a circle
        Description : you are given n points in a cartesian plane [points] and a queries array
                      Where each element inside it is an array each consisting of [xj, yj, rj] where,
                      (xj,yj) is centre of the circle and rj is radius of the circle 
                      Now, you are required to find no.of points inside the circle
    
    Approach:
        The only possible soln somehow will be that you have to calculate distance of each point from the centre of each circle
        and if the distance <= radius then the point is inside the the circle else not

        Distance Formula = ((x1-x2)**2 + (y1-y2)**2)**(1/2)
    Complexity:
		The time complexity of this solution is O(m*n) where m = points.length and n = queries.length 
		The space complexity is O(1),we are not using any Auxiliary Spaces.
    Sample input/outputs:
		Example 1:
		Input: 
            points = [[1,3],[3,3],[5,3],[2,2]]
            queries = [[2,3,1],[4,3,1],[1,1,2]]
		Output: [3,2,2]
		Example 1:
		Input: 
            points = [[1,1],[2,2],[3,3],[4,4],[5,5]]
            queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
		Output: [2,3,2,4]
'''
class Solution:
    def countPoints(self, points: list[list[int]], queries: list[list[int]]) -> list[int]:
        sol :list = []  #Initialising solution array
        for x1,y1,r in queries:
            count:int=0     #no.of points inside that circle is initially zero
            for x2,y2 in points:
                d = ((x2-x1)**2 + (y2-y1)**2)**(1/2)  #calculating distance between the points
                if(d<=r):        #if it is <= radius it is inside the circle
                    count+=1
            sol.append(count)       #finally add the count to solution array
        return sol
    

points = [[1,3],[3,3],[5,3],[2,2]]
queries = [[2,3,1],[4,3,1],[1,1,2]]
print(Solution().countPoints(points,queries))
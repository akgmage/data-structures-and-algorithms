'''
    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

    The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

    Example 1:
    Input: points = [[1,3],[-2,2]], k = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
    
    Example 2:
    Input: points = [[3,3],[5,-1],[-2,4]], k = 2
    Output: [[3,3],[-2,4]]
    Explanation: The answer [[-2,4],[3,3]] would also be accepted.
    
    Constraints:
    1 <= k <= points.length <= 104
    -104 < xi, yi < 104
'''
import math
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        distance_arr=[]
        #calculating the distance from center
        for i in points:
            distance_arr.append(math.sqrt(pow(i[0],2)+pow(i[1],2)))
        #Mapping the values of distance and point
        #Also considering the collision if two points have same distance from origin
        hash_map={}
        for i in range(len(points)):
            if(distance_arr[i] in hash_map):
                hash_map[distance_arr[i]].append(points[i])
            else:
                hash_map[distance_arr[i]] = [points[i]]

        #sorting distances
        distance_arr.sort()

        #Retrieving the values in the order of distance from distance_arr
        final_arr,count = [],0
        for i in range(len(points)):
            for j in hash_map[distance_arr[i]]:
                final_arr.append(j)
                count+=1
            if(count>=k):
                break
        return final_arr
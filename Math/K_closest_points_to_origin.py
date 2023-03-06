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
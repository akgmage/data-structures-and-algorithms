#Program Author : TheCodeVenturer [Niraj Modi]
'''
    Problem definition:
		Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
		and return an array of the non-overlapping intervals that cover all the intervals in the input.

    Approach:
        The Approach to this problem is that it will be more easier if we start merging the time linear increasing fashion
        To Make It in Linear Increasing Fashion We will Sort the Array 
        Then will initialise a new mergeIntervals Array. Here, sol
        then will pick the first starting and ending point and will iterate through the array .Here, start,end
        and insert it if the new start time is Greater then previous one(end) or will merge it with previous Start Time,end Time(start,end).
        and at finally when the loop is over again will insert the start and end for the final Interval
        then Will the mergedIntervals Array
    Complexity:
        Time Complexity: O(n logn) for sorting the array and additional O(n) for the complete iteration
                All Over It will be O(n logn)
        Space Complexity: O(1) as we are not using any extra Spaces
                Space to Store Solution is not counted in Space complexity
    Sample input/outputs:
		Example 1:
		Input: [[1,9],[4,5]]
		Output: [[1,9]]

		Example 2:
		Input: [[1,3],[2,6],[8,10],[9,12]]
		Output: [[1,6],[8,12]]

		Example 3:
		Input: [[1,4],[0,2]]
		Output: [[0,4]]
'''

class Solution(object):
    def mergeIntervals(self, Intervals):
        Intervals.sort()   # Sorting the Intervals to make the Array in Linear Increasing Fashion             
        sol = []            # MergedIntervals Array Initialisation
        start = Intervals[0][0]   
        end = Intervals[0][1]
        #setting up the first start and end Point
        for [l, u] in Intervals:
            # if l (current start) is Greater then previous end then will add it to mergedIntervals Array
            # else will update the end with the greater end that is max(end,u)
            if (l > end):
                sol.append([start, end])
                start, end = l, u
            else:
                end = max(end, u)
        #finally adding the final start and end point to sol
        sol.append([start, end])
        return sol
if __name__ == "__main__":
    Intervals = [[1,3],[2,6],[8,10],[9,12]]
    sol = Solution()
    print(sol.mergeIntervals(Intervals))

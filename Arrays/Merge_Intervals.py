#Program Author : TheCodeVenturer [Niraj Modi]
'''
    Problem definition:
		Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
		and return an array of the non-overlapping intervals that cover all the intervals in the input.

    
'''

class Solution:
    def mergeIntervals(self, Intervals):
        Intervals.sort()                
        sol = []
        start = Intervals[0][0]
        end = Intervals[0][1]
        for [l, u] in Intervals:
            if (l > end):
                sol.append([start, end])
                start, end = l, u
            else:
                end = max(end, u)
        sol.append([start, end])
        return sol

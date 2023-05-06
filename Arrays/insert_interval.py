# 57. Insert Interval
# You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
# Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
# Return intervals after the insertion.
# Example 1:
# Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
# Output: [[1,5],[6,9]]
# Example 2:
# Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
# Output: [[1,2],[3,10],[12,16]]
# Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

# CODE Explaination
# The function insert takes two arguments, intervals which is a list of non-overlapping intervals and newInterval which is another interval that needs to be inserted into intervals.
# The variable n holds newInterval. The variable j holds intervals. The variables m and m1 are initialized with the start and end points of newInterval, respectively. The variable i is used to iterate through the intervals in j.
# The while loop checks if newInterval overlaps with any interval in intervals. If there is an overlap, we update m and/or m1 to include all overlapping intervals.
# If there is an overlap, the overlapping interval is removed from j using the pop method. If an interval is removed, we decrement i by 1 so that we don't skip any intervals.
# If there is no overlap, we increment i by 1 so that we can move on to the next interval in j.
# Once all overlaps are handled, we create a new interval s1=[m,m1] which is the combination of all overlapping intervals and newInterval. We append this new combined interval to j and sort it in ascending order based on the start point of each interval.
# Finally, we return j, which is the updated list of non-overlapping intervals.

# Now let's do a dry run of the first example:
# intervals = [[1,3], [6,9]]
# newInterval = [2,5]
# result = insert(intervals, newInterval)
# print(result)
# Initially, n = [2,5], j = [[1,3], [6,9]], i = 0, m = 2, and m1 = 5.

# First iteration of the while loop:

# We check if n overlaps with [1,3]. Since there is an overlap, we update m to 1 and keep m1 as 5.
# We remove [1,3] from j using the pop method and append [1,5] to j, so j becomes [[6,9], [1,5]].
# We decrement i to -1 since we removed an element from j.
# Second iteration of the while loop:

# We check if n overlaps with [6,9]. Since there is no overlap, we increment i to 0 to move on to the next interval in j.
# Third iteration of the while loop:

# We check if n overlaps with [1,5]. Since there is an overlap, we update m to 1 and keep m1 as 5.
# We remove [1,5] from j using the pop method and append [1,5] to j, so j remains [[6,9], [1,5]].
# We decrement i to 0 since we removed an element from j.
# Since we have checked all intervals in j, we exit the while loop.

# We create a new interval s1=[1,5] which is the combination of [1,3] and [2,5]. We append s1 to j so j becomes [[6,9], [1,5]].

# Finally, we sort j in ascending order based on the start point of each interval. The sorted list is [[1,5], [6,9]].
# We return j which is the updated list of non-overlapping intervals after inserting newInterval. Therefore, the output of this function for the input intervals = [[1,3], [6,9]], newInterval = [2,5] is [[1,5],[6,9]].
# Code
from typing import List


def insert(intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
    # Assign variables for easier readability
    n = newInterval
    j = intervals
    i = 0
    m = n[0]  # Initialize starting point of the interval to be inserted
    m1 = n[1]  # Initialize ending point of the interval to be inserted

    # Iterate over all existing intervals
    while i < len(j):
        # If any part of the new interval overlaps with the current interval
        if n[0] in range(j[i][0], j[i][1]+1) or n[1] in range(j[i][0], j[i][1]+1) or (n[1] >= j[i][1] and n[0] <= j[i][0]):
            # Expand the new interval to include the current interval
            if j[i][0] < m:
                m = j[i][0]
            if j[i][1] > m1:
                m1 = j[i][1]
            # Remove the current interval from the list and adjust the index accordingly
            j.pop(i)
            if i <= 0:
                i = 0
            else:
                i -= 1
        else:
            i += 1  # Move to the next interval if there is no overlap

    # Create the final interval by combining all intervals that overlap with the new interval
    s1 = [m, m1]
    j.append(s1)
    j.sort()  # Sort the final list of intervals by their starting points
    return j


# Example usage
intervals = [[1, 3], [6, 9]]
newInterval = [2, 5]
result = insert(intervals, newInterval)
print(result)
# Output: [[1,5],[6,9]]

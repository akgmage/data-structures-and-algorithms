/*
   Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
   and return an array of the non-overlapping intervals that cover all the intervals in the input.

   Sample Input: [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]
   Output: [[1, 2], [3, 8], [9, 10]]

   Explanation:

   The function takes an array of intervals as input.
   First, a copy of the input intervals is made and sorted by the start time of each interval. This is stored in a
   temporary variable called sortedIntervals.
   A new array called mergedIntervals is created to store the merged intervals. The first interval in sortedIntervals
   is added to mergedIntervals to start the merging process.
   Next, a loop iterates through each interval in sortedIntervals. For each interval, the start and end times of
   the current interval and the next interval are compared. If they overlap, the end time of the current interval
   is updated to the maximum of the two end times.
   If they don't overlap, the next interval becomes the current interval and is added to mergedIntervals.
   The loop continues until all intervals have been compared and merged, and the final mergedIntervals array
   is returned.
   To find the maximum of two numbers, the function uses a helper function called max. This function simply
   compares the two numbers and returns the greater one.

   Time complexity O(nlog(n))
   Space complexity: | O(n) where n is the length of the input array
*/
package main

import "sort"

// function to merge overlapping intervals
func MergeOverlappingIntervals(intervals [][]int) [][]int {

    // make a copy of the input intervals to sort
    sortedIntervals := make([][]int, len(intervals))
    copy(sortedIntervals, intervals)

    // sort the intervals by their start time
    sort.Slice(sortedIntervals, func(i, j int) bool {
        return sortedIntervals[i][0] < sortedIntervals[j][0]
    })

    // create an empty list to store the merged intervals
    mergedIntervals := make([][]int, 0)

    // set the current interval to the first interval in the sorted list
    currentInterval := sortedIntervals[0]

    // add the current interval to the merged intervals list
    mergedIntervals = append(mergedIntervals, currentInterval)

    // loop through the sorted intervals starting from the second interval
    for _, nextInterval := range sortedIntervals[1:] {

        // print the start and end time of the next interval (for debugging purposes)
        print(nextInterval[0], " ", nextInterval[1], "-->")

        // get the end time of the current interval and the start and end time of the next interval
        currentIntervalEnd := currentInterval[1]
        nextIntervalStart, nextIntervalEnd := nextInterval[0], nextInterval[1]

        // if the end time of the current interval is greater than or equal to the start time of the next interval,
        // then the two intervals overlap and should be merged
        if currentIntervalEnd >= nextIntervalStart {

            // set the end time of the current interval to the maximum of its current end time and the end time of the next interval
            currentInterval[1] = max(currentIntervalEnd, nextIntervalEnd)

        } else {
            // if the two intervals do not overlap, then the next interval becomes the new current interval and is added to the merged intervals list
            currentInterval = nextInterval
            mergedIntervals = append(mergedIntervals, currentInterval)
        }
    }

    // return the list of merged intervals
    return mergedIntervals
}

// function to return the maximum of two integers
func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

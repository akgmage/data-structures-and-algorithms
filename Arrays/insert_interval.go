// 57. Insert Interval
// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
// Return intervals after the insertion.
// Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

// CODE EXPLAINATION WITH DRY RUN:
// The insert function takes in two inputs: an array of non-overlapping intervals represented as an array of arrays of integers (intervals), and a single interval represented as an array of integers (newInterval). The function returns the updated intervals after inserting the new interval such that the intervals remain sorted by the start value and do not overlap.

// The function first initializes some variables:

// n: the new interval
// j: the array of existing intervals
// i: a counter variable initialized to 0
// m: the starting point of the new interval; initially set to the starting point of n
// m1: the ending point of the new interval; initially set to the ending point of n
// The function then enters a loop that iterates through each interval in the array of existing intervals j. For each iteration, it checks if the new interval overlaps with the current interval. An overlap occurs if any of the following conditions are met:

// The starting point of the new interval is between the starting and ending points of the current interval
// The ending point of the new interval is between the starting and ending points of the current interval
// The new interval completely engulfs the current interval
// If an overlap is detected, the function updates the starting point and ending point of the new interval (m and m1) based on the starting and ending points of the current interval (j[i][0] and j[i][1], respectively). It then removes the current interval from the array of existing intervals j using the append function with a slice operation that excludes the current element (append(j[:i], j[i+1:]...)) and decrements the counter variable i so that the loop will consider the next interval after removing the current one.

// After iterating through all intervals in j, the function appends the new interval represented by [m, m1] to the end of the j array using the append function. Finally, the intervals in the array are sorted based on their starting points using two nested loops that swap elements if they are not in order.

// Now, let's do a dry run of the example input and output:

// Input:

// intervals = [[1,3],[6,9]]
// newInterval = [2,5]
// The initial values of variables are:

// n = [2,5]
// j = [[1,3],[6,9]]
// i = 0
// m = 2
// m1 = 5
// In the first iteration of the loop, the current interval is [1,3]. Since n overlaps with this interval, m is updated to 1 and m1 is updated to 5. The current interval is removed from j, which becomes [[6,9]]. The counter variable i is decremented to account for the removal, making its value -1. In the next iteration of the loop, i is incremented to 0, so the current interval is [6,9]. Since there is no overlap between n and this interval, nothing happens. The loop exits, and the updated j array is [[1,5],[6,9]], which matches the expected output.

// Thus, the function correctly inserts the new interval and sorts the resulting array.

package main

import "fmt"

func insert(intervals [][]int, newInterval []int) [][]int {
    n := newInterval
    j := intervals
    i := 0
    m := n[0]  // Initialize starting point of the interval to be inserted
    m1 := n[1]  // Initialize ending point of the interval to be inserted

    for i < len(j) {
        if n[0] >= j[i][0] && n[0] <= j[i][1] || n[1] >= j[i][0] && n[1] <= j[i][1] || n[0] <= j[i][0] && n[1] >= j[i][1] {
            if j[i][0] < m {
                m = j[i][0]
            }
            if j[i][1] > m1 {
                m1 = j[i][1]
            }
            j = append(j[:i], j[i+1:]...)
            i--
        }
        i++
    }
    s1 := []int{m, m1}
    j = append(j, s1)
    for i := 0; i < len(j); i++ {
        for k := i + 1; k < len(j); k++ {
            if j[i][0] > j[k][0] {
                j[i], j[k] = j[k], j[i]
            }
        }
    }
    return j
}

func main() {
    intervals := [][]int{{1, 3}, {6, 9}}
    newInterval := []int{2, 5}
    result := insert(intervals, newInterval)
    fmt.Println(result)
}

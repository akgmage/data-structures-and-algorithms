package main

import (
	"fmt"
)

// Interval represents an interval with a start and end value.
type Interval struct {
	Start int
	End   int
}

// insert merges a new interval into a sorted list of intervals.
func insert(intervals []Interval, newInterval Interval) []Interval {
	result := make([]Interval, 0)
	i := 0

	// Add intervals that end before the new interval starts
	for i < len(intervals) && intervals[i].End < newInterval.Start {
		result = append(result, intervals[i])
		i++
	}

	// Merge intervals that overlap with the new interval
	for i < len(intervals) && intervals[i].Start <= newInterval.End {
		newInterval.Start = min(newInterval.Start, intervals[i].Start)
		newInterval.End = max(newInterval.End, intervals[i].End)
		i++
	}

	// Add the merged new interval
	result = append(result, newInterval)

	// Add remaining intervals
	for i < len(intervals) {
		result = append(result, intervals[i])
		i++
	}

	return result
}

// min returns the minimum of two integers.
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// max returns the maximum of two integers.
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	intervals := []Interval{
		{1, 3},
		{6, 9},
	}
	newInterval := Interval{2, 5}

	result := insert(intervals, newInterval)
	fmt.Println("Merged Intervals:", result)
}

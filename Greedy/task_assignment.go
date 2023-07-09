import "sort"

// TaskAssignment pairs tasks from the given list based on their durations.
// It returns a list of paired task indices.
func TaskAssignment(k int, tasks []int) [][]int {
	// Initialize variables
	pairedTasks := make([][]int, 0)
	taskDurationToIndices := getTaskDurationToIndices(tasks)
	sort.Ints(tasks)
	var task1Idx, task2Idx int

	// Pair tasks
	for idx := 0; idx < k; idx++ {
		// Get the shortest duration task
		task1Duration := tasks[idx]
		indicesWithTask1Duration := taskDurationToIndices[task1Duration]
		task1Idx, taskDurationToIndices[task1Duration] = indicesWithTask1Duration[len(indicesWithTask1Duration)-1], indicesWithTask1Duration[:len(indicesWithTask1Duration)-1]

		// Get the longest duration task
		task2SortedIndex := len(tasks) - 1 - idx
		task2Duration := tasks[task2SortedIndex]
		indicesWithTask2Duration := taskDurationToIndices[task2Duration]
		task2Idx, taskDurationToIndices[task2Duration] = indicesWithTask2Duration[len(indicesWithTask2Duration)-1], indicesWithTask2Duration[:len(indicesWithTask2Duration)-1]

		// Add the paired tasks to the result
		pairedTasks = append(pairedTasks, []int{task1Idx, task2Idx})
	}

	return pairedTasks
}

// getTaskDurationToIndices creates a map that maps each task duration to a list of indices
// where tasks with that duration occur in the given tasks list.
func getTaskDurationToIndices(tasks []int) map[int][]int {
	taskDurationToIndices := map[int][]int{}

	for idx := range tasks {
		taskDuration := tasks[idx]
		taskDurationToIndices[taskDuration] = append(taskDurationToIndices[taskDuration], idx)
	}

	return taskDurationToIndices
}

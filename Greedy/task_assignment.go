package main

import "sort"
func TaskAssignment(k int, tasks []int) [][]int {
	pairedTasks := make([][]int, 0)
    taskDurationToIndices := getTaskDurationToIndices(tasks)
    sort.Ints(tasks)

    var task1Idx, task2Idx int
    for idx := 0; idx < k; idx++ {
        task1Duration := tasks[idx]
        indicesWithTask1Duration := taskDurationToIndices[task1Duration]
        task1Idx , taskDurationToIndices[task1Duration] = 
            indicesWithTask1Duration[len(indicesWithTask1Duration) - 1], 
            indicesWithTask1Duration[:len(indicesWithTask1Duration) - 1]

        task2SortedIndex := len(tasks) - 1 - idx
        task2Duration := tasks[task2SortedIndex]
        indicesWithTask2Duration := taskDurationToIndices[task2Duration]
        task2Idx, taskDurationToIndices[task2Duration] =
            indicesWithTask2Duration[len(indicesWithTask2Duration) - 1],
            indicesWithTask2Duration[:len(indicesWithTask2Duration) - 1]
        pairedTasks = append(pairedTasks, []int{task1Idx, task2Idx})
    }
    return pairedTasks
}

func getTaskDurationToIndices(tasks []int) map[int][]int {
    taskDurationToIndices := map[int][]int{}

    for idx := range tasks {
        taskDuration := tasks[idx]
        taskDurationToIndices[taskDuration] = append(taskDurationToIndices[taskDuration], idx) 
    }
    return taskDurationToIndices
}
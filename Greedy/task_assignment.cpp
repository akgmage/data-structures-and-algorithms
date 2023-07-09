/*
	
  	You're given an integer k  representing a number of workers and an array of positive integers representing durations of 
	tasks that must be completed by the workers. Specifically, each worker must complete two unique tasks and can only work 
	on one task at a time. The number of tasks will always be equal to 2k  such that each worker always has exactly two tasks
	to complete. All tasks are independent of one another and can be completed in any order. Workers will complete their 
	assigned tasks in parallel, and the time taken to complete all tasks will be equal to the time taken to complete
	the longest pair of tasks (see the sample output for an explanation).

  
	Write a function that returns the optimal assignment of tasks to each worker such that the tasks are completed as fast 
	as possible. Your function should return a list of pairs, where each pair stores the indices of the tasks that should 
	be completed by one worker. The pairs should be in the following format: [task1, task2] , where the order of task1 and 
	task2  doesn't matter. Your function can return the pairs in any order. If multiple optimal assignments exist, any 
	correct answer will be accepted.

	Sample Input: K = 3
	tasks : [1, 3, 5, 3, 1, 4]

	Output: [
		[0, 2],
		[4, 5],
		[1, 3]
	]

	Explanation:
	The code snippet is an implementation of the "Task Assignment" algorithm. It pairs tasks from a list based on their durations. The goal is to assign tasks to workers in a way that minimizes the total execution time.

	- The function `TaskAssignment` takes two parameters: `k` (the number of workers) and `tasks` (a list of task durations).
	- It initializes variables for `pairedTasks`, which will store the paired tasks, and `taskDurationToIndices`, which is 
	  a map that will store the indices of each task duration.
	- The `getTaskDurationToIndices` function is called to create the map `taskDurationToIndices`, which maps each task 
	  duration to a list of indices.
	- The task durations are sorted in ascending order using `sort.Ints(tasks)`. This allows us to pair the shortest and 
	  longest durations together efficiently.
	- The loop runs `k` times to pair tasks. In each iteration:
	- The shortest duration task is selected and its index is retrieved from `taskDurationToIndices`.
	- The index of the selected task is removed from the list of indices to ensure it is not paired again.
	- The longest duration task is selected in a similar manner, but from the opposite end of the sorted task durations.
	- The paired task indices are added to `pairedTasks`.
	- Finally, `pairedTasks` is returned as the result.


	The `getTaskDurationToIndices` function is a helper function that creates a map `taskDurationToIndices`, which maps each 
    task duration to a list of indices where tasks with that duration occur in the `tasks` list.

	Overall, the algorithm pairs tasks based on their durations while considering the shortest and longest durations together. 
	The result is a list of paired task indices.

	O(nlog(n)) time | O(n) space - where n is the number of tasks
*/
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

// Function to create a map that maps each task duration to a list of indices
// where tasks with that duration occur in the given tasks list.
unordered_map<int, vector<int>> getTaskDurationToIndices(vector<int>& tasks) {
    unordered_map<int, vector<int>> taskDurationToIndices;

    for (int idx = 0; idx < tasks.size(); idx++) {
        int taskDuration = tasks[idx];
        taskDurationToIndices[taskDuration].push_back(idx);
    }

    return taskDurationToIndices;
}

// Function to pair tasks from the given list based on their durations.
// It returns a vector of paired task indices.
vector<vector<int>> TaskAssignment(int k, vector<int>& tasks) {
    // Initialize variables
    vector<vector<int>> pairedTasks;
    unordered_map<int, vector<int>> taskDurationToIndices = getTaskDurationToIndices(tasks);
    sort(tasks.begin(), tasks.end());
    int task1Idx, task2Idx;

    // Pair tasks
    for (int idx = 0; idx < k; idx++) {
        // Get the shortest duration task
        int task1Duration = tasks[idx];
        vector<int>& indicesWithTask1Duration = taskDurationToIndices[task1Duration];
        task1Idx = indicesWithTask1Duration.back();
        indicesWithTask1Duration.pop_back();

        // Get the longest duration task
        int task2SortedIndex = tasks.size() - 1 - idx;
        int task2Duration = tasks[task2SortedIndex];
        vector<int>& indicesWithTask2Duration = taskDurationToIndices[task2Duration];
        task2Idx = indicesWithTask2Duration.back();
        indicesWithTask2Duration.pop_back();

        // Add the paired tasks to the result
        pairedTasks.push_back({task1Idx, task2Idx});
    }

    return pairedTasks;
}

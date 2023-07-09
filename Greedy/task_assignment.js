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
function taskAssignment(k, tasks) {
  // Initialize variables
  const pairedTasks = [];
  const taskDurationToIndices = getTaskDurationToIndices(tasks);
  tasks.sort((a, b) => a - b);
  let task1Idx, task2Idx;

  // Pair tasks
  for (let idx = 0; idx < k; idx++) {
    // Get the shortest duration task
    const task1Duration = tasks[idx];
    const indicesWithTask1Duration = taskDurationToIndices[task1Duration];
    task1Idx = indicesWithTask1Duration.pop();

    // Get the longest duration task
    const task2SortedIndex = tasks.length - 1 - idx;
    const task2Duration = tasks[task2SortedIndex];
    const indicesWithTask2Duration = taskDurationToIndices[task2Duration];
    task2Idx = indicesWithTask2Duration.pop();

    // Add the paired tasks to the result
    pairedTasks.push([task1Idx, task2Idx]);
  }

  return pairedTasks;
}

function getTaskDurationToIndices(tasks) {
  const taskDurationToIndices = {};

  for (let idx = 0; idx < tasks.length; idx++) {
    const taskDuration = tasks[idx];
    if (!taskDurationToIndices[taskDuration]) {
      taskDurationToIndices[taskDuration] = [];
    }
    taskDurationToIndices[taskDuration].push(idx);
  }

  return taskDurationToIndices;
}

const k = 3;
const tasks = [1, 3, 5, 3, 1, 4];
const pairedTasks = taskAssignment(k, tasks);

// Print the paired tasks
pairedTasks.forEach((pair) => {
  console.log(pair);
});

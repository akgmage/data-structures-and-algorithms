'''

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
'''

def task_assignment(k, tasks):
    # Initialize variables
    paired_tasks = []
    task_duration_to_indices = get_task_duration_to_indices(tasks)
    tasks.sort()
    
    for idx in range(k):
        # Get the shortest duration task
        task1_duration = tasks[idx]
        indices_with_task1_duration = task_duration_to_indices[task1_duration]
        task1_idx = indices_with_task1_duration.pop()
        
        # Get the longest duration task
        task2_sorted_index = len(tasks) - 1 - idx
        task2_duration = tasks[task2_sorted_index]
        indices_with_task2_duration = task_duration_to_indices[task2_duration]
        task2_idx = indices_with_task2_duration.pop()
        
        # Add the paired tasks to the result
        paired_tasks.append([task1_idx, task2_idx])
    
    return paired_tasks

def get_task_duration_to_indices(tasks):
    task_duration_to_indices = {}
    
    for idx in range(len(tasks)):
        task_duration = tasks[idx]
        if task_duration not in task_duration_to_indices:
            task_duration_to_indices[task_duration] = []
        task_duration_to_indices[task_duration].append(idx)
    
    return task_duration_to_indices

# Example usage
k = 3
tasks = [1, 3, 5, 3, 1, 4]
paired_tasks = task_assignment(k, tasks)

# Print the paired tasks
for pair in paired_tasks:
    print(pair)
